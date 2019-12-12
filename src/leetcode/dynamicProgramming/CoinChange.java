package leetcode.dynamicProgramming;

import java.util.Arrays;

/*
 * 322. Coin Change
 * problem url: https://leetcode.com/problems/coin-change/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class CoinChange {
	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 5, 2 }, 11));
	}

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.sort(coins);
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] > i)
					break;
				dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}
}
