package leetcode;

/*
* Merge K Sorted Lists
* problem url: https://leetcode.com/problems/merge-k-sorted-lists/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(4);
		newnode1.next.next = new ListNode(5);
		ListNode newnode2 = new ListNode(1);
		newnode2.next = new ListNode(3);
		newnode2.next.next = new ListNode(4);
		ListNode newnode3 = new ListNode(2);
		newnode3.next = new ListNode(6);
		
		ListNode l3 = mergeKLists(new ListNode[] {newnode1, newnode2, newnode3});
		while(l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}	
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode result = null;
		for(int i = 0; i < lists.length; i++){
			result = mergeTwoLists(result, lists[i]); 
		}
		
		return result;
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