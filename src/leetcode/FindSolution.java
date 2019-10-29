package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 1237. Find Positive Integer Solution for a Given Equation
* problem url: https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
class CustomFunction {
	      // Returns f(x, y) for any given positive integers x and y.
	      // Note that f(x, y) is increasing with respect to both x and y.
	      // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
	      public static int f(int x, int y) {return x + y;}
}
public class FindSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSolution(new CustomFunction(), 10));
	}
	
	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 1; i <= 1000; i++){
        	int start = 1, end = 1000;
    		while (start <= end) {
    			int middle = start + (end - start) / 2;
    			if (customfunction.f(i, middle) == z) {
    				result.add(new ArrayList(Arrays.asList(i, middle)));
    				break;
    			}
    			else if (customfunction.f(i, middle) > z) {
    				end = middle - 1;
    			}
    			else {
    				start = middle + 1;
    			}
    		}
    		   
        }
        
        return result;
    }
}
