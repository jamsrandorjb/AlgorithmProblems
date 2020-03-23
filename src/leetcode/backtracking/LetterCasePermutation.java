package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 784. Letter Case Permutation
* problem url: https://leetcode.com/problems/letter-case-permutation/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String caseString : letterCasePermutation("a1b2"))
			System.out.println(caseString);
	}

	public static List<String> letterCasePermutation(String S) {
		List<String> casePemutations = new ArrayList<>();
		letterCasePermutationRecursice(casePemutations, S.toCharArray(), 0);
		return casePemutations;
	}

	public static void letterCasePermutationRecursice(List<String> casePemutations, char[] chars, int start) {
		casePemutations.add(new String(chars));
		for (int i = start; i < chars.length; i++) {
			if (!(chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z'))
				continue;
			switchLetterCase(chars, i);
			letterCasePermutationRecursice(casePemutations, chars, i + 1);
			switchLetterCase(chars, i);
		}
	}

	private static void switchLetterCase(char[] chars, int index) {
		char c = chars[index];
		if (c >= 'a' && c <= 'z')
			chars[index] -= 32;
		if (c >= 'A' && c <= 'Z')
			chars[index] += 32;
	}

}
