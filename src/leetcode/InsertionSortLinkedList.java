package leetcode;

/**
* Definition for singly-linked list.
* problem url: https://leetcode.com/problems/insertion-sort-list/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/

public class InsertionSortLinkedList {
	
	public static void main(String[] args) {
		ListNode lnode = new ListNode(4);
		lnode.next = new ListNode(2);
		lnode.next.next = new ListNode(1);
		lnode.next.next.next = new ListNode(3);
		
		insertionSortList(lnode);
		while(lnode != null) {
			System.out.println(lnode.val);
			lnode = lnode.next;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
      //checking edge case
  	if(head == null || head.next == null) return head;
      
      //start from head.next because insertion sort is 1...N
      ListNode startPoint = head.next;
      
      //start from beginning till startPoint
      ListNode checker = head;
      
      //big loop 1...N
      while(startPoint != null) {
          
          //setting check point in every loop
      	checker = head;
          
          //inner loop that will check and swap, starts from head till the node that we are checking
      	while(checker != startPoint) {
              //if value less then we will swap
      		if(startPoint.val < checker.val)
      		{
      			int temp = checker.val; 
      			checker.val = startPoint.val;
      			startPoint.val = temp;
      		}
      		checker = checker.next;	        		
      	}
      	startPoint = startPoint.next;
      }
      return head;
  }
}


