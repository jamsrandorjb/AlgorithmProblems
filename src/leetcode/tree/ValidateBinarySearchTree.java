package leetcode.tree;

/*
* 144. Binary Tree Preorder Traversal
* problem url: https://leetcode.com/problems/binary-tree-preorder-traversal/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(isValidBST(root));
	}
	
	static Integer prev = null;
    
    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(prev != null && root.val <= prev) return false;
        prev = root.val;
        if(!isValidBST(root.right)) return false;
        
        return true;
    }
}
