package leetcode.tree;

/*
* 110. Balanced Binary Tree
* problem url: https://leetcode.com/problems/balanced-binary-tree/
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

		System.out.println(isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int left = getDepth(root.left);
		int right = getDepth(root.right);

		if (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
	}

	private static int getDepth(TreeNode node) {
		if (node == null)
			return 0;

		return 1 + Math.max(getDepth(node.left), getDepth(node.right));
	}
}
