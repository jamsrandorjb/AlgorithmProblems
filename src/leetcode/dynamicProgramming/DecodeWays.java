package leetcode.dynamicProgramming;

/*
 * 91. Decode Ways
 * problem url: https://leetcode.com/problems/decode-ways/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("1"));
		System.out.println(numDecodings("226"));

	}

	public static int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i <= s.length(); i++) {
			int digitOne = Integer.parseInt(s.substring(i - 1, i));
			int digitTwo = Integer.parseInt(s.substring(i - 2, i));
			if (digitOne > 0)
				dp[i] += dp[i - 1];
			if (digitTwo > 9 && digitTwo < 27)
				dp[i] += dp[i - 2];
		}

		return dp[s.length()];
	}

}
