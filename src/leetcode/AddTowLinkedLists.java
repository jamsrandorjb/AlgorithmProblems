package leetcode;

/*
* Add Two Linked Lists numbers
* problem url: https://leetcode.com/problems/add-two-numbers/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AddTowLinkedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
	    ListNode.printListNode(addTwoNumbers(l1, l2));
		
	}

	public static ListNode addTwoNumbers(ListNode r1, ListNode r2) {
        ListNode returnNode = null;
        int extra = 0;
        
        while(r1 != null && r2 != null){
            int num1 = r1.val;
            int num2 = r2.val;
            int sum = (num1 + num2 + extra) % 10;
            extra = (num1 + num2 + extra) / 10;
            
            ListNode temp = new ListNode(sum);
            temp.next = returnNode;
            returnNode = temp;
            
            r1 = r1.next;
            r2 = r2.next;
        }
        while(r1 != null){
            int num1 = r1.val;
            int sum = (num1 + extra) % 10;
            extra = (num1 + extra) / 10;
            
            ListNode temp = new ListNode(sum);
            temp.next = returnNode;
            returnNode = temp;
            
            r1 = r1.next;
        }
        while(r2 != null){
            int num2 = r2.val;
            int sum = (num2 + extra) % 10;
            extra = (num2 + extra) / 10;
            
            ListNode temp = new ListNode(sum);
            temp.next = returnNode;
            returnNode = temp;
            
            r2 = r2.next;
        }
        
        if(extra > 0){
            ListNode temp = new ListNode(extra);
            temp.next = returnNode;
            returnNode = temp;
        }
        
        return ListNode.reverse(returnNode);   
    }
}
