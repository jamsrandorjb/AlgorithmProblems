package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 102. Binary Tree Level Order Traversal
* problem url: https://leetcode.com/problems/binary-tree-level-order-traversal/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class BSTLevelOrderTraverse {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(3);
		root.right = child2;
		root.left = child1;

		System.out.println(levelOrder(root));
		System.out.println(levelOrder(null));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new LinkedList<>();

			while (size != 0) {
				TreeNode currentRoot = queue.poll();
				level.add(currentRoot.val);
				if (currentRoot.left != null) {
					queue.offer(currentRoot.left);
				}
				if (currentRoot.right != null) {
					queue.offer(currentRoot.right);
				}
				size--;
			}

			result.add(level);
		}

		return result;
	}
}