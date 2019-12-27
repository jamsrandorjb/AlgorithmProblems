package leetcode.dynamicProgramming;

/*
 * 1277. Count Square Submatrices with All Ones
 * problem url: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class CountSquares {
	public static void main(String[] args) {
		System.out.println(countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));
	}

	public static int countSquares(int[][] matrix) {
		int result = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				// on the edges we don't need to check the squares
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j];
					result += dp[i][j];
					continue;
				}

				// if not we will check our DP for possible squares
				if (dp[i - 1][j] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j - 1] > 0 && matrix[i][j] > 0) {
					int temp = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
					temp = Math.min(temp, dp[i][j - 1]);
					dp[i][j] = temp + 1;
					result += dp[i][j];
					continue;
				}

				// if we don't have possible square we will just mark the dp as 1
				if (matrix[i][j] > 0) {
					dp[i][j] = 1;
					result += dp[i][j];
				}
			}
		}

		return result;
	}
}
