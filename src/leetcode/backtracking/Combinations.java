package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* 77. Combinations
* problem url: https://leetcode.com/problems/combinations/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4, 2));

	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		combineRec(n, k, 1, res, new ArrayList<Integer>());
		return res;
	}

	private static void combineRec(int n, int k, int start, List<List<Integer>> res, List<Integer> tempRes) {
		if (k == 0) {
			res.add(new ArrayList<>(tempRes));
		}
		for (int j = start; j <= n; j++) {
			tempRes.add(j);
			if (checkValidInput(tempRes, res)) {
				combineRec(n, k - 1, j + 1, res, tempRes);
			}
			tempRes.remove(tempRes.size() - 1);
		}

	}

	private static boolean checkValidInput(List<Integer> tempRes, List<List<Integer>> res) {
		HashSet<Integer> hSet = new HashSet<>();
		for (int item : tempRes) {
			if (hSet.contains(item))
				return false;
			hSet.add(item);
		}

		return true;
	}
}
