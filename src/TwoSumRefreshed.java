import java.util.*;

public class TwoSumRefreshed {
	public static void main(String[] args){


		int[] nums = {2,3,4,1,5,7,9,6};
		ArrayList<ArrayList<Integer>> sums = twoSum(nums, 8);

		for(ArrayList<Integer> sum: sums){
			for(int single: sum){
				System.out.println(single);
			}
			System.out.println();
		}
	}
	
	static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target){
		ArrayList<ArrayList<Integer>> rVal = new ArrayList<>();

		if(nums.length < 2) return rVal;

		Arrays.sort(nums);

		int left = 0;
		int right = nums.length - 1;

		while(left < right){
			int sum = nums[left] + nums[right];
			if(sum == target){
				ArrayList<Integer> sums = new ArrayList<>();
				sums.add(nums[left]);
				sums.add(nums[right]);
				rVal.add(sums);
				left++;
			} else if(sum < target){
				left++;
			} else if(sum > target){
				right--;
			}
		}

		return rVal;
	}
}
