package leetcode.dynamicProgramming;

/*
* 62. Unique Paths
* problem url: https://leetcode.com/problems/unique-paths/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(4, 5));
	}

	public static int uniquePaths(int m, int n) {
		if (m == 0 && n == 0)
			return 0;
		if (m == 0 || n == 0)
			return 1;

		int[][] grid = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					grid[i][j] = 1;
					continue;
				}
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}

		return grid[m - 1][n - 1];
	}
}
