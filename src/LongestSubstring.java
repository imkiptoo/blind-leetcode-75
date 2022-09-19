import java.util.*;

public class LongestSubstring {
	public static void main(String[] args){
		System.out.println(findLongestMethod2("abracadabar"));
	}

	static int findLongestMethod2(String str) {
		// fill in this method

		int start = 0;
		int longest = 0;
		HashMap<Character, Integer> encountered = new HashMap<>();
		char[] all = str.toCharArray();

		for(int i = 0; i < all.length; i++){
			if(encountered.containsKey(all[i])){
				longest = Math.max(longest, i - start);
				start = Math.max(start, encountered.get(all[i]) + 1);
			}
			encountered.put(all[i], i);
		}

		return Math.max(longest, all.length - start);
	}

	static int findLongest(String str) {
		// fill in this method

		int start = 0;
		int end = 0;
		int longest = 0;
		HashSet<Character> encountered = new HashSet<>();
		char[] all = str.toCharArray();

		int i = 0;

		while(end < all.length){
			if(!encountered.contains(all[end])){
				encountered.add(all[end]);
				end++;
				longest = Math.max(longest, end - start);
			} else {
				encountered.remove(all[start]);
				start++;
			}
			i++;
		}

		System.out.println("Passes: "+i);

		return longest;
	}
}
