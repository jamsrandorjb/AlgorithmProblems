package leetcode.tree;

/*
* 606. Construct String from Binary Tree
* problem url: https://leetcode.com/problems/construct-string-from-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ConstructStringFromBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		
		System.out.println(tree2str(root));
	}
	
	public static String tree2str(TreeNode root) {
        if(root == null)
            return "";
        
        if(root.left == null && root.right == null)
            return root.val + "";
        
        if(root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
        
        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
    }
}
