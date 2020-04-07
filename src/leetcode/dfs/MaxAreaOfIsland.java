package leetcode.dfs;

/*
* 695. Max Area of Island
* problem url: https://leetcode.com/problems/max-area-of-island/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0)
					continue;
				maxArea = Math.max(maxArea, dfs(grid, i, j));
			}
		}

		return maxArea;
	}

	private static int dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0)
			return 0;
		int area = 1;
		grid[i][j] = 0;

		area += dfs(grid, i - 1, j);
		area += dfs(grid, i + 1, j);
		area += dfs(grid, i, j - 1);
		area += dfs(grid, i, j + 1);

		return area;
	}
}
