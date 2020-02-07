package leetcode.tree;

/*
* 543. Diameter of Binary Tree
* problem url: https://leetcode.com/problems/diameter-of-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);

		child1.left = child2;
		root.right = child1;

		System.out.println(diameterOfBinaryTree(root));
	}

	static int ans;

	public static int diameterOfBinaryTree(TreeNode root) {
		ans = 0;
		depth(root);

		return ans;
	}

	private static int depth(TreeNode root) {
		if (root == null)
			return 0;

		int L = depth(root.left);
		int R = depth(root.right);
		ans = Math.max(ans, L + R);

		return 1 + Math.max(L, R);
	}
}
