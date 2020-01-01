package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
* 961. N-Repeated Element in Size 2N Array
* problem url: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/

public class RepeatedNTimes {
	public static void main(String[] args) {
		System.out.println(repeatedNTimes(new int[] {1, 1, 2, 2, 3, 1}));
	}
	
	public static int repeatedNTimes(int[] A) {
        int n = A.length/2;   
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        for(int i : A){
            hMap.put(i, hMap.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> m : hMap.entrySet()) {
            if(m.getValue() == n){
                return m.getKey();
            }
        }
        
        return 0;
    }
}
