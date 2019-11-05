package leetcode;

/*
* 999. Available Captures for Rook
* problem url: https://leetcode.com/problems/available-captures-for-rook/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AvailableCapturesForRook {
	
	public static void main(String[] args) {
		char[][] board = new char [][] {
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','p','.','.','.','.'},
			{'.','.','.','R','.','.','.','p'},
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','p','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'}
			};
			
		System.out.println(numRookCaptures(board));
	}
	
	public static int numRookCaptures(char[][] board) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'R'){
                    return findPossibleCaptures(board, i, j);
                }
            }
        }
        
        return -1;
    }
    
    private static int findPossibleCaptures(char[][] board, int i, int j){
        int result = 0;
        //bosoo
        for(int m = i; m > 0; m--){
            if(board[m][j] == 'p'){
                result++;
                break;
            }
            if(board[m][j] == 'B'){
                break;
            }
        }
        for(int m = i; m < 8; m++){
            if(board[m][j] == 'p'){
                result++;
                break;
            }
            if(board[m][j] == 'B'){
                break;
            }    
        }
        
        //hewtee
        for(int n = j; n > 0; n--){
            if(board[i][n] == 'p'){
                result++;
                break;
            }
            if(board[i][n] == 'B'){
                break;
            }
        }
        for(int n = j; n < 8; n++){
            if(board[i][n] == 'p'){
                result++;
                break;
            }
            if(board[i][n] == 'B'){
                break;
            } 
        }
        
        return result;
    }
}
