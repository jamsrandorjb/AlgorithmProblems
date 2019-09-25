package leetcode;

/*
* Find Pivot Index
* problem url: https://leetcode.com/problems/find-pivot-index/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pivotIndex(new int[] {0, 1, 5, 6, 7, 8, 9, 5, 0}));
	}
	
	public static int pivotIndex(int[] nums) {
		//declaring 2 variables that holds leftSum and overall sum
        int sum = 0;
        int leftSum = 0;
        
        //calculating the total sum
        for(int x : nums) sum += x;
        
        for(int i = 0; i< nums.length; i++){
        	//if the leftSum is equal to rightSum then we found the pivot
            if(leftSum == sum - leftSum - nums[i]) return i;
            //otherwise we have to increase the leftSum do check it again
            leftSum += nums[i];
        }
        
        //we haven't found any pivot
        return -1;
    }
}
