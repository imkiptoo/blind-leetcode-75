import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"", ""};
        List<List<String>> rVal = correct(strings);
        System.out.println("Done");
    }

    public static List<List<String>> correct(String[] strings) {
        if(strings.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String string: strings){
            char[] ca = string.toCharArray();

            Arrays.sort(ca);

            String current = String.valueOf(ca);

            if(!map.containsKey(current)) map.put(current, new ArrayList<>());

            map.get(current).add(string);
        }

        return new ArrayList(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        List<List<String>> rVal = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Boolean> alreadyBelong = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String current = strings[i];

            List<String> lsStrings = new ArrayList<>();

            boolean containsValid = false;

            for (int j = 0; j < strings.length; j++) {
                if(strings[i].length() == 1 && strings[j].length() == 1){
                    containsValid = true;
                    lsStrings.add(strings[j]);
                    alreadyBelong.put(strings[j], true);
                    map.put(current, lsStrings);
                } else {
                    if(!alreadyBelong.containsKey(strings[j])){
                        boolean valid = validAnagram(strings[i], strings[j]);
                        if(valid){
                            containsValid = true;
                            lsStrings.add(strings[j]);

                            alreadyBelong.put(strings[j], true);
                            map.put(current, lsStrings);
                        }
                    }
                }
            }

            if(containsValid){
                rVal.add(map.get(current));
            }
        }

        
        return rVal;
    }

    public static boolean validAnagram(String strFirst, String strSecond) {
        if(strFirst.length() != strSecond.length()){
            return false;
        }
        
        HashMap<Character, Integer> hmFirst = new HashMap<>();
        HashMap<Character, Integer> hmSecond = new HashMap<>();
        
        char[] caFirst = strFirst.toCharArray();
        char[] caSecond = strSecond.toCharArray();

        for (int i = 0; i < caFirst.length; i++) {
            if(hmFirst.get(caFirst[i]) == null){
                hmFirst.put(caFirst[i], 0);
            } else {
                int current = hmFirst.get(caFirst[i]);
                hmFirst.put(caFirst[i], current+1);
            }
            
            if(hmSecond.get(caSecond[i]) == null){
                hmSecond.put(caSecond[i], 0);
            } else {
                int current = hmSecond.get(caSecond[i]);
                hmSecond.put(caSecond[i], current+1);
            }
        }
        
        return hmFirst.equals(hmSecond);
    }
}
