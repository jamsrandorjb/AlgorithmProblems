package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
* 692. Top K Frequent Words
* problem url: https://leetcode.com/problems/top-k-frequent-words/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class TopKFrequentWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(topKFrequent(new String[] { "i", "love", "i", "codes", "solve", "k" }, 2));
	}

	public static List<String> topKFrequent(String[] words, int K) {
		List<String> result = new ArrayList<>();
		HashMap<String, Integer> hMap = new HashMap<>();
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) {
						if (w1.getValue() != w2.getValue())
							return w2.getValue() - w1.getValue();
						return w1.getKey().compareTo(w2.getKey());
					}
				});

		for (String s : words)
			hMap.put(s, hMap.getOrDefault(s, 0) + 1);
		for (Map.Entry<String, Integer> entry : hMap.entrySet())
			maxHeap.offer(entry);
		while (K > 0) {
			result.add(maxHeap.poll().getKey());
			K--;
		}

		return result;
	}
}
