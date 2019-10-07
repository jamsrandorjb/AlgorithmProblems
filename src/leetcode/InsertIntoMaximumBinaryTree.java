package leetcode;

/*
* Insert into Maximum Binary Tree
* problem url: https://leetcode.com/problems/maximum-binary-tree-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class InsertIntoMaximumBinaryTree {
	public static void main(String[] args) {
		insertIntoMaxTree(null, 5);
	}
	
	public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        
        if(val > root.val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        
        root.right = insertIntoMaxTree(root.right, val);
        
        return root;
    }
}