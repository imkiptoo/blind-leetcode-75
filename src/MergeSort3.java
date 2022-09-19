import java.util.*;

public class MergeSort3 {
	public static void main(String[] args) {
		int[] A = {1, 3, 4, 2, 5, 3, 6, 4, 7, 8, 2, 4, 6, 7, 9};
		int lnA = A.length;

		mergeSort(A, 0, lnA - 1);

		System.out.println(Arrays.toString(A));
	}

	static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	static void merge(int[] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int[] L = new int[n1];
		int[] M = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[p + i];
		}

		for (int j = 0; j < n2; j++) {
			M[j] = arr[q + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		while (i < n1 && j < n2) {
			if (L[i] <= M[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = M[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = M[j];
			j++;
			k++;
		}
	}
}
