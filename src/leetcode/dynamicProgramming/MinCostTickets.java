package leetcode.dynamicProgramming;

/*
 * 983. Minimum Cost For Tickets
 * problem url: https://leetcode.com/problems/minimum-cost-for-tickets/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class MinCostTickets {
	public static void main(String[] args) {
		System.out.println(mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));
	}

	public static int mincostTickets(int[] days, int[] costs) {
		int[] memo = new int[days[days.length - 1] + 1];
		boolean[] travel = new boolean[days[days.length - 1] + 1];
		for (int i : days)
			travel[i] = true;

		return dp(memo, travel, costs, days[days.length - 1]);
	}

	private static int dp(int[] memo, boolean[] travel, int[] costs, int day) {
		if (day <= 0)
			return 0;
		if (!travel[day])
			return dp(memo, travel, costs, day - 1);
		if (memo[day] != 0)
			return memo[day];

		int one = dp(memo, travel, costs, day - 1) + costs[0];
		int seven = dp(memo, travel, costs, day - 7) + costs[1];
		int thirty = dp(memo, travel, costs, day - 30) + costs[2];

		memo[day] = Math.min(Math.min(one, seven), thirty);

		return memo[day];
	}
}
