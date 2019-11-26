package leetcode.backtracking;

/*
* 37. Sudoku Solver
* problem url: https://leetcode.com/problems/sudoku-solver/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SolveSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		printSudoku(sudoku);
		
		
		
		solveSudoku(sudoku);
		
		
		
		
		
		printSudoku(sudoku);
	}
    
    public static void solveSudoku(char[][] sudoku) {
       fillSudoku(sudoku, 0, 0);
    }
    
    private static boolean fillSudoku(char[][] sudoku, int i, int j){
    	if(j == sudoku[i].length)
        {
            i++;
            j = 0;
            
            if(i == sudoku.length) return true;
        }
        
        if(sudoku[i][j] != '.') return fillSudoku(sudoku, i, j+1);
        
        
        for(int k = 1; k <= 9; k++){
        	char c = Integer.toString(k).charAt(0);
            if(checkSudoku(sudoku, i, j, c))
            {
               sudoku[i][j] = c;
               if(fillSudoku(sudoku, i, j+1)) return true;
               sudoku[i][j] = '.';
            }
        }
        
        return false;
    }
    
    private static boolean checkSudoku(char[][] sudoku, int i, int j, char placement){
        //getting row and column possibilites
        for(int k = 0; k < 9; k++){
            if(sudoku[i][k] == placement){
            	return false;    
            }
            if(sudoku[k][j] == placement){
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
                if(sudoku[k+ blockRow][l+blockCol] == placement)
                {
                    return false;
                }
            }
        }
     
        return true;
    }
    
    
    private static void printSudoku(char[][] sudoku) {
    	System.out.println("**************************************************");
		for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudoku[i][j] + " - " );
            }
            System.out.println();
        }
	}
}
