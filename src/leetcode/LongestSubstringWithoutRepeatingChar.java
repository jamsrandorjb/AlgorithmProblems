package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* 3. Longest Substring Without Repeating Characters
* problem url: https://leetcode.com/problems/longest-substring-without-repeating-characters/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class LongestSubstringWithoutRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lengthOfLongestSubstring("flower"));
		System.out.println(lengthOfLongestSubstringFast("flower"));

	}

	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		Set<Character> checkDup = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			checkDup.add(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) {
				if (checkDup.contains(s.charAt(j)))
					break;
				checkDup.add(s.charAt(j));
			}
			result = Math.max(result, checkDup.size());
			checkDup = new HashSet<>();
		}

		return result;
	}

	public static int lengthOfLongestSubstringFast(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;

		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
				continue;
			}
			set.remove(s.charAt(i++));
		}

		return ans;
	}
}
