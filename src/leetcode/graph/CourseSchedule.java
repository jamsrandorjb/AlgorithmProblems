package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
* 207. Course Schedule
* problem url: https://leetcode.com/problems/course-schedule/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class CourseSchedule {
	public static void main(String[] args) {

		System.out.println(canFinish(4, new int[][] { { 1, 0 }, { 2, 1 }, { 2, 3 }, { 3, 2 } }));
		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int count = 0;
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> adjs = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();

		//building adjacents and counting indegrees
		for (int[] pr : prerequisites) {
			List<Integer> adj = adjs.getOrDefault(pr[1], new LinkedList<>());
			inDegree[pr[0]]++;
			adj.add(pr[0]);
			adjs.put(pr[1], adj);
		}

		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			count++;
			if (!adjs.containsKey(cur))
				continue;
			for (int neighbor : adjs.get(cur)) {
				inDegree[neighbor]--;
				if (inDegree[neighbor] != 0)
					continue;
				queue.offer(neighbor);
			}
		}

		return count == numCourses;
	}
}