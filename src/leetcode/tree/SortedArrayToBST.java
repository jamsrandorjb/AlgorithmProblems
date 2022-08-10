package leetcode.tree;

/*
* 108. Convert Sorted Array to Binary Search Tree
* problem url: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9});
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        
        return rec(nums, 0, nums.length -1);
    }
    
    private static TreeNode rec(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = rec(nums, left, mid - 1);
        root.right = rec(nums, mid + 1, right);
        
        return root;
    }
}
