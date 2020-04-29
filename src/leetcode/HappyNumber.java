package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* 202. Happy Number
* problem url: https://leetcode.com/problems/happy-number/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(7));
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();

		while (n != 1) {
			int sum = 0;
			int current = n;

			while (current != 0) {
				sum += Math.pow(current % 10, 2);
				current /= 10;
			}
			if (seen.contains(sum))
				return false;
			seen.add(sum);
			n = sum;
		}

		return true;
	}
}
