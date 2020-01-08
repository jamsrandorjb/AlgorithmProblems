package leetcode.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
* 621. Task Scheduler
* problem url: https://leetcode.com/problems/task-scheduler/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A','B','B','B' }, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(char task : tasks) {
			map.put(task, map.getOrDefault(task, 0) + 1);
		}
		heap.addAll(map.values());
		
		while(!heap.isEmpty()) {
			List<Integer> completedTasks = new LinkedList<Integer>();
			for(int i = 0; i <= n; i++) {
				if(!heap.isEmpty()) {
					completedTasks.add(heap.poll());
				}
			}
			
			for(int completedTask : completedTasks) {
				completedTask--;
				if(completedTask > 0) {
					heap.offer(completedTask);
				}
			}
			
			result += heap.isEmpty() ? completedTasks.size() : n + 1;
			
		}
		
		return result;
	}
}
