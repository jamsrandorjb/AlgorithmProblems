package leetcode.dfs;

/*
* 130. Surrounded Regions
* problem url: https://leetcode.com/problems/surrounded-regions/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
            	System.out.print(board[i][j]);
            }
            System.out.println();
        }
	}

	public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
        {
            return;
        }
        
        int columns = board[0].length;
        int rows = board.length;
        
        for(int i =0; i < rows; i++)
        {
            if(board[i][0] == 'O') runDFS(i, 0, board);
            if(board[i][columns-1] == 'O') runDFS(i, columns - 1, board);
        }
        
        for(int j = 0; j < columns; j++)
        {
            if(board[0][j] == 'O') runDFS(0, j, board);
            if(board[rows - 1][j] == 'O') runDFS(rows - 1, j, board);
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'J')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void runDFS(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O')
        {
            return;
        }
        
        if(board[i][j] == 'O')
        {
            board[i][j] = 'J';   
        }
        
        runDFS( i -1, j, board);
        runDFS( i + 1, j, board);
        runDFS( i, j - 1, board);
        runDFS( i, j + 1, board);
    }
}
