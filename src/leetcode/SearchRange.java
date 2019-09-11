package leetcode;

/*
* 34. Find First and Last Position of Element in Sorted Array
* problem url: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchRange(new int[] {1,3,4,5,5,5,5,6}, 5));
	}

	public static int[] searchRange(int[] nums, int target) {
		//declaring result array with expected default value
        int[]  result = new int[] {-1, -1};
        
        for(int i=0; i < nums.length; i++){
        	//if the i th element equals to target we have to update the result array
            if(nums[i] == target)
            {
            	//if it is the first time occurring we have to change both of the array
                if(result[0] == -1){
                    result[0] = i;
                    result[1] = i;
                }
                else{
                	//else we have to change only the last element of the array
                    result[1] = i;
                }
            }
        }
        
        //Time complexity : O(n)
        return result;
    }
}
