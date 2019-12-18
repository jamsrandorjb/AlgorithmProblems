package leetcode.dynamicProgramming;

import java.util.Arrays;

/*
 * 518. Coin Change 2
 * problem url: https://leetcode.com/problems/coin-change-2/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class CoinChange2 {
	public static void main(String[] args) {
		System.out.println(change(new int[] { 1, 5, 2 }, 5));
	}

	public static int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
		Arrays.sort(coins);
        dp[0] = 1;
        
        for(int coin: coins) {
            for(int i = coin; i < dp.length; i++)
                dp[i] += dp[i - coin];
        }

		return dp[amount];
    }
}
