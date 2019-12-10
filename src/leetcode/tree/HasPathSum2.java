package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
* 113. Path Sum II
* problem url: https://leetcode.com/problems/path-sum-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class HasPathSum2 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(1);
		child1.left = child2;
		root.right = child1;

		System.out.println(pathSum(root, 3));
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		pathSumBuild(root, sum, result, new ArrayList<>());

		return result;
	}

	private static void pathSumBuild(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tempResult) {
		if (root == null)
			return;

		tempResult.add(root.val);

		if (root.left == null && root.right == null && root.val == sum) {
			result.add(tempResult);
			return;
		}

		pathSumBuild(root.left, sum - root.val, result, new ArrayList<>(tempResult));
		pathSumBuild(root.right, sum - root.val, result, new ArrayList<>(tempResult));
	}
}