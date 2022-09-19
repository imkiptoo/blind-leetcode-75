import java.util.*;

public class DiagonalTraversalOfMatrix {
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(traverseDiagonally(matrix));
	}

	static ArrayList<Integer> traverseDiagonally(int[][] matrix){
		ArrayList<Integer> response = new ArrayList<>();

		int n = matrix.length;
		int m = matrix[0].length;

		boolean direction = true;
		int remaining = m * n;
		int row = 0;
		int col = 0;

		while(remaining != 0) {
			response.add(matrix[row][col]);
			remaining--;

			if(direction){
				if (row == 0 || col == m - 1) {
					direction = false;
					if (col == m - 1) {
						row++;
					} else {
						col++;
					}
				} else {
					row--;
					col++;
				}
			} else {
				if (col == 0 || row == n - 1) {
					direction = true;
					if (row == n - 1) {
						col++;
					} else {
						row++;
					}
				} else {
					row++;
					col--;
				}
			}
		}

		return response;
	}
}
