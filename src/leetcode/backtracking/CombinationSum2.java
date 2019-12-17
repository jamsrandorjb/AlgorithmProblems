package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 40. Combination Sum II 
 * problem url: https://leetcode.com/problems/combination-sum-ii/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class CombinationSum2 {
	public static void main(String[] args) {
		int[] intArray = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(combinationSum2(intArray, 8));

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);

		checkSubset(result, candidates, target, new ArrayList<Integer>(), 0);

		return result;
	}

	public static void checkSubset(List<List<Integer>> result, int[] candidates, int target, List<Integer> holder,
			int index) {
		// bingo this is our guy
		if (target == 0) {
			result.add(new ArrayList<>(holder));
			return;
		}

		// if target is less than zero we have to go to next loop
		// if the index is more than the length of input array we have to return
		if (target < 0 || index > candidates.length)
			return;

		for (int i = index; i < candidates.length; i++) {
			// new target for recursion
			if (i == index || candidates[i] != candidates[i - 1]) {
				// holder contain our solution
				holder.add(candidates[i]);

				checkSubset(result, candidates, target - candidates[i], holder, i + 1);

				// since we already checked on this element, we can remove it
				holder.remove(holder.size() - 1);

			}
		}
	}
}
