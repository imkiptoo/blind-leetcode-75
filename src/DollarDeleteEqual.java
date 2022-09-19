import java.util.*;

public class DollarDeleteEqual {
	public static void main(String[] args){
		String[] arr = {"b$$p", "$b$p"};
		System.out.println(isDollarDeleteEqual(arr));
	}

	public static boolean isDollarDeleteEqual(String[] arr) {
		// fill in
		// with solution

		String first = getFinalStrUsingStack(arr[0]);
		String second = getFinalStrUsingStack(arr[1]);

		return first.equals(second);
	}

	private static String getFinalStrUsingStack(String str){

		Stack<Character> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '$'){
				if(stack.size() > 0){
					stack.pop();
				}
			} else {
				stack.push(str.charAt(i));
			}
		}

		while(stack.size() > 0){
			builder.append(stack.pop());
		}

		return builder.reverse().toString();
	}

	private static String getFinalStr(String str) {
		// fill in
		// with solution

		StringBuilder finalStr = new StringBuilder();
		char[] chars = str.toCharArray();
		LinkedList<Character> list = new LinkedList<>();

		for(int i = 0; i < chars.length; i++){
			char c = str.charAt(i);

			if(c == '$'){
				if(i > 0) {
					if(list.size() > 0){
						list.removeLast();
					}
				}
			} else {
				list.add(chars[i]);
			}
		}

		for(int i = 0; i < list.size(); i++){
			finalStr.append(String.valueOf(list.get(i)));
		}

		return finalStr.toString();
	}
}
