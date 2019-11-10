package leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

/*
* 996. Number of Squareful Arrays
* problem url: https://leetcode.com/problems/number-of-squareful-arrays/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class NumberOfSquareFul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquarefulPerms(new int[] {2,2,2}));
		System.out.println(numSquarefulPerms(new int[] {2,2,2,2,2,2,2,2,2}));
		System.out.println(numSquarefulPerms(new int[] {1,17,8}));
	}
	
	       
	public static int numSquarefulPerms(int[] A) {
        HashMap<Integer, Integer> alreadyChecked = new HashMap<>();
        dfs(A, 0, alreadyChecked);
        
        return alreadyChecked.size();
    }
    
    private static void dfs(int[] A, int startPoint, HashMap<Integer, Integer> alreadyChecked){
        
        for(int i = startPoint + 1; i < A.length; i++){
            if(check(A, startPoint, i, alreadyChecked)){
                alreadyChecked.put(startPoint, i);
            }
            dfs(A, startPoint +1, alreadyChecked);
        }
    }
    
    private static boolean check(int[] A, int startPoint, int endPoint, HashMap<Integer, Integer> alreadyChecked){
        if(startPoint == endPoint || endPoint >= A.length || alreadyChecked.containsKey(startPoint)) return false;
        for(Map.Entry<Integer, Integer> entry : alreadyChecked.entrySet()) {
        	if(A[entry.getValue()] ==  A[startPoint] && A[entry.getValue()] ==  A[endPoint])
        		return false;
        }
        double d = Math.sqrt(A[startPoint] + A[endPoint]);
        if(d - Math.floor(d) != 0) return false;
        
        return true;
    }          
}
