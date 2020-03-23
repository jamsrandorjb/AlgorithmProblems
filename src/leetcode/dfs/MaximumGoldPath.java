package leetcode.dfs;

/*
* 1219. Path with Maximum Gold
* problem url: https://leetcode.com/problems/path-with-maximum-gold/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaximumGoldPath {

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		System.out.println(getMaximumGold(grid));
	}

	public static int getMaximumGold(int[][] grid) {
		boolean[][] visitedNodes = new boolean[grid.length][grid[0].length];
		int[] max = new int[1];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 0) {
					dfs(i, j, grid, max, 0, visitedNodes);
				}
			}
		}

		return max[0];
	}

	private static int dfs(int i, int j, int[][] grid, int[] max, int tempMax, boolean[][] visitedNodes) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visitedNodes[i][j] || grid[i][j] == 0)
			return tempMax;

		tempMax += grid[i][j];
		max[0] = Math.max(max[0], tempMax);
		visitedNodes[i][j] = true;

		dfs(i + 1, j, grid, max, tempMax, visitedNodes);
		dfs(i - 1, j, grid, max, tempMax, visitedNodes);
		dfs(i, j + 1, grid, max, tempMax, visitedNodes);
		dfs(i, j - 1, grid, max, tempMax, visitedNodes);

		visitedNodes[i][j] = false;

		return tempMax;
	}
}
