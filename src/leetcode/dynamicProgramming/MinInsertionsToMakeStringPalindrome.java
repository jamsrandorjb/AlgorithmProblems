package leetcode.dynamicProgramming;

/*
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * problem url: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class MinInsertionsToMakeStringPalindrome {
	public static void main(String[] args) {
		System.out.println(minInsertions("zaz"));
		System.out.println(minInsertions("mbadm"));
	}

	public static int minInsertions(String text) {
		int n = text.length();
		int[][] dp = new int[n+1][n+1];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				if(text.charAt(i - 1) == text.charAt(n - j)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					continue;
				}
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return n-dp[n][n];
	}
}
