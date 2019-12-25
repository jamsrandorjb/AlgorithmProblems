package leetcode;

import java.util.List;
import java.util.LinkedList;

/*
 * 916. Word Subsets
 * problem url: https://leetcode.com/problems/subsets/
 * leetcode profile url: https://leetcode.com/jamsrandorj/ 
 * solved by jama
 */
public class WordSubsets {
	public static void main(String[] args) {
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "e", "o" }));
	}

	public static List<String> wordSubsets(String[] A, String[] B) {
		List<String> result = new LinkedList<>();
		int[] maxWordCnt = new int[26];

		for (String s : B) {
			int[] bCharCount = charCount(s);
			for (int i = 0; i < 26; i++) {
				maxWordCnt[i] = Math.max(maxWordCnt[i], bCharCount[i]);
			}
		}

		for (String s : A) {
			int[] aCharCount = charCount(s);
			boolean checkSubset = true;
			for (int i = 0; i < 26; i++) {
				if (aCharCount[i] < maxWordCnt[i]) {
					checkSubset = false;
					break;
				}
			}
			if (checkSubset)
				result.add(s);
		}

		return result;
	}

	private static int[] charCount(String word) {
		int[] arr = new int[26];
		for (int i = 0; i < word.length(); i++) {
			arr[word.charAt(i) - 'a']++;
		}

		return arr;
	}
}