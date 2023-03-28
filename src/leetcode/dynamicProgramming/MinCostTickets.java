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
		int[] dp = new int[365 + 30 + 1];
        Set<Integer> set = new HashSet<>();
        for(int d: days) set.add(d);
        for(int i = 365; i >= 1; i--) {
            if(!set.contains(i)) {
                dp[i] = dp[i+1];
                continue;
            }
            dp[i] = Math.min(dp[i+7] + costs[1], dp[i+1] + costs[0]);
            dp[i] = Math.min(dp[i], dp[i+30] + costs[2]);
        }

        return dp[1];
	}
}
