import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MostOccuring {
    public static void main(String[] args) {
        solution(new int[]{25, 2, 3, 57, 38, 41});
    }

    static int[] solution(int[] a) {
        LinkedHashMap<Integer, Integer> frequencies = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        int mostFrequent = 0;

        StringBuilder digits = new StringBuilder();

        for(int n : a){
            digits.append(String.valueOf(n));
        }

        char[] chars = digits.toString().toCharArray();

        for(char c : chars){
            int frequency = frequencies.getOrDefault(c - '0', 0);
            frequency++;

            frequencies.put(c - '0', frequency);
        }

        frequencies.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        ArrayList<Integer> response = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            mostFrequent = Math.max(entry.getValue(), mostFrequent);
        }

        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            if(entry.getValue() == mostFrequent){
                response.add(entry.getKey());
            }
        }

        int[] sorted = new int[response.size()];

        int i = 0;
        for(int n : response){
            sorted[i] = n;
            i++;
        }

        return sorted;
    }

}
