import java.util.*;

public class ReverseString {
	public static void main(String[] args){
		String str = "ootpik";

		char[] chars = str.toCharArray();

		Arrays.sort(chars);

		int left = 0;
		int right = chars.length - 1;

		while(left < right){
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;

			if(chars[left] < 'm'){
				System.out.println("Haroo");
			}

			left++;
			right--;
		}

		System.out.println(String.valueOf(chars));
	}
}
