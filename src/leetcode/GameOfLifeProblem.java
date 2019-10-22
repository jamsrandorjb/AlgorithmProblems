package leetcode;

/*
* 289. Game of Life
* problem url: https://leetcode.com/problems/game-of-life/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class GameOfLifeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { {0,1,0},
				  		  {0,0,1},
				  		  {1,1,1},	
				  		  {0,0,0}
                		};
		
		System.out.println(board);
		gameOfLife(board);
		System.out.println(board);
	}
			
	public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int neighbors = getNeighbors(board, i, j);
                if (neighbors < 2 || neighbors > 3) board[i][j] *= -1;
                else if (neighbors == 3) board[i][j] = board[i][j] == 1 ? 1 : -2; 
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == -2) board[i][j] = 1;
            }
        }
        
    }
    
    private static int getNeighbors(int[][] board, int i, int j){
        int count = 0;
        
        count += getNeighborsHelper(board, i-1, j-1);
        count += getNeighborsHelper(board, i-1, j);
        count += getNeighborsHelper(board, i-1, j+1);
        
        count += getNeighborsHelper(board, i, j-1);
        count += getNeighborsHelper(board, i, j+1);
        
        count += getNeighborsHelper(board, i+1, j-1);
        count += getNeighborsHelper(board, i+1, j);
        count += getNeighborsHelper(board, i+1, j+1);
        
        return count;
    }
    
    private static int getNeighborsHelper(int[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return 0;
        }
        
        return Math.abs(board[i][j]) == 1 ? 1 : 0;
    }
}
