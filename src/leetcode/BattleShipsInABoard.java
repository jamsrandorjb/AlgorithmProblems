package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* 419. Battleships in a Board
* problem url: https://leetcode.com/problems/battleships-in-a-board/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class BattleShipsInABoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countBattleships(
				new char[][] { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } }));
	}

	public static int countBattleships(char[][] board) {
		if (board == null || board.length == 0) {
			return 0;
		}

		int ships = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == 'X' && (r == 0 || board[r - 1][c] != 'X') && (c == 0 || board[r][c - 1] != 'X'))
					ships++;
			}
		}

		return ships;
	}

	public static int countBattleships1(char[][] board) {
		HashMap<String, Integer> hMap = new HashMap<>();
		int ships = 0;
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column] == 'X') {
					String s = "r" + row;
					String s1 = "c" + column;
					hMap.put(s, hMap.getOrDefault(s, 0) + 1);
					hMap.put(s1, hMap.getOrDefault(s1, 0) + 1);
				}
			}
		}

		for (Map.Entry<String, Integer> entry : hMap.entrySet()) {
			if (entry.getKey().charAt(0) == 'c' && entry.getValue() == board.length)
				ships++;
			if (entry.getKey().charAt(0) == 'r' && entry.getValue() == board[0].length)
				ships++;
		}

		return ships;
	}
}