import java.util.*;

public class IsPalindrome {
	public static void main(String[] args){
		String s = "oxo";

		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		char[] chars = s.toCharArray();

		List<Character> validChars = new ArrayList<>();
		List<Character> validCharsReverse = new ArrayList<>();

		for(int i = 0; i < chars.length; i++){
			char c = chars[i];
			if(c < 97 && c > 123) continue;
			validChars.add(c);
		}

		for(int i = chars.length - 1; i >= 0 ; i--){
			char c = chars[i];
			if(c < 97 && c > 123) continue;
			validCharsReverse.add(c);
		}

		boolean rVal = validChars.equals(validCharsReverse);
		return rVal;
	}
}
