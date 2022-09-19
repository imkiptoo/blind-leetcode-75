import java.util.*;

public class MissingNumberInArray {
	public static void main(String[] args){
		List<Integer> missing = missingNumbersTwo(new int[] { 0, 1, 3, 6, 7, 9 });

		System.out.println(missing);
	}

	public static List<Integer> missingNumbersTwo(int[] numArr) {
		ArrayList<Integer> missing = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for(int num : numArr){
			queue.offer(num);
		}

		int currentNum = queue.peek();
		queue.poll();

		//1,3,4,5
		while(queue.size() > 0){
			if(queue.peek() == currentNum + 1){
				queue.poll();
			} else {
				missing.add(currentNum+1);
			}
			currentNum++;
		}

		return missing;
	}

	public static List<Integer> missingNumbers(int[] numArr) {
		int lastMissing = 0;

		ArrayList<Integer> missing = new ArrayList<>();
		int start = numArr[0];
		int end = numArr[numArr.length - 1];
		int[] allNums = new int[end-start+1];

		for(int i = 0; i < numArr.length; i++){
			allNums[numArr[i] - start] = numArr[i];
		}

		for(int i = 0; i < allNums.length - 1; i++){
			if(allNums[i+1] !=  allNums[i]+1 && lastMissing != allNums[i+1]){
				lastMissing = start+i;
				missing.add(start+i);
			}
		}

		return missing;
	}
}
