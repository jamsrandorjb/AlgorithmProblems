package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
* 187. Repeated DNA Sequences
* problem url: https://leetcode.com/problems/repeated-dna-sequences/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FindDNASequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		int i = 0;
		List<String> result = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		while (i + 10 <= s.length()) {
			String sub = s.substring(i, i + 10);
			map.put(sub, map.getOrDefault(sub, 0) + 1);
			if (map.get(sub) == 2)
				result.add(sub);
			i++;
		}

		return result;
	}
}
