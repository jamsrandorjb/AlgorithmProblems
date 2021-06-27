package leetcode.linkedList;

/*
* 430. Flatten a Multilevel Doubly Linked List
* problem url: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/



public class FlattenMultiLevelDoublyLinkedList {
	
	public static void main(String[] args) {
		NodeWithChild newnode1 = new NodeWithChild();
		newnode1.val = 1;
		NodeWithChild newnode2 = new NodeWithChild();
		newnode2.val = 2;
		NodeWithChild newnode3 = new NodeWithChild();
		newnode3.val = 3;
		NodeWithChild newnode4 = new NodeWithChild();
		newnode4.val = 4;
		
		newnode1.child = newnode4;
		newnode1.next = newnode2;
		newnode2.prev = newnode1;
		newnode2.next = newnode3;
		newnode3.prev = newnode2;
		
		NodeWithChild newnode = flatten(newnode1);
		while(newnode != null) {
			System.out.println(newnode.val);
			newnode = newnode.next;
		}
	}
	
	public static NodeWithChild flatten(NodeWithChild head) {
		if(head != null) flattenRec(head);
		
		return head;
    }
	
	private static NodeWithChild flattenRec(NodeWithChild head) {
		NodeWithChild curr = head;
		NodeWithChild tail = head;
		
		while(curr != null){
			if(curr.child == null) {
				curr = curr.next;
			}
			else {
				NodeWithChild child = curr.child;
				NodeWithChild next = curr.next;
				NodeWithChild tailOfChild = flattenRec(child);
				
				tailOfChild.next = next;
				
				curr.next = child;
				child.prev = curr;
				curr.child = null;
				
				if(next != null){
					next.prev = tailOfChild;
				}
			}
			
			if(curr != null) tail = curr;
		}
		
		return tail;
	}
}