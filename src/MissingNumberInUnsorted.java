public class MissingNumberInUnsorted {
	public static void main(String[] args) {
		int[] A = {5, 4, 10, 2, 1, 7, 6, 9};
		int missing = missingInUnsorted(A, 1, 5);

		System.out.println(missing);
	}

	public static int missingInUnsorted(int[] arr, int lowerBound, int upperBound) {
		int missing = 0;

		int sumOfIntegers = 0;

		for(int i = 0; i < arr.length; i++){
			sumOfIntegers += arr[i];
		}

		int upperLimitSum = upperBound * (upperBound + 1) / 2;
		int lowerLimitSum = lowerBound * (lowerBound - 1) / 2;

		int theoreticalSum = upperLimitSum - lowerLimitSum;
		missing = theoreticalSum - sumOfIntegers;

		return missing;
	}
}
