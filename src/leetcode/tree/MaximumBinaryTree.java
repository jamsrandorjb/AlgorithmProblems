package leetcode.tree;

/*
* Construct Maximum Binary Tree from an array
* problem url: https://leetcode.com/problems/maximum-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MaximumBinaryTree {
	public static void main(String[] args) {
		TreeNode t1 = constructMaximumBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
	}
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    
    private static TreeNode construct(int[] nums, int left, int right){
        if(left == right) return null;
        
        int max_i = getMaxIndex(nums, left, right); 
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, left, max_i);
        root.right = construct(nums, max_i+1, right);
        
        return root;
    }
    
    private static int getMaxIndex(int[] nums, int left, int right){
        int max_i = left;
        for(int i = left; i < right; i++){
            if(nums[i] > nums[max_i]){
                max_i = i;
            }
        }
        
        return max_i;
    }
}