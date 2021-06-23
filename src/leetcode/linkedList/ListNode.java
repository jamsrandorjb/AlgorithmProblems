package leetcode.linkedList;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode random;
	
	public ListNode() {
		random = null;
		next = null;
	}

	public ListNode(int x) {
		val = x;
		random = null;
		next = null;
	}

	public static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;

		return node;
	}

	public static void printListNode(ListNode l) {
		while (l != null) {
			System.out.print(l.val);
			l = l.next;
			if (l != null)
				System.out.print(" -> ");
		}
		System.out.println();
	}
}