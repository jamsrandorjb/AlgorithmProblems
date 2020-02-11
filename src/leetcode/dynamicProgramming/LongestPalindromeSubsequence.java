package leetcode.dynamicProgramming;

/*
 * 516. Longest Palindromic Subsequence
 * problem url: https://leetcode.com/problems/longest-palindromic-subsequence/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class LongestPalindromeSubsequence {
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("ace"));
		System.out.println(longestPalindromeSubseq("bbbab"));
	}

	public static int longestPalindromeSubseq(String text) {
		int n = text.length();
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++){
				if(text.charAt(i-1) == text.charAt(n-j)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[n][n]; 
	}
}
