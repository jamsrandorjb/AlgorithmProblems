package leetcode;

/*
* 1328. Break a Palindrome
* problem url: https://leetcode.com/problems/break-a-palindrome/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BreakAPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(breakPalindrome("abccba"));
	}

	public static String breakPalindrome(String palindrome) {
		int len = palindrome.length();
		if (len == 1)
			return "";
		StringBuilder sb = new StringBuilder(palindrome);

		for (int i = 0; i < len; i++) {
			int j = len - i - 1;
			if (i == j)
				continue;
			if (palindrome.charAt(i) != 'a') {
				sb.setCharAt(i, 'a');
				return sb.toString();
			}
		}

		sb.setCharAt(len - 1, 'b');
		return sb.toString();
	}
}
