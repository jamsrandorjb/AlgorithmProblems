package leetcode;

import java.util.Random;

/*
* 73. Set Matrix Zeroes
* problem url: https://leetcode.com/problems/set-matrix-zeroes/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {0,1,0},
		  		  {0,0,1},
		  		  {1,1,1},	
		  		  {0,0,0}
	  	};
		
		System.out.println(matrix);
		setZeroes(matrix);
		System.out.println(matrix);
	}

	public static void setZeroes(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        Random random = new Random();
        int randomInteger = random.nextInt();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) setZero(board, i, j, randomInteger);  
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == Integer.MIN_VALUE + randomInteger) board[i][j] = 0;
            }
        }    
    }
    
    private static void setZero(int[][] board, int i, int j, int randomInteger){
        for(int k = 0; k < board[i].length; k++) 
            board[i][k] = board[i][k]!= 0 ? Integer.MIN_VALUE + randomInteger : board[i][k]; 
        for(int k = 0; k < board.length; k++) 
            board[k][j] = board[k][j]!= 0 ? Integer.MIN_VALUE + randomInteger : board[k][j]; 
    
    }
}
