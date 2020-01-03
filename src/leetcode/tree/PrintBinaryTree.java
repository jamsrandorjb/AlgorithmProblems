package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/*
* 655. Print Binary Tree
* problem url: https://leetcode.com/problems/print-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class PrintBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		System.out.println(printTree(root));
	}

	static int tilt = 0;

	public static List<List<String>> printTree(TreeNode root) {
		List<List<String>> result = new ArrayList<>();
		if (root == null)
			return result;

		int h = height(root);
		int n = ((int) Math.pow(2, h)) - 1;

		for (int i = 0; i < h; i++)
			result.add(new ArrayList<String>(Collections.nCopies(n, "")));

		traverseTree(root, result, 0, 0, n);

		return result;
	}

	private static void traverseTree(TreeNode root, List<List<String>> list, int height, int left, int right) {
		if (root == null)
			return;
		list.get(height).set((left + right) / 2, root.val + "");

		traverseTree(root.left, list, height + 1, left, ((left + right) / 2));
		traverseTree(root.right, list, height + 1, (left + right) / 2, right);
	}

	private static int height(TreeNode node) {
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}
}
