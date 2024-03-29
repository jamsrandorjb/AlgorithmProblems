package leetcode.greedy;

import java.util.Arrays;

/*
 * 948. Bag of Tokens
 * problem url: https://leetcode.com/problems/bag-of-tokens/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class BagOfTokens {
	public static void main(String[] args) {
		System.out.println(bagOfTokensScore(new int[] { 100, 200, 300, 400 }, 200));
		System.out.println(bagOfTokensScore(new int[] { 100, 200 }, 150));
		System.out.println(bagOfTokensScore(new int[] { 100 }, 50));
	}

	public static int bagOfTokensScore(int[] tokens, int power) {
		int points = 0;
		int result = 0;
		int i = 0;
		int j = tokens.length - 1;

		Arrays.sort(tokens);

		while (i <= j) {
			if (power >= tokens[i]) {
				points++;
				power -= tokens[i];
				i++;
				result = Math.max(result, points);
				continue;
			}
			if (points == 0)
			{
				break;
			}
			points--;
			power += tokens[j];
			j--;
		}

		return result;
	}
}
