import java.util.*;

public class TimeIntervalsAlt {
	public static void main(String[] args) {
		int[][] times = {{2, 3}, {1, 6}, {8, 12}, {16, 24}, {1, 5}};
		Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

		LinkedList<int[]> merged = new LinkedList<>();

		for(int[] time : times) {
			if(merged.isEmpty() || time[0] > merged.getLast()[1]) {
				merged.add(time);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], time[1]);
			}
		}

		int[][] response = merged.toArray(new int[merged.size()][]);
		System.out.println("Done");
	}
}
