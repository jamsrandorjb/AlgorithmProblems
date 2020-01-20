package leetcode;

/*
* 540. Single Element in a Sorted Array
* problem url: https://leetcode.com/problems/single-element-in-a-sorted-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SingleNonDuplicateElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNonDuplicate(new int[] {0, 1, 1, 3, 3, 5}));
	}

	 public static int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1])  return nums[i];
        }
        
        return nums[nums.length - 1];
    }
}
