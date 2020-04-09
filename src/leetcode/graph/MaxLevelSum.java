package leetcode.graph;

import leetcode.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/*
* 1161. Maximum Level Sum of a Binary Tree
* problem url: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaxLevelSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(7);
		TreeNode l2 = new TreeNode(7);
		TreeNode l3 = new TreeNode(-8);
		l1.left = l2;
		l1.right = l3;
		root.left = l1;
		root.right = new TreeNode(0);

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
