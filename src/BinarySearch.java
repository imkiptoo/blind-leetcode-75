import java.util.*;

public class BinarySearch {
	public static void main(String[] args){
		int[] arr = {4, 10, 25, 40, 54, 78, 85, 100, 34, 23, 44, 67, 78, 23, 78, 34, 45, 76, 23, 56, 67, 12};
		Arrays.sort(arr);

		int start = 0;
		int end = arr.length - 1;

		System.out.println(binarySearch(arr, 56, start, end));

	}

	static int binarySearch(int[] arr, int value, int start, int end){
		int position = 0;
		int middle = (start + end) / 2;

		System.out.println("Pass");

		if(arr[middle] == value){
			position = middle;
		} else if(arr[middle] < value){
			start = middle+1;
			position = binarySearch(arr, value, start, end);
		} else if(arr[middle] > value){
			end = middle;
			position = binarySearch(arr, value, start, end);
		}

		return position;
	}
}
