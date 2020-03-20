package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/*
* 1382. Balance a Binary Search Tree
* problem url: https://leetcode.com/problems/balance-a-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BalanceBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		TreeNode child3 = new TreeNode(4);
		child1.right = child2;
		child2.right = child3;
		root.right = child1;

		TreeNode result = balanceBST(root);
		System.out.println(PrintBinaryTree.printTree(root));
		System.out.println(PrintBinaryTree.printTree(result));
	}

	public static TreeNode balanceBST(TreeNode root) {
		List<Integer> nodes = new LinkedList<>();
		traverse(root, nodes);

		return buildBST(nodes, 0, nodes.size() - 1);
	}

	private static TreeNode buildBST(List<Integer> nodes, int left, int right) {
		if (left > right)
			return null;

		int mid = left + (right - left) / 2;
		TreeNode levelRoot = new TreeNode(nodes.get(mid));
		levelRoot.left = buildBST(nodes, left, mid - 1);
		levelRoot.right = buildBST(nodes, mid + 1, right);

		return levelRoot;
	}

	private static void traverse(TreeNode node, List<Integer> nodes) {
		if (node == null)
			return;
		traverse(node.left, nodes);
		nodes.add(node.val);
		traverse(node.right, nodes);
	}
}