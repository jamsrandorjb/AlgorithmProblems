package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 22. Generate Parentheses
* problem url: https://leetcode.com/problems/generate-parentheses/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class BuildNParenthesis {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		buildParenthesis(result, n, n, "");

		return result;
	}

	private static void buildParenthesis(List<String> result, int left, int right, String built) {
		if (left == 0 && right == 0) {
			result.add(built);
			return;
		}
		if (left > 0)
			buildParenthesis(result, left - 1, right, built + "(");
		if (right > left)
			buildParenthesis(result, left, right - 1, built + ")");
	}
}
