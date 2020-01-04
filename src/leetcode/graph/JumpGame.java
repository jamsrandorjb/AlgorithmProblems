package leetcode.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* 5297. Jump Game III
* problem url: https://leetcode.com/problems/jump-game-iii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class JumpGame {

	public static void main(String[] args) {
		System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5));
	}

	public static boolean canReach(int[] arr, int start) {
		Set<Integer> visited = new HashSet<Integer>();
		bfs(arr, start, visited);

		Iterator<Integer> itr = visited.iterator();
		while (itr.hasNext()) {
			if (arr[itr.next()] == 0)
				return true;
		}

		return false;
	}

	private static void bfs(int[] arr, int start, Set<Integer> visited) {
		if (visited.size() == arr.length)
			return;
		visited.add(start);

		if (start - arr[start] >= 0 && !visited.contains(start - arr[start]))
			bfs(arr, start - arr[start], visited);
		if (start + arr[start] < arr.length && !visited.contains(start + arr[start]))
			bfs(arr, start + arr[start], visited);
	}
}
