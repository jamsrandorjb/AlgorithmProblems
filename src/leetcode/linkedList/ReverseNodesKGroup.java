package leetcode.linkedList;

/*
* 25. Reverse Nodes in k-Group
* problem url: https://leetcode.com/problems/reverse-nodes-in-k-group/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class ReverseNodesKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(3);
		newnode1.next.next.next = new ListNode(4);
		newnode1.next.next.next.next = new ListNode(5);
		ListNode.printListNode(newnode1);
		ListNode.printListNode(reverseKGroup(newnode1, 2));
		// ListNode.printListNode(reverseKGroup(newnode1, 3));
		// ListNode.printListNode(reverseKGroup(newnode1, 4));
		// ListNode.printListNode(reverseKGroup(newnode1, 5));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		// checking the edge case
		if (k == 0)
			return head;

		// checking the edge case
		int allNodeCount = 0;
		ListNode curr = head;
		while (curr != null && allNodeCount < k) {
			curr = curr.next;
			allNodeCount++;
		}
		if (allNodeCount < k)
			return head;

		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		int counter = 0;

		// reversing the k element of the linkedlist
		while (current != null && counter < k) {
			next = current.next;// save next
			current.next = prev;// reverse

			prev = current;// advance
			current = next; // advance
			counter++;
		}

		// if anything left, we will reverse it again
		if (next != null) {
			head.next = reverseKGroup(next, k);
		}

		return prev;
	}
}
