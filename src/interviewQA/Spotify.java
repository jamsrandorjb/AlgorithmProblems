package interviewQA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Spotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subtractCharFromParagraph(
				"If you want to jumpstart the process of talking to us about this role, here’s a little challenge: write a program that outputs the largest unique set of characters that can be removed from this paragraph without letting its length drop below 50."));
	}

	public static List<Character> subtractCharFromParagraph(String paragraph) {
		List<Character> result = new ArrayList<>();
		int length = paragraph.length();
		if (length < 50)
			return result;

		HashMap<Character, Integer> hMap = new HashMap<>();
		for (char c : paragraph.toCharArray())
			hMap.put(c, hMap.getOrDefault(c, 0) + 1);

		List<Character> uniqChars = new ArrayList<>();
		for (char c : hMap.keySet())
			uniqChars.add(c);

		Collections.sort(uniqChars, (Character c1, Character c2) -> hMap.get(c1) - hMap.get(c2));

		while (length >= 50 && !uniqChars.isEmpty()) {
			char c = uniqChars.remove(0);
			int cnt = hMap.get(c);
			length -= cnt;
			if (length >= 50)
				result.add(c);
		}

		return result;
	}
}
