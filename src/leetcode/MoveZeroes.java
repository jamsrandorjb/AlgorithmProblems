package leetcode;

/*
* Move Zeroes
* problem url: https://leetcode.com/problems/move-zeroes/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {0, 0, 1};
		moveZeroes(arr);
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void moveZeroes(int[] nums) {
		for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] == 0)
        	{
        		for(int j = i; j < nums.length - 1; j++) {
        			int tempPointer = nums[j];
                	nums[j] = nums[j+1];
                	nums[j+1] = tempPointer;
                }	
        	}	
        }
    }
}
