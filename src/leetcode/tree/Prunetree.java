package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
* 655. Print Binary Tree
* problem url: https://leetcode.com/problems/print-binary-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class Prunetree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);

		System.out.println(pruneTree(root));
	}

	public static TreeNode pruneTree(TreeNode root) {
		if(root == null || (root.val == 0 && root.left == null && root.right == null)) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if(node.left != null && !containsOne(node.left)) {
				node.left = null;
			}
			if(node.right != null && !containsOne(node.right)) {
				node.right = null;
			}
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}
		
		return root;
	}
	
	private static boolean containsOne(TreeNode node) {
		if(node == null) return false;
		if(node.val == 1) return true;
		
		return containsOne(node.left) || containsOne(node.right);
	}
	
}
