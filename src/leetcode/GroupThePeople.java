package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 1282. Group the People Given the Group Size They Belong To
* problem url: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class GroupThePeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(groupThePeople(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		HashMap<Integer, List<Integer>> hMap = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> temp = hMap.getOrDefault(groupSizes[i], new ArrayList<Integer>());
			temp.add(i);
			hMap.put(groupSizes[i], temp);
		}

		for (Map.Entry<Integer, List<Integer>> entry : hMap.entrySet()) {
			List<Integer> people = entry.getValue();
			if (entry.getKey() < people.size()) {
				for (int i = 0; i < people.size() / entry.getKey(); i++) {
					result.add(people.subList(i * entry.getKey(), i * entry.getKey() + entry.getKey()));
				}
				continue;
			}
			result.add(people);
		}

		return result;
	}
}
