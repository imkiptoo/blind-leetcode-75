import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args){
        int[] arr = {4,2,9,7,5,6,7,1,3};
        System.out.println(kthLargest(arr, 4));
    }

    private static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> queue =  new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : arr){
            queue.offer(num);
        }

        for(int i = 0; i < k -1; i++){
            queue.poll();
        }

        return queue.peek();
    }
}
