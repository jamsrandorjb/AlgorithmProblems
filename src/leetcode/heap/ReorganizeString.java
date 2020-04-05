package leetcode.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
* 767. Reorganize String
* problem url: https://leetcode.com/problems/reorganize-string/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class ReorganizeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));
	}

	public static String reorganizeString(String S) {
		char c1, c2;
		int cnt1, cnt2;

		StringBuilder sb = new StringBuilder();
		Character lastChar = Character.MIN_VALUE;
		HashMap<Character, Integer> map = new HashMap<>();
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((char1, char2) -> map.get(char2) - map.get(char1));

		for (char c : S.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		maxHeap.addAll(map.keySet());

		while (!maxHeap.isEmpty()) {
			c1 = Character.MIN_VALUE;
			c2 = Character.MIN_VALUE;

			if (!maxHeap.isEmpty()) {
				c1 = maxHeap.poll();
				if (lastChar == c1)
					return "";
				lastChar = c1;
				sb.append(c1);
			}

			if (!maxHeap.isEmpty()) {
				c2 = maxHeap.poll();
				if (lastChar == c2)
					return "";
				lastChar = c2;
				sb.append(c2);
			}

			cnt1 = map.getOrDefault(c1, 0);
			cnt2 = map.getOrDefault(c2, 0);

			if (cnt1 > 1) {
				map.put(c1, cnt1 - 1);
				maxHeap.offer(c1);
			}

			if (cnt2 > 1) {
				map.put(c2, cnt2 - 1);
				maxHeap.offer(c2);
			}
		}

		return sb.toString();
	}
}
