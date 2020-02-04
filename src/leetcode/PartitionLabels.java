package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 763. Partition Labels
* problem url: https://leetcode.com/problems/partition-labels/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

	public static List<Integer> partitionLabels(String S) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < S.length(); i++)
			hMap.put(S.charAt(i), i);

		for (int i = 0; i < S.length(); i++) {
			int end = hMap.get(S.charAt(i));
			for (int j = i; j <= end; j++)
				end = Math.max(end, hMap.get(S.charAt(j)));

			result.add(end - i + 1);
			i = end;
		}

		return result;
	}
}
