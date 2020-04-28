package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LuckyNumbersInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> result = new LinkedList<>();
		int n = matrix.length;
		int m = matrix[0].length;

		int[] rows = new int[n];
		int[] cols = new int[m];

		// 15 is the only lucky number since it is the minimum in its row and the
		// maximum in its column
		for (int i = 0; i < n; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				temp = Math.min(temp, matrix[i][j]);
			}
			rows[i] = temp;
		}

		for (int j = 0; j < m; j++) {
			int temp = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				temp = Math.max(temp, matrix[i][j]);
			}
			cols[j] = temp;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cols[j] == matrix[i][j] && rows[i] == matrix[i][j])
					result.add(matrix[i][j]);
			}
		}

		return result;
	}
}
