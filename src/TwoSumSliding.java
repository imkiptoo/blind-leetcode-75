public class TwoSumSliding {
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,17,2};
		int target = 23;

		System.out.println(minimumLengthSum(arr, target));
	}

	static int minimumLengthSum(int[] arr, int target){
		int minimum = arr.length;
		int left = 0;
		int right = 0;
		int sum = arr[left];

		while(right+1 < arr.length){
			if(sum == target){
				minimum = Math.min(minimum, right - left + 1);
				right++;
				sum += arr[right];
				System.out.println(arr[right]);
			} else if(sum < target) {
				right++;
				sum += arr[right];
			} else if(sum > target) {
				sum -= arr[left];
				left++;
			}

			System.out.println("n");
		}

		return minimum;
	}
}
