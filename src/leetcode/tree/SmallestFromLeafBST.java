package leetcode.tree;

import java.util.PriorityQueue;

/*
* 988. Smallest String Starting From Leaf
* problem url: https://leetcode.com/problems/smallest-string-starting-from-leaf/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SmallestFromLeafBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(2);
		root.left = child2;
		root.right = child1;

		System.out.println(smallestFromLeaf(root));
	}

	public static String smallestFromLeaf(TreeNode root) {
		if (root == null)
			return "";
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		PriorityQueue<String> paths = new PriorityQueue<>((a, b) -> a.compareTo(b));
		dfs(root, "", paths, chars);

		return paths.poll();
	}

	private static void dfs(TreeNode current, String path, PriorityQueue<String> paths, char[] chars) {
		path = chars[current.val] + path;
		if (current.right == null && current.left == null) {
			paths.offer(path);
			return;
		}

		if (current.left != null)
			dfs(current.left, path, paths, chars);
		if (current.right != null)
			dfs(current.right, path, paths, chars);
	}
}
