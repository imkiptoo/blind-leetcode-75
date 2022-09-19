import java.util.*;

public class TimeIntervals {
	public static void main(String[] args){
		int[][] times = {{2,3}, {1,6}, {8, 12}, {16, 24}, {1, 5}};
		Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
		Stack<Interval> stack = new Stack<>();

		ArrayList<Interval> intervals = new ArrayList<>();
		
		for(int[] time : times){
			intervals.add(new Interval(time[0], time[1]));
		}

		for(Interval interval : intervals){
			if(stack.size() > 0){
				Interval existing = stack.peek();
				boolean overlap = overlapping(existing, interval);
				if(overlap){
					stack.pop();
					if(interval.start > existing.start) {
						interval.start = Math.min(existing.start, interval.start);
					}
					if(interval.end < existing.end) {
						interval.end = Math.max(existing.end, interval.end);
					}
					stack.push(interval);
				} else {
					stack.push(interval);
				}
			} else {
				stack.push(interval);
			}
		}

		int[][] distinct = new int[stack.size()][2];

		for(int i = stack.size() - 1; i >= 0; i--){
			Interval existing = stack.peek();
			distinct[i][0] = existing.start;
			distinct[i][1] = existing.end;
			stack.pop();
		}

		System.out.println("Done");
	}

	static boolean overlapping(Interval A, Interval B){
		return ((A.start >= B.start && A.start <= B.end) ||
				(A.end >= B.start && A.end <= B.end) ||
				(B.start >= A.start && B.start <= A.end) ||
				(B.end >= A.start && B.end <= A.end)
		);
	}

	public static class Interval{
		int start;
		int end;

		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
}
