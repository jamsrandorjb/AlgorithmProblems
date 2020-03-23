package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* 1239. Maximum Length of a Concatenated String with Unique Characters
* problem url: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaxLength {

	public static void main(String[] args) {

		List<String> arr = new ArrayList<>();
		arr.add("cha");
		arr.add("r");
		arr.add("act");
		arr.add("ers");
		arr.add("a");
		arr.add("b");
		arr.add("c");
		arr.add("d");
		arr.add("e");
		arr.add("f");
		arr.add("g");
		arr.add("h");
		arr.add("i");
		arr.add("j");
		arr.add("k");
		arr.add("l");
		arr.add("m");
		arr.add("n");
		arr.add("o");
		arr.add("p");
		// ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"]
		System.out.println(maxLength(arr));
	}

	public static int maxLength(List<String> arr) {
		int result = 0;

		for (int i = 0; i < arr.size(); i++) {
			HashSet<Character> hSet = new HashSet<>();
			boolean noRepeat = true;

			for (char c : arr.get(i).toCharArray()) {
				if (hSet.contains(c)) {
					noRepeat = false;
					break;
				}
				hSet.add(c);
			}

			if (!noRepeat)
				continue;
			result = Math.max(result, hSet.size());

			for (int j = 0; j < arr.size(); j++) {
				noRepeat = true;
				if (i == j)
					continue;

				HashSet<Character> hSetInner = new HashSet<>();
				for (char c : arr.get(j).toCharArray()) {
					if (hSet.contains(c) || hSetInner.contains(c)) {
						noRepeat = false;
						break;
					}

					hSetInner.add(c);
				}

				if (noRepeat)
					hSet.addAll(hSetInner);

				result = Math.max(result, hSet.size());
			}
		}

		return result;
	}
}
