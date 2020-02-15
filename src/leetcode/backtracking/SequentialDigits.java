package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 1291. Sequential Digits
* problem url: https://leetcode.com/problems/sequential-digits/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SequentialDigits {

	public static void main(String[] args) {
		System.out.println(sequentialDigits(100, 300));
	}

	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			findSequence(res, low, high, i, i);
		}
		Collections.sort(res);

		return res;
	}

	private static void findSequence(List<Integer> res, int low, int high, int number, int pre) {
		if (low <= number && number <= high) {
			res.add(number);
		}
		if (number > high || pre == 9) {
			return;
		}
		findSequence(res, low, high, number * 10 + pre + 1, pre + 1);
	}
}
