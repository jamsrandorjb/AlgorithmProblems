package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import leetcode.linkedList.ListNode;

/*
* 109. Convert Sorted List to Binary Search Tree
* problem url: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ConvertSortedListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(4);
		sortedListToBST(newnode1);
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		List<Integer> sortedList = new ArrayList<>();
		while (head != null) {
			sortedList.add(head.val);
			head = head.next;
		}

		return buildTreeRecursive(sortedList, 0, sortedList.size()-1);
	}

	private static TreeNode buildTreeRecursive(List<Integer> sortedList, int left, int right) {
		if (left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode current = new TreeNode(sortedList.get(mid));
		current.left = buildTreeRecursive(sortedList, left, mid - 1);
		current.right = buildTreeRecursive(sortedList, mid + 1, right);

		return current;
	}
}
