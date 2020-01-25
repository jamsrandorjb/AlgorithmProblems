package leetcode.graph;

/*
* 286. Walls and Gates
* problem url: https://leetcode.com/problems/walls-and-gates/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class WallsAndGates {

	public static void main(String[] args) {
		int[][] rooms = new int[][] { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };
				
		wallsAndGates(rooms);
		
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j, 0);
				}
			}
		}
	}

	private static void dfs(int[][] rooms, int i, int j, int distance) {
		if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < distance)
			return;
		rooms[i][j] = distance;

		dfs(rooms, i + 1, j, distance + 1);
		dfs(rooms, i - 1, j, distance + 1);
		dfs(rooms, i, j + 1, distance + 1);
		dfs(rooms, i, j - 1, distance + 1);
	}
}
