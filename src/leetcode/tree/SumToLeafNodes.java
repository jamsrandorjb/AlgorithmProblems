package leetcode.tree;

/*
* 129. Sum Root to Leaf Numbers
* problem url: https://leetcode.com/problems/sum-root-to-leaf-numbers/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SumToLeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;

		System.out.println(sumNumbers(root));
	}

	public static int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}

	private static int sumNumbersHelper(TreeNode root, int parentSum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return parentSum * 10 + root.val;
		return sumNumbersHelper(root.left, parentSum * 10 + root.val)
				+ sumNumbersHelper(root.right, parentSum * 10 + root.val);
	}
}
