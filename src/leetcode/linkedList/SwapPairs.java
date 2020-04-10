package leetcode.linkedList;

/*
* 24. Swap Nodes in Pairs
* problem url: https://leetcode.com/problems/swap-nodes-in-pairs/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class SwapPairs {
	public static void main(String[] args) {
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(4);

		ListNode.printListNode(newnode1);
		ListNode.printListNode(swapPairs(newnode1));
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode current = temp;

		while (current.next != null && current.next.next != null) {
			ListNode firstNode = current.next;
			ListNode secondNode = current.next.next;

			// swapping the values
			firstNode.next = secondNode.next;
			current.next = secondNode;
			current.next.next = firstNode;

			// moving to the next swapping position
			current = current.next.next;
		}

		return temp.next;
	}
}