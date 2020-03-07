package leetcode.dynamicProgramming;

/*
 * 746. Min Cost Climbing Stairs
 * problem url: https://leetcode.com/problems/min-cost-climbing-stairs/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class MinCostClimbingStairs {
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
	}

	public static int minCostClimbingStairs(int[] cost) {

		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 2], cost[i - 1]);
		}

		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}
}
