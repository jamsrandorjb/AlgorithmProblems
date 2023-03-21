package leetcode;

/*
 * 2348. Number of Zero-Filled Subarrays
 * problem url: https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class ZeroFilledSubArrays {
	public static void main(String[] args) {
		System.out.println(zeroFilledSubarray(new int[] {0, 0, 0, 1}));
		System.out.println(zeroFilledSubarray(new int[] {0, 0, 0, 0}));
	}

	public static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long temp = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                temp++;
            } else {
                temp = 0;
            }

            result += temp;            
        }

        return result;
    }
}