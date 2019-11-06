package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* 51. N-Queens
* problem url: https://leetcode.com/problems/n-queens/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class NQueensPlacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(List<String> results: solveNQueens(4))
			System.out.println(results);
	}
	
	       
	public static List<List<String>> solveNQueens(int n) {
        List<List<Integer>> preResult = new ArrayList<List<Integer>>();
        solveNQueensRec(n, 0, new ArrayList<Integer>(), preResult);
        
        return buildResult(preResult, n);
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
    
    private static List<List<String>> buildResult(List<List<Integer>> res, int n){
        List<List<String>> result = new ArrayList<List<String>>();
        for(int k = 0; k < res.size(); k++){
        	List<String> resItem = new ArrayList<>();
        	StringBuilder sb = new StringBuilder();
            for (int i : res.get(k)) { 
                sb = new StringBuilder();
            	for (int j = 0; j < i; j++) sb.append(".");
            	sb.append("Q");
            	for (int j = i + 1; j < n; j++) sb.append(".");
            	resItem.add(sb.toString());
            }
            result.add(resItem);
        }
        
        return result;
    }          
}
