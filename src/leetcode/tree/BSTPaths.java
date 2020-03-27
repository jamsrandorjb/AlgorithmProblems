package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/*
* 257. Binary Tree Paths
* problem url: https://leetcode.com/problems/binary-tree-paths/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class BSTPaths {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(3);
		root.right = child2;
		root.left = child1;

		System.out.println(binaryTreePaths(root));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();
		if (root == null)
			return paths;

		dfs(root, "", paths);

		return paths;
	}

	private static void dfs(TreeNode current, String path, List<String> paths) {
		path += current.val;
		if (current.left == null && current.right == null) {
			paths.add(path);
			return;
		}

		if (current.left != null)
			dfs(current.left, path + "->", paths);
		if (current.right != null)
			dfs(current.right, path + "->", paths);
	}
}