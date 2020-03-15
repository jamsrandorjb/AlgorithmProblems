package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* 345. Reverse Vowels of a String
* problem url: https://leetcode.com/problems/reverse-vowels-of-a-string/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ReverseVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels("leetcode"));
		System.out.println(reverseVowels("jamsrandorj"));
	}

	public static String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('A');
		vowels.add('a');
		vowels.add('E');
		vowels.add('e');
		vowels.add('O');
		vowels.add('o');
		vowels.add('U');
		vowels.add('u');
		vowels.add('I');
		vowels.add('i');

		int i = 0;
		int j = s.length() - 1;
		char[] arr = s.toCharArray();

		while (i < j) {
			while (i < j && !vowels.contains(arr[i])) {
				i++;
			}
			while (i < j && !vowels.contains(arr[j])) {
				j--;
			}

			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		return new String(arr);
	}
}
