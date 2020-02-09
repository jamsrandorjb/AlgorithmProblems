package leetcode.dynamicProgramming;

/*
 * 1143. Longest Common Subsequence
 * problem url: https://leetcode.com/problems/longest-common-subsequence/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length()+1][text2.length()+1];
		for(int i = 1; i <= text1.length(); i++) {
			for(int j = 1; j <= text2.length(); j++ ) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					continue;
				}
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return dp[text1.length()][text2.length()];
		//return lcsRecursive(text1, text2, 0, 0);
	}
	
	@SuppressWarnings("unused")
	private static int lcsRecursive(String text1, String text2, int i, int j) {
		if(i >= text1.length() || j >= text2.length()) return 0;
		if(text1.charAt(i) == text2.charAt(j)) return 1 + lcsRecursive(text1, text2, i+1, j+1);
		
		return Math.max(lcsRecursive(text1,  text2, i+1, j), lcsRecursive(text1, text2, i, j+1));
	}
}
