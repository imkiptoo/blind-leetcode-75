import java.util.*;

public class SlidingWindowShortestWithAll {
	public static void main(String[] args){
		System.out.println(shortestWithAll("HGFDSAXZBJKC", "AXB"));
	}

	static int shortestWithAll(String whole, String sub){
		char[] wholeChars = whole.toCharArray();
		char[] subChars = sub.toCharArray();
		HashSet<Character> subSet = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		for(char c : subChars){
			subSet.add(c);
		}

		int left = 0;
		int right = 0;
		int shortest = 0;
		int found = 0;

		while(right < wholeChars.length){
			char current = wholeChars[right];

			if(subSet.contains(current)){
				queue.offer(right);
				found++;
			}

			if(found == subChars.length){
				left = queue.poll();
				shortest++;
				if(shortest == 1){
					shortest = right - left + 1;
				} else {
					shortest = Math.min(shortest, right - left + 1);
				}
				found--;
			}

			right++;
		}

		return shortest;
	}
}
