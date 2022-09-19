import java.util.Arrays;
import java.util.Collections;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ab","bac"}));
        System.out.println(longestStrChain(new String[]{"abcd","dbqca"}));
        System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }

    public static int longestStrChain(String[] words) {
        int chainSize = 1;

        Arrays.sort(words, (b, a) -> Integer.compare(a.length(), b.length()));

        for(int i = 0; i < words.length - 1; i++){
            if(nextIsValid(words[i], words[i+1])){
                chainSize++;
            } else {
                chainSize = 1;
            }
        }

        return chainSize;
    }

    public static boolean nextIsValid(String word, String next){
        //abc
        //ba
        int nextPointer = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == next.charAt(nextPointer)){
                nextPointer++;
            }
        }
        return nextPointer >= next.length() - 1;
    }
}
