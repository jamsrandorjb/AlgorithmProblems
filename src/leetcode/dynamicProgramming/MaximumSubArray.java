package leetcode.dynamicProgramming;

/*
 * 53. Maximum Subarray 
 * problem url: https://leetcode.com/problems/maximum-subarray/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama  
 */
public class MaximumSubArray {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { 1, 2, 23, 43, 43, 4, 3, 54, 5, 4, -1 }));
	}

	public static int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return Integer.MIN_VALUE;

		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
			result = Math.max(sum[i], result);
		}

		return result;
	}
}
