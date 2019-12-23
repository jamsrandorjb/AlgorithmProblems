package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
* 1161. Maximum Level Sum of a Binary Tree
* problem url: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MaximumLevelSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);

		child1.left = child2;
		root.right = child1;
		System.out.println(maxLevelSum(root));
	}

	public static int maxLevelSum(TreeNode root) {
		Queue<TreeNode> levelChildren = new LinkedList<TreeNode>();

		int maxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		int currentLevel = 0;
		levelChildren.add(root);

		while (levelChildren.size() > 0) {
			int sum = 0;
			currentLevel++;
			int levelLimit = levelChildren.size();

			for (int i = 0; i < levelLimit; i++) {
				TreeNode temp = levelChildren.poll();
				sum += temp.val;
				if (temp.right != null)
					levelChildren.add(temp.right);
				if (temp.left != null)
					levelChildren.add(temp.left);
			}

			if (maxSum < sum) {
				maxSum = sum;
				maxLevel = currentLevel;
			}
		}

		return maxLevel;
	}
}