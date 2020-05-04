package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* 128. Longest Consecutive Sequence
* problem url: https://leetcode.com/problems/longest-consecutive-sequence/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestConsecutive(new int[] { 1, 5, 7, 8, 9, 2, 3, 4, 5, 6, 7, 100, 120 }));
	}

	public static int longestConsecutive(int[] nums) {
		int result = 0;
		Set<Integer> hSet = new HashSet<>();

		for (int i : nums)
			hSet.add(i);
		for (int i : nums) {
			if (hSet.contains(i - 1))
				continue;

			int curr = i;
			int tmpCnt = 1;

			while (hSet.contains(curr + tmpCnt)) {
				tmpCnt++;
			}

			result = result < tmpCnt ? tmpCnt : result;
		}

		return result;
	}
}
