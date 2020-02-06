package leetcode.linkedList;

/*
* 19. Remove Nth Node From End of List
* problem url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(3);
		newnode1.next.next.next = new ListNode(4);
		newnode1.next.next.next.next = new ListNode(5);
		newnode1.next.next.next.next.next = new ListNode(6);
		newnode1.next.next.next.next.next.next = new ListNode(7);
		removeNthFromEnd(newnode1, 2);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode runner = head;
		ListNode returnNode = null;

		int size = 0;
		while (runner != null) {
			runner = runner.next;
			size++;
		}

		int index = 0;
		while (head != null) {
			runner = returnNode;
			if (index == size - n) {
				head = head.next;
				index++;
				continue;
			}
			returnNode = head;
			head = head.next;
			returnNode.next = runner;
			ListNode.printListNode(returnNode);
			index++;
		}

		return reverse(returnNode);
	}

	public static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode next = null;
		while (node != null) {
			next = node.next;
			node.next = prev;

			prev = node;
			node = next;
		}

		return prev;
	}
}
