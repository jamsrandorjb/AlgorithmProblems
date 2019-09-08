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
		//declaring variable to track lastIndex where the zero is
		int zeroPointer = -1;
        
        for(int i = 0; i < nums.length; i++)
        {
        	//zero is occurring the first time
        	if(nums[i] == 0 && zeroPointer == -1){
                zeroPointer = i;
            }
        	//non zero is occurring, swap and increment the tracker
        	else if(nums[i] != 0 && zeroPointer != -1)
            {
                nums[zeroPointer] = nums[i];
                nums[i] = 0;
                zeroPointer++;
        	}	
        }
    }
}
