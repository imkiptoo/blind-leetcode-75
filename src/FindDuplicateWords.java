import java.util.*;

public class FindDuplicateWords {

	public static void main(String[] args){
		System.out.println(Arrays.toString(findDuplicatesUsingSet("The Name is Bond James Bond")));
	}

	public static String[] findDuplicatesUsingSet(String input) {
		// fill in
		HashSet<String> all = new HashSet<>();
		HashSet<String> duplicates = new HashSet<>();

		input = input.toLowerCase();
		String[] words = input.split(" ");

		for(String word : words){
			if(all.contains(word)){
				duplicates.add(word);
			} else {
				all.add(word);
			}
		}

		return Arrays.copyOf(duplicates.toArray(), duplicates.size(), String[].class);
	}

	public static String[] findDuplicates(String input) {
		// fill in
		ArrayList<String> unique = new ArrayList<>();

		input = input.toLowerCase();
		String[] words = input.split(" ");
		HashMap<String, Integer> counts = new HashMap<>();
		for(String word : words){
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		for(Map.Entry<String, Integer> count : counts.entrySet()){
			if(count.getValue() > 1){
				unique.add(count.getKey());
			}
		}

		String[] uniqueArray = new String[unique.size()];

		for(int i = 0; i < unique.size(); i++){
			uniqueArray[i] = unique.get(i);
		}

		return uniqueArray;
	}
}
