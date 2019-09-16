package leetcode;

/*
* Find Peak Element
* problem url: https://leetcode.com/problems/find-peak-element/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPeakElement(new int[] {0, 1, 5, 6, 7, 8, 9, 5, 0}));
	}
	
	public static int findPeakElement(int[] nums) {
        for(int i = 1; i < nums.length; i++){
        	//checking the odd case when the Peak is last element of an Array
            if(nums[i] > nums[i-1] && i+1 >= nums.length){
                return i;
            }
            //checking the normal case when the element is in the middle of the Array
            if(nums[i] > nums[i-1] && i+1 < nums.length && nums[i+1] < nums[i]){
                return i;       
            }
        }
        
        //we haven't found any Peak element
        return 0;
    }
}
