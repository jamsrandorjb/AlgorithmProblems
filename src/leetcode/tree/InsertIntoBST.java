package leetcode.tree;

/*
* 701. Insert into a Binary Search Tree
* problem url: https://leetcode.com/problems/insert-into-a-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class InsertIntoBST {
	public static void main(String[] args) {
		System.out.println(insertIntoBST(null, 5).val);
		System.out.println(insertIntoBST(null, 3).val);
	}
	
	public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val)
            root.left = insertIntoBST(root.left, val);  
        else
           root.right = insertIntoBST(root.right, val);   
        
        return root;
    }
}