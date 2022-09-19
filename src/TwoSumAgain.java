public class TwoSumAgain {
	public static void main(String[] args){
		int[] nums = {1,2,4,4};
		int target = 6;

		int[] pair = getTwoSum(nums, target);

		for(int num : pair){
			System.out.print(num+" ");
		}
	}

	static int[] getTwoSum(int[] nums, int target){
		int[] pair = new int[2];

		int left = 0;
		int right = nums.length - 1;
		//enough to explain to

		while(left < right) {
			int sum = nums[left] + nums[right];

			if(sum == target) {
				pair[0] = nums[left];
				pair[1] = nums[right];
				break;
			} else if(sum < target) {
				left++;
			} else if(sum > target) {
				right--;
			}
		}

		return pair;
	}
}
