package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* 939. Minimum Area Rectangle
* problem url: https://leetcode.com/problems/minimum-area-rectangle/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class MinAreaRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minAreaRect(new int[][] { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } }));
	}

	public static int minAreaRect(int[][] points) {
		// if the length is less than 4 we return 0
		if (points.length < 4)
			return 0;

		int result = Integer.MAX_VALUE;
		HashMap<Integer, Set<Integer>> hMapX = new HashMap<>();

		for (int[] point : points) {
			
			int x1 = point[0];
			int y1 = point[1];

			for (Map.Entry<Integer, Set<Integer>> entry : hMapX.entrySet()) {
				for (Integer y2 : entry.getValue()) {
					int x2 = entry.getKey();
					if (hMapX.containsKey(x2) && hMapX.get(x2).contains(y1) && 
						hMapX.containsKey(x1) && hMapX.get(x1).contains(y2)) 
					{
						// calculate the area
						int area = Math.abs(y2 - y1) * Math.abs(entry.getKey() - x1);
						result = Math.min(area, result);
					}
				}

			}
			
			Set<Integer> hSet = hMapX.getOrDefault(point[0], new HashSet<Integer>());
			hSet.add(y1);
			hMapX.put(x1, hSet);
		}

		return result == Integer.MAX_VALUE ? 0 : result;
	}
}
