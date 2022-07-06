package leetcode.dynamicProgramming;

/*
 * 509. Fibonacci Number
 * problem url: https://leetcode.com/problems/fibonacci-number/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class FibonacciNumber {
	public static void main(String[] args) {
		System.out.println(fib(11));
		System.out.println(fibRec(11));
	}

	public static int fib(int n) {
        if(n < 2) return n;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
	
	public static int fibRec(int n) {
        if(n < 2) return n;
        
        return fibRec(n-2) + fibRec(n-1);
    }
}
