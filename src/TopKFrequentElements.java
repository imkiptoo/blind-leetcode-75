import java.util.*;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1, 2, 4, 4, 4, 2, 1, 5, 1, 2, 3, 1, 4, 1, 3};

		topKFrequent(nums, 3);
	}

	public static int[] topKFrequent(int[] nums, int k) {
		if(k == nums.length){
			return nums;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for(int n: nums){
			map.put(n, map.getOrDefault(n, 0)+1);
		}

		Queue<Integer> heap = new PriorityQueue<>(
			(n1, n2) -> map.get(n1) - map.get(n2)
		);

		for(int n: map.keySet()){
			heap.add(n);
			if(heap.size() > k) heap.poll();
		}

		int[] top = new int[k];

		for(int i = k - 1; i >= 0; --i){
			top[i] = heap.poll();
		}

		return top;
	}
}
