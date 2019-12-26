package leetcode;

/*
* 200. Number of Islands
* problem url: https://leetcode.com/problems/number-of-islands/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
	}

	public static int numIslands(char[][] grid) {
		int numOfIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0')
					continue;
				numOfIslands++;
				dfs(grid, i, j);
			}
		}

		return numOfIslands;
	}

	private static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
}
