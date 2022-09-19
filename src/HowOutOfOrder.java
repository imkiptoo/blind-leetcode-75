public class HowOutOfOrder {
	public static void main(String[] args){
		int[] A = {5,4,3,2,1};
		int iversions = inversions(A);

		System.out.println(iversions);
	}

	public static int inversions(int[] l) {
		// fill in
		// solution
		final int n = l.length;
		return mergeSort(l, 0, n - 1);
	}

	public static int mergeSort(int[] A, int left, int right) {
		int inversions = 0;

		if(left < right){
			final int mid = (left + right) / 2;

			inversions += mergeSort(A, left, mid);
			inversions += mergeSort(A, mid+1, right);

			inversions += merge(A, left, mid, right);
		}

		return inversions;
	}

	public static int merge(int[] A, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int inversions = 0;

		while(i <= mid && j <= right){
			if(A[i] <= A[j]){
				i++;
			} else {
				inversions += (mid - i + 1);
				j++;
			}
		}

		return inversions;
	}
}
