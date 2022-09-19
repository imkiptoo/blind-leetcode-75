import java.util.*;

public class DetectSubstring {
	public static void main(String[] args){
		System.out.println(detectSubstringGrowsAndShrinks("James Bond Movie", "Movie"));
	}

	static int detectSubstringGrowsAndShrinks(String a, String b){
		char[] chars = a.toCharArray();
		char[] charsb = b.toCharArray();

		int start = 0;
		int end = 0;
		int found = 0;

		for(int i = 0; i < chars.length; i++){
			if(chars[i] == charsb[end]){
				found++;
				end++;

				if(found == charsb.length){
					return i - end + 1;
				}
			} else {
				found = 0;
			}
		}

		return -1;
	}

	static int detectSubstring(String a, String b){
		char[] chars = a.toCharArray();
		char[] charsb = b.toCharArray();
		Queue<Character> window = new LinkedList<>();

		int found = 0;

		for(int i = 0; i < charsb.length; i++){
			window.offer(charsb[i]);
		}

		for(int i = 0; i < chars.length; i++){
			char top = window.peek();
			if(top == chars[i]){
				found++;

				if(found == charsb.length){
					return i - charsb.length + 1;
				} else {
					window.poll();
				}
			} else {
				found = 0;
			}
		}

		return -1;
	}
}
