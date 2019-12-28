package leetcode.linkedList;

/*
* Merge Two Sorted Lists
* problem url: https://leetcode.com/problems/merge-two-sorted-lists/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MergeSortedLists {
	public static void main(String[] args) {
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(4);
		ListNode newnode2 = new ListNode(1);
		newnode2.next = new ListNode(3);
		newnode2.next.next = new ListNode(4);
		ListNode l = mergeTwoLists(newnode1, newnode2);
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode returnNode = null;
        ListNode temp = null;
        
        while(l1 != null && l2 != null){
            temp = returnNode;
            if(l1.val > l2.val){
                returnNode = l2;
                l2 = l2.next;
            }
            else
            {
                returnNode = l1;
                l1 = l1.next;
            }
            returnNode.next = temp;
        }
        
        while(l1 != null){
            temp = returnNode;
            returnNode = l1;
            l1 = l1.next;
            returnNode.next = temp;
            
        }
        
        while(l2 != null){
            temp = returnNode;
            returnNode = l2;
            l2 = l2.next;
            returnNode.next = temp;
        }
        
        return reverse(returnNode);
    }
	
	public static ListNode reverse(ListNode node) 
    { 
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
}