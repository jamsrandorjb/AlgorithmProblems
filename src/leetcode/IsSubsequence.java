package leetcode;

/*
* Is Subsequence
* problem url: https://leetcode.com/problems/is-subsequence/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				isSubsequence("twn", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));
		System.out.println(isSubsequenceAnother("twn",
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));
	}

	public static boolean isSubsequence(String s, String t) {
		int matchedCount = 0;
		int pointerT = 0;

		while (matchedCount < s.length() && pointerT < t.length()) {
			if (s.charAt(matchedCount) != t.charAt(pointerT)) {
				pointerT++;
				continue;
			}
			matchedCount++;
			pointerT++;
		}

		return matchedCount == s.length();
	}

	public static boolean isSubsequenceAnother(String s, String t) {
		if (s.equals(""))
			return true;
		int index = 0;
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == s.charAt(index)) {
				index++;
			}
			if (index >= s.length())
				return true;
		}

		return false;
	}

}
