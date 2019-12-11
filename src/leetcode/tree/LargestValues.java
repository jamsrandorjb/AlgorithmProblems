package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 515. Find Largest Value in Each Tree Row
* problem url: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class LargestValues {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);

		child1.left = child2;
		root.right = child1;
		System.out.println(largestValues(root));
	}

	public static List<Integer> largestValues(TreeNode root) {
		if (root == null)
			return new LinkedList<Integer>();
		int levelMax = root.val;
		List<Integer> result = new LinkedList<>();
		Queue<TreeNode> levelChildren = new LinkedList<TreeNode>();
		levelChildren.add(root);

		while (levelChildren.size() > 0) {
			int childrenCount = levelChildren.size();
			for (int i = 0; i < childrenCount; i++) {
				TreeNode temp = levelChildren.poll();
				levelMax = Math.max(levelMax, temp.val);
				if (temp.right != null)
					levelChildren.add(temp.right);
				if (temp.left != null)
					levelChildren.add(temp.left);
			}
			result.add(levelMax);
			levelMax = Integer.MIN_VALUE;
		}

		return result;
	}
}