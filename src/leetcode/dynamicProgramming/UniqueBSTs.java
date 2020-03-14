package leetcode.dynamicProgramming;

/*
* 96. Unique Binary Search Trees
* problem url: https://leetcode.com/problems/unique-binary-search-trees/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class UniqueBSTs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
		System.out.println(numTrees(5));
		System.out.println(numTrees(6));
		System.out.println(numTrees(7));
	}
	
	public static int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i<= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] += dp[j-1] * dp[i-j];
			}
		}
		
        return dp[n];
    }
}
