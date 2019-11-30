package leetcode.tree;

/*
* 112. Path Sum
* problem url: https://leetcode.com/problems/path-sum/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class HasPathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;

		System.out.println(hasPathSum(root, 2));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}