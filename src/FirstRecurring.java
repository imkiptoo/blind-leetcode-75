import java.util.*;

public class FirstRecurring {
	public static void main(String[] args) {
		System.out.println(firstRecurring("ABCADAB"));
	}

	static String firstRecurring(String s) {
		char[] chars = s.toCharArray();
		HashSet<Character> set = new HashSet<>();

		for(char c : chars) {
			if(set.contains(c)){
				return String.valueOf(c);
			} else {
				set.add(c);
			}
		}

		return null;
	}
}
