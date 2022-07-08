package leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
* 97. Interleaving String
* problem url: https://leetcode.com/problems/interleaving-string/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class InterleavingString {
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "adbbca", "aaadbbcbcac"));
	}
	
	static String s1;
	static String s2;
	static String s3;
	static int[][] dp;
	
	public static boolean isInterleave(String _s1, String _s2, String _s3) {
		s1 = _s1;
		s2 = _s2;
		s3 = _s3;
		if(s1.length() + s2.length() != s3.length())
			return false;
		dp = new int[s1.length()+1][s2.length()+1];
		
		return isInterleave(0, 0);
	}
	
	private static boolean isInterleave(int i1, int i2) {
		int i3 = i1 + i2;	
		if(i3 == s3.length()) return true;
		
		if(dp[i1][i2] != 0) return dp[i1][i2] == 1;
		
		if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3) && isInterleave(i1+1, i2)) {
			dp[i1][i2] = 1;
			return true;
		}
		
		if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3) && isInterleave(i1, i2+1)) {
			dp[i1][i2] = 1;
			return true;
		}
		
		dp[i1][i2] = 2;
		return false;
	}
}
