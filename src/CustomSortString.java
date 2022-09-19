import java.util.*;

public class CustomSortString {
	public static void main(String[] args){
		System.out.println(custom_sort_string("fed", "adef"));
	}

	public static String custom_sort_string(String order, String s) {
		//fill in the solution
		String rVal = "";
		String appendages = "";
		HashMap<Character, Integer> counts = new HashMap<>();

		for(Character str : s.toCharArray()){
			counts.put(str, counts.getOrDefault(str, 0) + 1);
		}

		for(Character str : order.toCharArray()){
			if(counts.containsKey(str)){
				rVal += String.valueOf(str).repeat(counts.get(str));
				counts.put(str, 0);
			}
		}

		for(Character str : s.toCharArray()){
			if(counts.get(str) > 0){
				appendages += str;
			}
		}

		return rVal+appendages;
	}
}
