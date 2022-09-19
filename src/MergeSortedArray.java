import java.util.*;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] a = new int[]{1,10,55,66};
		int[] b = new int[]{21,48,68,80};
		int[] c = merge(a, 4, b, 4);

		System.out.println(Arrays.toString(c));
	}

	public static int[] merge(int[] nums, int m, int[] nums2, int n) {
		// Enter your code here
		int[] merged = new int[m + n];
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			queue1.offer(nums[i]);
		}

		for (int i = 0; i < n; i++) {
			queue2.offer(nums2[i]);
		}

		int i = 0;

		int num1 = queue1.peek();
		int num2 = queue2.peek();

		while (i < m + n) {
			if (queue1.size() > 0) {
				num1 = queue1.peek();
			}

			if (queue2.size() > 0) {
				num2 = queue2.peek();
			}

			if (num1 <= num2 && queue1.size() > 0) {
				merged[i] = num1;
				queue1.poll();
			} else if (num1 <= num2 && queue1.size() == 0) {
				merged[i] = num2;
				queue2.poll();
			} else if (num2 <= num1 && queue2.size() > 0) {
				merged[i] = num2;
				queue2.poll();
			} else if (num2 <= num1 && queue2.size() == 0) {
				merged[i] = num1;
				queue1.poll();
			}

			i++;
		}

		return merged;
	}
}
