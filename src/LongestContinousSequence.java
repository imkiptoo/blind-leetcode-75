import java.util.*;

public class LongestContinousSequence {
	public static void main(String[] args){
		int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
		//int[] nums = {100,4,200,1,3,2};

		int longest = longestConsecutive2(nums);

		System.out.println(longest);
	}

	public static int longestConsecutive(int[] nums) {
		if(nums.length == 0) return 0;

		int rVal = 1;
		int[] sequences = new int[nums.length];

		Arrays.sort(nums);

		int start = nums[0];

		sequences[0] = 1;

		int i = 0;
		for(int num : nums){
			if(num == start) continue;

			if(num != start+1){
				start = num;
				rVal = 1;
				i++;
				sequences[i] = rVal;
			}

			if(num == start+1){
				start++;
				rVal++;
				sequences[i] = rVal;
			}
		}

		Arrays.sort(sequences);
		return sequences[sequences.length - 1];
	}


	public static int longestConsecutive2(int[] nums) {
		int longestStreak = 0;
		Set<Integer> sequence = new HashSet<>();

		for(int num : nums){
			sequence.add(num);
		}

		for(int num : sequence){
			if(!sequence.contains(num - 1)){
				int currentNum = num;
				int currentStreak = 1;
				while(sequence.contains(currentNum+1)){
					currentNum++;
					currentStreak++;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}
}
