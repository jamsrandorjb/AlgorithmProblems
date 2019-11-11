package leetcode;

/*
* 36. Valid Sudoku
* problem url: https://leetcode.com/problems/valid-sudoku/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ValidSudoku {

	public static void main(String[] args) {
		char[][] sudoku = new char[][] {
			{'5', '3', '.',     '.', '7', '.', 		'.', '.', '.'},
			{'6', '.', '.',     '1', '9', '5', 		'.', '.', '.'},
			{'.', '9', '8',     '.', '.', '.', 		'.', '6', '.'},
			
			{'8', '.', '.',     '.', '6', '.', 		'.', '.', '3'},
			{'4', '.', '.',     '8', '.', '3', 		'.', '.', '1'},
			{'7', '.', '.',     '.', '2', '.', 		'.', '.', '6'},
			
			{'.', '6', '.',     '.', '.', '.', 		'2', '8', '.'},
			{'.', '.', '.',     '4', '1', '9', 		'.', '.', '5'},
			{'.', '.', '.',     '.', '8', '.', 		'.', '7', '9'}
			};
		System.out.println(isValidSudoku(sudoku));
		
	}
	
	public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.' && !checkSudoku(board, i, j)){
                    return false;
                }
            }
        }
        
        return true;
    }
    private static boolean checkSudoku(char[][] sudoku, int i, int j){
        char placement = sudoku[i][j];
        //getting row and column possibilites
        for(int k = 0; k < 9; k++){
            if(sudoku[i][k] == placement && k != j){
            	return false;    
            }
            if(sudoku[k][j] == placement && k != i){
            	return false;    
            }
        }
        
        int region = 3;
        int blockRow = i / region * region;
        int blockCol = j / region * region;
        
        for(int k = 0; k < region; k++)
        {
            for(int l = 0; l < region; l++)
            {
                int tempI = k+ blockRow;
                int tempJ = l+blockCol;
                if(tempI == i &&  tempJ == j) continue;
                if(sudoku[tempI][tempJ] == placement)
                {
                    return false;
                }
            }
        }
     
        return true;
    }
}
