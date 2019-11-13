package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 52. N-Queens II
* problem url: https://leetcode.com/problems/n-queens-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class NQueensTotalCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(4));
	}
	
	       
	public static int totalNQueens(int n) {
        List<List<Integer>> preResult = new ArrayList<List<Integer>>();
        solveNQueensRec(n, 0, new ArrayList<Integer>(), preResult);
        
        return preResult.size();
    }
    
    private static void solveNQueensRec(int n, int row, List<Integer> placements, List<List<Integer>> res) {
        if(n == row){
            res.add(new ArrayList<>(placements));
            return;
        }
    	for(int col = 0; col < n; col++){
            placements.add(col);
            if(isValid(placements)){
                solveNQueensRec(n, row + 1, placements, res);
            }
            placements.remove(placements.size() - 1);
        }	
    }
    
    private static boolean isValid(List<Integer> placements) {
        int rowId = placements.size()-1;
        for(int i = 0; i < rowId; i++){
            int diff = Math.abs(placements.get(i) - placements.get(rowId));
            if(diff == 0 || diff == rowId - i){
                return false;
            }
        }
        
        return true;
    }            
}
