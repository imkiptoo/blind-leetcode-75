import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String first = "mane";
        String second = "namd";

        char[] caFirst = first.toCharArray();
        char[] caSecond = second.toCharArray();

        HashMap<Character, Integer> hmFirst = new HashMap<>();
        HashMap<Character, Integer> hmSecond = new HashMap<>();

        for (int i = 0; i < caFirst.length; i++) {
            if(hmFirst.get(caFirst[i]) == null){
                hmFirst.put(caFirst[i], 0);
            } else {
                int character = hmFirst.get(caFirst[i]);
                hmFirst.put(caFirst[i], character+1);
            }
        }

        for (int i = 0; i < caSecond.length; i++) {
            if(hmSecond.get(caSecond[i]) == null){
                hmSecond.put(caSecond[i], 0);
            } else {
                int character = hmSecond.get(caSecond[i]);
                hmSecond.put(caSecond[i], character+1);
            }
        }

        if(hmFirst.equals(hmSecond)){
            System.out.println("Strings are anagrams of each other");
        } else {
            System.out.println("Strings are NOT anagrams of each other");
        }
    }
}
