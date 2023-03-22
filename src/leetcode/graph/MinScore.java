package leetcode.graph;

/*
* 2492. Minimum Score of a Path Between Two Cities
* problem url: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MinScore {

	public static void main(String[] args) {
		int[][] roads = new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
		minScore(4, roads);		
	}

	public static int minScore(int n, int[][] roads) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> seen = new HashSet<>();
		int result = Integer.MAX_VALUE;
		queue.offer(1);
		seen.add(1);

		//create adjacency map
		for(int[] road: roads) {
			if(!map.containsKey(road[0])) map.put(road[0], new ArrayList<>());
			map.get(road[0]).add(new int[] {road[1], road[2]});
			if(!map.containsKey(road[1])) map.put(road[1], new ArrayList<>());
			map.get(road[1]).add(new int[] {road[0], road[2]});
		}

		//BFS search
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if(!map.containsKey(node)) continue;
			for(int[] neighbor: map.get(node)) {
				result = Math.min(neighbor[1], result);
				if(seen.contains(neighbor[0])) continue;
				queue.offer(neighbor[0]);
				seen.add(neighbor[0]);
			}
		}
		
		return result;
    }
}
