import java.util.*;

public class TwoHeapsTechnique {
	static class Technique {
		PriorityQueue<Integer> minHeap = null;
		PriorityQueue<Integer> maxHeap = null;

		Technique(){
			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		}

		public void addNum(int num){
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());

			if(minHeap.size() < maxHeap.size()){
				minHeap.offer(maxHeap.poll());
			}
		}

		public double findMedian(){
			if(minHeap.size() > maxHeap.size()){
				return minHeap.peek();
			} else {
				return (minHeap.peek() + maxHeap.peek()) / 2.0;
			}
		}
	}

	public static void main(String[] args){
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};

		Technique t = new Technique();

		for(int num : A){
			t.addNum(num);
		}

		System.out.println(t.findMedian());
	}
}
