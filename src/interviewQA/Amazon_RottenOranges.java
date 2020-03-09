package interviewQA;

import java.util.LinkedList;
import java.util.Queue;

/*
* 994. Rotting Oranges
* problem url: https://leetcode.com/problems/rotting-oranges/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class Amazon_RottenOranges {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] oranges = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int[][] oranges1 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		int[][] oranges2 = { { 0, 2 } };

		System.out.println(orangesRotting(oranges));
		System.out.println(orangesRotting(oranges1));
		System.out.println(orangesRotting(oranges2));
	}

	public static int orangesRotting(int[][] grid) {
		int freshCnt = 0;
		Queue<int[]> rotten = new LinkedList<>();
		int[][] checkDirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					rotten.offer(new int[] { i, j });
				}
				if (grid[i][j] == 1) {
					freshCnt++;
				}
			}
		}

		if (freshCnt == 0)
			return 0;
		if (rotten.isEmpty())
			return -1;

		int minutes = 0;
		while (!rotten.isEmpty() && freshCnt > 0) {
			minutes++;
			int size = rotten.size();
			for (int i = 0; i < size; i++) {
				int[] coord = rotten.poll();
				for (int[] dir : checkDirs) {
					int row = coord[0] + dir[0];
					int col = coord[1] + dir[1];
					if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1)
						continue;
					rotten.offer(new int[] { row, col });
					grid[row][col] = 2;
					freshCnt--;
				}
			}
		}

		return freshCnt != 0 ? -1 : minutes;
	}
}
