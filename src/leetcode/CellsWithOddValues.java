package leetcode;

/*
* 1252. Cells with Odd Values in a Matrix
* problem url: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class CellsWithOddValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oddCells(2, 3, new int[][] {{0,1},{1,1}}));
	}
	
	public static int oddCells(int n, int m, int[][] indices) {
        int[][] cells = new int[n][m];
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                cells[i][j] = 0; 
        }
        for(int[] indice: indices){
            for(int i = 0; i < m; i++){
                cells[indice[0]][i] = cells[indice[0]][i] + 1; 
            }
            for(int i = 0; i < n; i++){
                cells[i][indice[1]] = cells[i][indice[1]] + 1; 
            }
        }
        for(int[] cell : cells){
            for(int i : cell){
                if(i%2 != 0) result++;
            }
        }
        return result;
    }
}
