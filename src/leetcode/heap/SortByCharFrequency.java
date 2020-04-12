package leetcode.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
* 451. Sort Characters By Frequency
* problem url: https://leetcode.com/problems/sort-characters-by-frequency/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SortByCharFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frequencySort("treekkkkkkkk"));
	}

	public static String frequencySort(String s) {
		// counting chars and saving it in the HashMap
		LinkedHashMap<Character, Integer> hMap = new LinkedHashMap<>();
		for (char c : s.toCharArray())
			hMap.put(c, hMap.getOrDefault(c, 0) + 1);

		// sorting the Hasmap based on the count
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return -1 * (o1.getValue()).compareTo(o2.getValue());
			}
		});
		hMap = new LinkedHashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> item : list)
			hMap.put(item.getKey(), item.getValue());

		// Building the return String
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> m : hMap.entrySet()) {
			for (int i = 0; i < m.getValue(); i++)
				sb.append(m.getKey());
		}

		return sb.toString();
	}
}
