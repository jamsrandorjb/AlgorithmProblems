package leetcode.heap;

import java.util.PriorityQueue;

/*
* 703. Kth Largest Element in a Stream
* problem url: https://leetcode.com/problems/kth-largest-element-in-a-stream/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargest kth = new KthLargest(3, new int[] {4, 5, 8, 2});
		System.out.println(kth.add(3));   // returns 4
		System.out.println(kth.add(5));   // returns 5
		System.out.println(kth.add(10));  // returns 5
		System.out.println(kth.add(9));   // returns 8
		System.out.println(kth.add(4));   // returns 8
	}
	
	int size;
    PriorityQueue<Integer> minHeap;
    
    public KthLargest(int k, int[] nums) {
        this.size = k;
        minHeap = new PriorityQueue<Integer>();
        
        for(int i : nums) add(i);   
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        if(minHeap.size() > this.size) minHeap.poll();
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
