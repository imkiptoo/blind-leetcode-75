import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        Arrays.fill(sMap, -1);
        int[] tMap = new int[256];
        Arrays.fill(tMap, -1);

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i); 
            char tChar = t.charAt(i);

            if(sMap[sChar] == -1 && tMap[tChar] == -1){
                sMap[sChar] = tChar;
                tMap[tChar] = sChar;
            } else if(!(sMap[sChar] == tChar && tMap[tChar] == sChar)){
                return false;
            }
        }
        return true;
    }
}
