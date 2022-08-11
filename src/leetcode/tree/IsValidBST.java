package leetcode.tree;

/*
* 98. Validate Binary Search Tree
* problem url: https://leetcode.com/problems/validate-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class IsBalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;

		System.out.println(isValidBST(root));
	}

	public static boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    private static boolean validateBST(TreeNode node, Integer left, Integer right)
    {
        if(node == null) return true;
        
        if((left == null || node.val > left) && (right == null || node.val < right))
        {
            return validateBST(node.left, left, node.val) && validateBST(node.right, node.val, right);
        }
        
        return false;
        
    }
}
