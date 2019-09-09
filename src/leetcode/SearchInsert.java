package leetcode;

/*
* Check Search Insert Position
* problem url: https://leetcode.com/problems/search-insert-position/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SearchInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[] {1,3,5}, 5));
	}

	public static int searchInsert(int[] nums, int target) {
		//if the target is 0, it should always go in the first element
        if(target == 0) return target;
        
        for(int i = 0; i < nums.length; i++){
        	//if the i th element of the array is equal or bigger than the target then return the index
            if(nums[i] >= target){
                return i;   
            }
        }
        
        //if we had no match so target should go end of the array
        return nums.length;
    }
}
