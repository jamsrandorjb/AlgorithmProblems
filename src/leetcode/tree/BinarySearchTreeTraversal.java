package leetcode.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 173. Binary Search Tree Iterator
* problem url: https://leetcode.com/problems/binary-search-tree-iterator/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BinarySearchTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);

		TreeNode child1 = new TreeNode(2);
		TreeNode child2 = new TreeNode(3);
		child1.left = child2;
		root.right = child1;
		BSTIterator obj = new BSTIterator(root);

		System.out.println(obj.next());
		System.out.println(obj.hasNext());

	}
}

class BSTIterator {

	PriorityQueue<TreeNode> minHeap = new PriorityQueue<TreeNode>(new Comparator<TreeNode>() {
		public int compare(TreeNode t1, TreeNode t2) {
			return t1.val - t2.val;
		}
	});

	public BSTIterator(TreeNode root) {
		inOrderBuildHeap(root);
	}

	private void inOrderBuildHeap(TreeNode root) {
		if (root == null)
			return;

		inOrderBuildHeap(root.left);
		minHeap.offer(root);
		inOrderBuildHeap(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp = minHeap.poll();
		return temp.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !minHeap.isEmpty();
	}
}
