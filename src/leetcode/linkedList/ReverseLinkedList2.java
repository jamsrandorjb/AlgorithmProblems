package leetcode.linkedList;

/*
* 92. Reverse Linked List II
* problem url: https://leetcode.com/problems/reverse-linked-list-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class ReverseLinkedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(3);
		newnode1.next.next.next = new ListNode(4);
		newnode1.next.next.next.next = new ListNode(5);
		ListNode.printListNode(newnode1);
		ListNode.printListNode(reverseList(newnode1, 2, 4));
	}

	public static ListNode reverseList(ListNode head, int left, int right) {
		if(left == right)
		{
			return head;
		}
		
		ListNode dummy = new ListNode();
		dummy.next = head;
		
		ListNode prevNode = dummy;
		for(int i = 0; i < left - 1; i++)
		{
			prevNode = prevNode.next;
		}
		
		ListNode curNode = prevNode.next;
		for(int i = 0; i < right - left; i ++) 
		{
			ListNode nextNode = curNode.next;
			curNode.next = nextNode.next;
			nextNode.next = prevNode.next;
			prevNode.next = nextNode;
		}
		
		return dummy.next;
	}
}
