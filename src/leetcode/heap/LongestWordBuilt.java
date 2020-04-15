package leetcode.heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/*
* 720. Longest Word in Dictionary
* problem url: https://leetcode.com/problems/longest-word-in-dictionary/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class LongestWordBuilt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
	}

	public static String longestWord(String[] words) {
		HashSet<String> wordsSet = new HashSet<>();
		PriorityQueue<String> maxHeap = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() != s2.length())
					return s2.length() - s1.length();
				return s1.compareTo(s2);
			}
		});

		for (String s : words)
			wordsSet.add(s);

		for (String s : words) {
			if (s.length() == 1) {
				maxHeap.offer(s);
				continue;
			}

			for (int i = 1; i < s.length(); i++) {
				if (!wordsSet.contains(s.substring(0, i)))
					break;
				if (i == s.length() - 1)
					maxHeap.offer(s);
			}
		}

		return maxHeap.poll();
	}
}
