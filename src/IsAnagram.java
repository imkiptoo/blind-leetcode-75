import java.util.*;

public class IsAnagram {
	public static void main(String[] args){
		System.out.println(isAnagram("Mary", "Army"));
	}

	static boolean isAnagram(String inputA, String inputB){
		if(inputA.length() != inputB.length()){
			return false;
		}

		char[] charsA = inputA.toLowerCase().toCharArray();
		char[] charsB = inputB.toLowerCase().toCharArray();

		Arrays.sort(charsA);
		Arrays.sort(charsB);

		inputA = String.valueOf(charsA);
		inputB = String.valueOf(charsB);

		return inputA.equals(inputB);
	}
}
