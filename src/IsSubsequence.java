import java.util.LinkedList;
import java.util.Queue;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequenceTwoPointers("abc", "asadfbasdcdfe"));
        System.out.println(isSubsequenceTwoPointers("abc", "acb"));
        System.out.println(isSubsequenceTwoPointers("abc", "ab"));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;

        Queue<Character> queue = new LinkedList<>();

        for(char c : s.toCharArray()){
            queue.offer(c);
        }

        for (int i = 0; i < t.length(); i++) {
            if(!queue.isEmpty()){
                if(t.charAt(i) == queue.peek()){
                    queue.poll();
                }
            } else {
                break;
            }
        }

        return queue.isEmpty();
    }

    public static boolean isSubsequenceTwoPointers(String s, String t) {
        int sPointer = 0;

        for (int i = 0; i < t.length(); i++) {
            if(sPointer < s.length() && s.charAt(sPointer) == t.charAt(i)){
                sPointer++;
            }
        }

        return sPointer >= s.length();
    }
}
