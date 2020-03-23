package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* 126. Word Ladder II
* problem url: https://leetcode.com/problems/word-ladder-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class WordLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<>();
		arr.add("hot");
		arr.add("dot");
		arr.add("dog");
		arr.add("lot");
		arr.add("log");
		arr.add("cog");
		for (List<String> results : findLadders("hit", "cog", arr))
			System.out.println(results);
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<List<String>> resultReal = new ArrayList<List<String>>();
		HashSet<String> hSet = new HashSet<>();
		for (String s : wordList)
			hSet.add(s);

		if (!hSet.contains(endWord))
			return result;

		int[] minPath = new int[1];
		minPath[0] = Integer.MAX_VALUE;
		dfs(beginWord, endWord, hSet, result, new HashSet<String>(), minPath);

		for (List<String> list : result) {
			if (list.size() == minPath[0])
				resultReal.add(list);
		}

		return resultReal;
	}

	private static void dfs(String beginWord, String endWord, HashSet<String> wordSet, List<List<String>> result,
			HashSet<String> tempResult, int[] minPath) {
		tempResult.add(beginWord);
		if (beginWord.equals(endWord)) {
			minPath[0] = minPath[0] > tempResult.size() ? tempResult.size() : minPath[0];
			result.add(new ArrayList<>(tempResult));
		} else {
			char[] arr = beginWord.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char c1 = arr[i];
				for (char c = 'a'; c <= 'z'; ++c) {
					if (beginWord.charAt(i) == c)
						continue;
					arr[i] = c;
					String mutatedWord = new String(arr);
					if (wordSet.contains(mutatedWord) && !tempResult.contains(mutatedWord)) {
						dfs(mutatedWord, endWord, wordSet, result, tempResult, minPath);
					}
					arr[i] = c1;
				}
			}
		}
		tempResult.remove(beginWord);
	}
}
