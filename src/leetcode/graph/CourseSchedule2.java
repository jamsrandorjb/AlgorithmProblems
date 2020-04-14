package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
* 210. Course Schedule II
* problem url: https://leetcode.com/problems/course-schedule-ii/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class CourseSchedule2 {
	public static void main(String[] args) {

		System.out.println(findOrder(4, new int[][] { { 1, 0 }, { 2, 1 }, { 2, 3 }, { 3, 2 } }));
		System.out.println(findOrder(2, new int[][] { { 1, 0 } }));
		System.out.println(findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int count = 0;
		Map<Integer, List<Integer>> adjs = new HashMap<>();
		int[] inDegree = new int[numCourses];
		int[] order = new int[numCourses];
		Queue<Integer> edges = new LinkedList<>();

		for (int[] pr : prerequisites) {
			List<Integer> adj = adjs.getOrDefault(pr[1], new LinkedList<>());
			adj.add(pr[0]);
			inDegree[pr[0]]++;
			adjs.put(pr[1], adj);
		}

		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] != 0)
				continue;
			edges.offer(i);
		}

		while (!edges.isEmpty()) {
			int edge = edges.poll();
			order[count] = edge;
			count++;
			if (!adjs.containsKey(edge))
				continue;
			for (int neighbor : adjs.get(edge)) {
				inDegree[neighbor]--;
				if (inDegree[neighbor] != 0)
					continue;
				edges.offer(neighbor);
			}
		}

		if (numCourses != count)
			return new int[0];

		return order;
	}
}