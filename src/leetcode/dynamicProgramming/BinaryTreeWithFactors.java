package leetcode.dynamicProgramming;

/*
 * 823. Binary Trees With Factors
 * problem url: https://leetcode.com/problems/binary-trees-with-factors/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class BinaryTreeWithFactors {
	public static void main(String[] args) {
		System.out.println(numFactoredBinaryTrees({2, 4}));
		System.out.println(numFactoredBinaryTrees({2,4,5,10}));
	}

	public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int MOD = 1_000_000_007;
        long[] dp = new long[N];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < N; i++) {
            map.put(arr[i], i);
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i]%arr[j] != 0)
                    continue;
                int right = arr[i]/arr[j];
                if(map.containsKey(right))
                {
                    dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % MOD;
                }
            }
        }
        
        long ans = 0;
        for(long x : dp) ans += x;
        
        return (int) (ans % MOD);
    }
}
