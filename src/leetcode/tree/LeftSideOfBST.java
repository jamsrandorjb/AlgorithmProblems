package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 199. Binary Tree Right Side View
* problem url: https://leetcode.com/problems/binary-tree-right-side-view/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class LeftSideOfBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);

		child1.left = child2;
		root.right = child1;
		root.left = new TreeNode(0);
		System.out.println(rightSideView(root));
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> visibleSide = new LinkedList<>();
		if (root == null)
			return visibleSide;

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root);

		while (!nodes.isEmpty()) {
			int levelSize = nodes.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = nodes.poll();
				if (i == levelSize - 1)
					visibleSide.add(current.val);
				if (current.left != null)
					nodes.offer(current.left);
				if (current.right != null)
					nodes.offer(current.right);
			}
		}

		return visibleSide;
	}
}