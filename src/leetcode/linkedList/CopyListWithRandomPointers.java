package leetcode.linkedList;

import java.util.HashMap;

/*
* 138. Copy List with Random Pointer
* problem url: https://leetcode.com/problems/copy-list-with-random-pointer/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class CopyListWithRandomPointers {
	public static void main(String[] args) {
		ListNode newnode1 = new ListNode(1);
		newnode1.next = new ListNode(2);
		newnode1.next.next = new ListNode(4);

		ListNode.printListNode(newnode1);
		ListNode.printListNode(copyRandomList(newnode1));
	}

	public static ListNode copyRandomList(ListNode head) {
        if(head == null) return null;
        
        ListNode cur = head;
        HashMap<ListNode, ListNode> hMap = new HashMap<>();
        
        //cloning a LinkedList
        while(cur != null){
        	ListNode newNode = new ListNode(cur.val);
            hMap.put(cur, newNode);
            cur = cur.next;
        }
        
        cur = head;
        //pointing the cloned new Next and Random
        while(cur != null){
        	ListNode clonedNode = hMap.get(cur);
            clonedNode.next = hMap.get(cur.next);
            clonedNode.random = hMap.get(cur.random);
            
            cur = cur.next;
        }
        
        
        return hMap.get(head);
    }
}