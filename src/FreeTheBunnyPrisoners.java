import java.util.*;

public class FreeTheBunnyPrisoners {
    private static Set<Integer> permutations = new HashSet<>();
    private static Map<Integer, Set<Integer>> bunnyToRemoveKey = new HashMap<>();
    private static int keys = 0;

    private static void getPermutations(int ind, int num_buns, int num_required) {
        if (num_required == 0) {
            for (int i : permutations) {
                bunnyToRemoveKey.get(i).add(keys);
            }
            keys++;
            return;
        }
        for (int i = ind; i < num_buns; i++) {
            permutations.add(i);
            getPermutations(i + 1, num_buns, num_required - 1);
            permutations.remove(i);
        }
    }

    public static int[][] solution(int num_buns, int num_required) {
        permutations = new HashSet<>();
        bunnyToRemoveKey = new HashMap<>();
        keys=0;

        for (int i = 0; i < num_buns; i++) {
            bunnyToRemoveKey.put(i, new HashSet<>());
        }
        getPermutations(0, num_buns, num_required - 1);
        int totalKeys = keys;

        int[][] bunnies = new int[num_buns][];
        for (int i = 0; i < num_buns; i++) {
            Set<Integer> keysToRemove = bunnyToRemoveKey.get(i);
            bunnies[i] = new int[totalKeys - keysToRemove.size()];
            int ii = 0;
            for (int j = 0; j < totalKeys; j++) {
                int ind = totalKeys - j - 1;
                if (!keysToRemove.contains(ind)) {
                    bunnies[i][ii] = j;
                    ii++;
                }
            }
        }
        return bunnies;
    }

    public static void main(String[] args) {
        int[][] sol = solution(5, 3);
        for (int[] s : sol){
            System.out.print(Arrays.toString(s)+", ");
        }
    }
}
