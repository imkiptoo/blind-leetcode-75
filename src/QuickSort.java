import java.util.*;

public class QuickSort {
	public static void main(String[] args){
		int[] arr = {2, 5, 3, 5, 3, 2, 6, 8, 4, 6, 3, 7, 9, 2, 5, 7, 1, 0};

		quickSort(arr, 0, arr.length-1);

		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int low, int high){
		if(low < high){
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot -1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low - 1;

		for(int j = low; j < high; j++){
			if(arr[j] <= pivot){
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		i++;

		int temp = arr[high];
		arr[high] = arr[i];
		arr[i] = temp;

		return i;
	}
}
