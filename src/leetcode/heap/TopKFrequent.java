package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
* 347. Top K Frequent Elements
* problem url: https://leetcode.com/problems/top-k-frequent-elements/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class TopKFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		for (int i : nums)
			hMap.put(i, hMap.getOrDefault(i, 0) + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Map.Entry<Integer, Integer> w1, Map.Entry<Integer, Integer> w2) {
						return -1 * (w1.getValue() - w2.getValue());
					}
				});

		for (Map.Entry<Integer, Integer> entry : hMap.entrySet())
			maxHeap.offer(entry);

		for (int i = 0; i < k; i++)
			result.add(maxHeap.poll().getKey());

		return result;
	}
}
