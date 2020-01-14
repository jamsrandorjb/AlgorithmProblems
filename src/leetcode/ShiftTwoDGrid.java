package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* 1260. Shift 2D Grid
* problem url: https://leetcode.com/problems/shift-2d-grid/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ShiftTwoDGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shiftGrid(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1));
		System.out.println(shiftGrid(new int[][] { {1}, {2}, {3}, {4}, {7}, {6}, {5} }, 23));
	}

	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] grid1 = new int[n][m];

		k = k % (m * n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int col = (j + k) % m;
				int row = (i + (j + k) / m) % n;
				grid1[row][col] = grid[i][j];
			}
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				list.add(grid1[i][j]);
			}
			result.add(list);
		}

		return result;
	}
}
