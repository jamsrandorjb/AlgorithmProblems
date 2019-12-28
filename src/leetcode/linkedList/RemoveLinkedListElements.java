package leetcode.linkedList;

/*
* Remove Elements from a LinkedList
* problem url: https://leetcode.com/problems/remove-linked-list-elements/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(4);
		ListNode l3 = removeElements(newnode1, 2);
		while(l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}	
	}
	
	public static ListNode removeElements(ListNode head, int val) {
        ListNode returnNode = null;
        ListNode runner = null;
        
        while(head != null){
            runner = returnNode;
            if(head.val == val){
                head = head.next;
                continue;
            }
            returnNode = head;
            head = head.next;
            returnNode.next = runner;
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
