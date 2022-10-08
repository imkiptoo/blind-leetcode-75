import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class ExpandingNebula {
    public static void main(String[] args) {
        System.out.println(solution(new boolean[][]{{true, false, true}, {false, true, false}, {true, false, true}}));
        System.out.println(solution(new boolean[][]{{true, false, true, false, false, true, true, true}, {true, false, true, false, false, false, true, false}, {true, true, true, false, false, false, true, false}, {true, false, true, false, false, false, true, false}, {true, false, true, false, false, true, true, true}}));
    }

    public static int solution(boolean[][] g) {
        // Your code here
        int rVal = 0;
        List<List<Boolean>> transposed = zip(g);

        int cols = transposed.get(0).size();
        int[] nums = new int[transposed.size()];

        for (int i = 0; i < transposed.size(); i++) {
            for (int j = 0; j < transposed.get(i).size(); j++) {
                nums[i] += transposed.get(i).get(j) ? 1 << j : 0;
            }
        }

        LinkedHashMap<String, List<Integer>> mapping = buildMap(cols, nums);

        LinkedHashMap<Integer, Integer> preImage = new LinkedHashMap<>();

        for (int i = 0; i < 1 << (cols + 1); i++) {
            preImage.put(i, 1);
        }

        for (int row : nums) {
            LinkedHashMap<Integer, Integer> nextRow = new LinkedHashMap<>();
            for(Map.Entry<Integer, Integer> c1 : preImage.entrySet()){
                String key = row+","+c1.getKey();
                for(int c2 : mapping.getOrDefault(key, new ArrayList<>())){
                    Integer temp = nextRow.getOrDefault(c2, 0);
                    temp += preImage.getOrDefault(c1.getKey(), 0);
                    nextRow.put(c2, temp);
                }
            }
            preImage = nextRow;
        }

        for(Integer i : preImage.values()){
            rVal += i;
        }
        return rVal;
    }

    static int generate(int c1, int c2, int bitlen){
        int a = c1 & ~(1<<bitlen);
        int b = c2 & ~(1<<bitlen);
        int c = c1 >> 1;
        int d = c2 >> 1;
        return (a&~b&~c&~d) | (~a&b&~c&~d) | (~a&~b&c&~d) | (~a&~b&~c&d);
    }

    static LinkedHashMap<String, List<Integer>> buildMap(int n, int[] set){
        LinkedHashMap<String, List<Integer>> mapping = new LinkedHashMap<>();
        HashSet<Integer> nums = new HashSet<>();

        for (int num : set){
            nums.add(num);
        }

        for(int i = 0; i < 1<<(n+1); i++){
            for(int j = 0; j < 1<<(n+1); j++){
                int generation = generate(i,j,n);
                if(nums.contains(generation)){
                    List<Integer> temp = mapping.getOrDefault(generation+","+i, new ArrayList<>());
                    temp.add(j);
                    mapping.put(generation+","+i, temp);
                }
            }
        }
        return mapping;
    }

    public static List<List<Boolean>> zip(boolean[][] lists) {
        List<List<Boolean>> zipped = new ArrayList<List<Boolean>>();
        for (boolean[] list : lists) {
            for (int i = 0, listSize = list.length; i < listSize; i++) {
                List<Boolean> list2;
                if (i >= zipped.size())
                    zipped.add(list2 = new ArrayList<Boolean>());
                else
                    list2 = zipped.get(i);
                list2.add(list[i]);
            }
        }

        return zipped;
    }
}
