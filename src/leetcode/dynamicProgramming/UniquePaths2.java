package leetcode.dynamicProgramming;

/*
* 63. Unique Paths II
* problem url: https://leetcode.com/problems/unique-paths-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class UniquePaths2 {
	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					grid[i][j] = 0;
					continue;
				}
				if (i == 0 && j == 0) {
					grid[i][j] = 1;
					continue;
				}
				if (i == 0) {
					grid[i][j] = grid[i][j - 1];
					continue;
				}
				if (j == 0) {
					grid[i][j] = grid[i - 1][j];
					continue;
				}
				grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}
}
