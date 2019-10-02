package leetcode;

public class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }	
    
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
    
    public static void printListNode(ListNode l) {
		while(l != null){
            System.out.print(l.val);
            l = l.next;
            if(l != null) System.out.print(" -> ");
        }
		System.out.println();
	}
    
}
