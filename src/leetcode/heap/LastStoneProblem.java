package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
* 1046. Last Stone Weight
* problem url: https://leetcode.com/problems/last-stone-weight/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class LastStoneProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
	}
	
	public static int lastStoneWeight(int[] stones) {
		//initializing max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());     
        //building max heap
        for(int i : stones) maxHeap.add(i);
        
        while(maxHeap.size() > 1){
        	//checking the difference of the max 2 elements
            int diff = maxHeap.poll() - maxHeap.poll();
            //if not equal adding the diff to the maxHeap
            if(diff != 0) maxHeap.add(diff);
        }
        
        //if the heap is empty we have to return 0
        if(maxHeap.isEmpty()) return 0;
        
        //last stone in the heap
        return maxHeap.poll();
    }
}
