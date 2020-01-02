package leetcode;

/*
* 14. Longest Common Prefix
* problem url: https://leetcode.com/problems/longest-common-prefix/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestCommonPrefix(new String[] { "flower", "flight", "flash" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";

		int minLength = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();

		for (String s : strs)
			minLength = Math.min(s.length(), minLength);

		for (int i = 0; i < minLength; i++) {
			char c = strs[0].charAt(i);

			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) {
					return sb.toString();
				}
			}

			sb.append(c);
		}

		return sb.toString();
	}
}
