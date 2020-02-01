package leetcode.greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * 1296. Divide Array in Sets of K Consecutive Numbers
 * problem url: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class DivideArrayInKSetsConsecutive {
	public static void main(String[] args) {
		System.out.println(isPossibleDivide(new int[] { 1, 2, 3, 3, 4, 4, 5, 6 }, 4));
		System.out.println(isPossibleDivide(new int[] { 1, 2, 3, 4 }, 3));
	}

	public static boolean isPossibleDivide(int[] nums, int k) {
		int len = nums.length;
		if (len % k != 0)
			return false;

		HashMap<Integer, Integer> hMap = new HashMap<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i : nums)
			hMap.put(i, hMap.getOrDefault(i, 0) + 1);
		for (int i : hMap.keySet())
			minHeap.offer(i);

		while (!minHeap.isEmpty()) {
			int cur = minHeap.poll();
			int times = hMap.get(cur);
			if (times == 0)
				continue;
			for (int i = 0; i < k; i++) {
				if (!hMap.containsKey(cur + i) || hMap.get(cur + i) < times)
					return false;
				hMap.put(cur + i, hMap.get(cur + i) - times);
			}
			len -= k * times;
		}

		return len == 0;
	}
}
