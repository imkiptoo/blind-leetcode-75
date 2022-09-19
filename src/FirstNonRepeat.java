import java.util.*;

public class FirstNonRepeat {
	public static void main(String[] args){
		System.out.println(firstNonRepeat("asdfasrf"));
	}

	public static char firstNonRepeat(String str) {
		// fill in
		// with solution

		final char rVal = '\0';

		HashMap<Character, Integer> counts = new HashMap<>();

		for(char c : str.toCharArray()){
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		for(char c : str.toCharArray()){
			if(counts.get(c) == 1) {
				return c;
			}
		}

		return rVal;
	}
}
