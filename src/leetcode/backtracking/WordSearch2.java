package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 212. Word Search II
* problem url: https://leetcode.com/problems/word-search-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class WordSearch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' } };
		System.out.println(findWords(board, new String[] { "eat", "oath", "rain" }));
		char[][] board1 = new char[][] { { 'a' }, { 'a' } };
		System.out.println(findWords(board1, new String[] { "a" }));
	}

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		for (String word : words) {
			outerloop: for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
						result.add(word);
						break outerloop;
					}
				}
			}
		}

		return result;
	}

	private static boolean dfs(char[][] board, int i, int j, int count, String word) {
		if (count == word.length())
			return true;
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count))
			return false;

		char c = board[i][j];
		board[i][j] = ' ';
		boolean found = dfs(board, i, j - 1, count + 1, word) || dfs(board, i, j + 1, count + 1, word)
				|| dfs(board, i - 1, j, count + 1, word) || dfs(board, i + 1, j, count + 1, word);
		board[i][j] = c;

		return found;
	}

}
