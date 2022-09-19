import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class MatchingStrings {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here        
        HashMap<String, Integer> presenceCounts = new HashMap<>();
        List<Integer> rval = new ArrayList<>();
        
        for(int i = 0; i < strings.size(); i++){
            if(queries.contains(strings.get(i))){
                if(presenceCounts.containsKey(strings.get(i))) {
                    presenceCounts.replace(strings.get(i), presenceCounts.get(strings.get(i)) + 1);
                } else {
                    presenceCounts.put(strings.get(i), 1);
                }
            } else {
                presenceCounts.put(strings.get(i), 0);
            }
        }
        
        for(Map.Entry<String, Integer> entry: presenceCounts.entrySet()){
            rval.add(entry.getValue());
            System.out.println(entry.getValue());
        }
        
        return rval;
        
    }

    public static void main(String[] args) throws IOException {
        List<String> strings = Arrays.asList("ab", "adc", "abc", "dad", "ab");
        List<String> queries = Arrays.asList("dab", "abc", "ab", "ad", "ab");

        List<Integer> res = MatchingStrings.matchingStrings(strings, queries);
    }
}
