package leetcode.dynamicProgramming;

/*
 * 1289. Minimum Falling Path Sum II
 * problem url: https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class MinFallingPathSum2 {
	public static void main(String[] args) {
		System.out.println(minFallingPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
		System.out.println(minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}

	public static int minFallingPathSum(int[][] A) {
		int[][] dp = new int[A.length][A[0].length];
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (i == 0) {
					dp[i][j] = A[i][j];
					continue;
				}
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < A[0].length; k++) {
					if (k == j)
						continue;
					min = Math.min(dp[i - 1][k], min);
				}

				dp[i][j] = min + A[i][j];
			}
		}

		for (int i = 0; i < A[0].length; i++)
			result = Math.min(result, dp[A.length - 1][i]);

		return result;
	}
}
