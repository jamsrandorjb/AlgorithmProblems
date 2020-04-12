package leetcode.heap;

import java.util.PriorityQueue;

/*
* 1167. Minimum Cost to Connect Sticks
* problem url: https://leetcode.com/problems/minimum-cost-to-connect-sticks/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MinimumCostToCombineSticks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(connectSticks(new int[] { 2, 4, 3 }));
		System.out.println(connectSticks(new int[] { 1, 8, 3, 5 }));
	}

	public static int connectSticks(int[] sticks) {
		int cost = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int stick : sticks)
			minHeap.offer(stick);

		while (minHeap.size() > 1) {
			int sum = minHeap.poll() + minHeap.poll();
			minHeap.offer(sum);
			cost += sum;
		}

		return cost;
	}
}
