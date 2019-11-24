package leetcode;

/*
* 1267. Count Servers that Communicate
* problem url: https://leetcode.com/problems/count-servers-that-communicate/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CountServers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countServers(new int[][] { { 1, 0 }, { 0, 1 } }));
	}

	public static int countServers(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && checkCommunicated(grid, i, j)) {
					result++;
				}
			}
		}
		return result;
	}

	private static boolean checkCommunicated(int[][] grid, int i, int j) {
		for (int r = 0; r < grid.length; r++) {
			if (r == i)
				continue;
			if (grid[r][j] == 1)
				return true;
		}
		for (int c = 0; c < grid[0].length; c++) {
			if (c == j)
				continue;
			if (grid[i][c] == 1)
				return true;
		}
		return false;
	}
}
