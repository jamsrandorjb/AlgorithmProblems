package leetcode;

import java.util.List;
import java.util.ArrayList;

/*
 * 78. Subsets
 * problem url: https://leetcode.com/problems/subsets/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class Subsets {
	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 3, 2 }));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets(0, new ArrayList<>(), nums, result);

		return result;
	}

	private static void generateSubsets(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));

		for (int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(i + 1, current, nums, result);
			current.remove(current.size() - 1);
		}
	}
}