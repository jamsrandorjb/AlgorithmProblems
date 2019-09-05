package leetcode;
import java.util.ArrayList;

/*
* Reverse Integer
* problem url: https://leetcode.com/problems/remove-element/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {0,1,2,2,3,0,4,2};
		int len = removeElement(arr, 2);
		for (int i = 0; i < len; i++) {
		    System.out.println(arr[i]);
		}
	}
	
	public static int removeElement(int[] nums, int val) {
		//declarint Integer Array to hold the return values
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			//checking the element should be removed or not
			if(nums[i] != val) {
				arr.add(nums[i]);	
			}
		}
		
		//modifying the input array to follow the problem structure
		for(int i = 0; i < arr.size(); i++) {
			nums[i] = arr.get(i);
		}
		
		//returning the size the new array to print out
		return arr.size();
    }
}
