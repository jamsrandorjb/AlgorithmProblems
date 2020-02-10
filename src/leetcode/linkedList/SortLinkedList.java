package leetcode.linkedList;

import java.util.PriorityQueue;

/*
* 148. Sort List
* problem url: https://leetcode.com/problems/sort-list/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class SortLinkedList {
	public static void main(String[] args) {
		ListNode newnode1 = new ListNode(2);
		newnode1.next = new ListNode(1);
		newnode1.next.next = new ListNode(4);
		newnode1.next.next.next = new ListNode(3);

		ListNode.printListNode(newnode1);
		ListNode.printListNode(sortList(newnode1));
	}

	public static ListNode sortList(ListNode head) {
        //begin sorting the LinkedList values
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		while (head != null) {
			heap.offer(head.val);
			head = head.next;
		}
        //end sorting the LinkedList values
        
        //building new LinkedList with sorted values
		while (!heap.isEmpty()) {
			ListNode newNode = new ListNode(heap.poll());
			if (head == null) {
				head = newNode;
				continue;
			}
			newNode.next = head;
			head = newNode;
		}
        //end building new LinkedList with sorted values

        //we have to reverse the result
		return reverse(head);
	}

	private static ListNode reverse(ListNode head) {
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