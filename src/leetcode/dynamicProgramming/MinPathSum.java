package leetcode.dynamicProgramming;

/*
 * 64. Minimum Path Sum
 * problem url: https://leetcode.com/problems/minimum-path-sum/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class MinPathSum {
	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
	}

	public static int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[grid.length - 1][grid[0].length - 1];
	}
}
