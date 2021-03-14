package leetcode;

/*
 * 1480. Running Sum of 1d Array
 * problem url: https://leetcode.com/problems/running-sum-of-1d-array/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */

public class RunningSum {
	public static void main(String[] args) {
		int[] matrix = new int[] { 7, 8, 9 };
		for(int x : runningSum(matrix))
			System.out.println(x);
	}

	public static int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        
        return nums;
    }
}
