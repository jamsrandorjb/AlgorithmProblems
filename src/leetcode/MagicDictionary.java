package leetcode;

import java.util.HashSet;

/*
* 676. Implement Magic Dictionary
* problem url: https://leetcode.com/problems/implement-magic-dictionary/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class MagicDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicDictionary md = new MagicDictionary();
		md.buildDict(new String[] { "hello", "leetcode" });
		System.out.println(md.search("hello"));
		System.out.println(md.search("hhllo"));
		System.out.println(md.search("hell"));
		System.out.println(md.search("leetcoded"));
	}

	HashSet<String> hSet;

	/** Initialize your data structure here. */
	public MagicDictionary() {
		hSet = new HashSet<>();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String s : dict)
			hSet.add(s);
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	public boolean search(String word) {
		int len = word.length();
		for (String s : hSet) {
			if (len != s.length())
				continue;
			int diffs = 0;
			for (int i = 0; i < len; i++) {
				if (diffs > 1)
					break;
				if (s.charAt(i) != word.charAt(i))
					diffs++;
			}

			if (diffs == 1)
				return true;
		}

		return false;
	}
}
