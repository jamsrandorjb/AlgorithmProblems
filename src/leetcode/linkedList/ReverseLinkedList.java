package leetcode.linkedList;

/*
* 206. Reverse Linked List
* problem url: https://leetcode.com/problems/reverse-linked-list/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(3);
		newnode1.next.next.next = new ListNode(4);
		newnode1.next.next.next.next = new ListNode(5);
		ListNode.printListNode(newnode1);
		ListNode.printListNode(reverseList(newnode1));
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;

			prev = head;
			head = next;
		}

		return prev;
	}
}
