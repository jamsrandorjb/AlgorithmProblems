package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
* 17. Letter Combinations of a Phone Number
* problem url: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class LetterCombinations {
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("247"));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> combinatinos = new LinkedList<>();
		if (digits == null || digits.length() == 0)
			return combinatinos;
		String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		bfs(combinatinos, map, digits, "", 0);
		return combinatinos;
	}

	private static void bfs(List<String> combinations, String[] map, String digits, String current, int index) {
		if (index == digits.length()) {
			combinations.add(current);
			return;
		}

		String letters = map[digits.charAt(index) - '0'];
		for (char c : letters.toCharArray()) {
			bfs(combinations, map, digits, current + c, index + 1);
		}
	}
}
