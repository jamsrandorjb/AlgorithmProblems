package leetcode.easy;

import java.util.HashMap;
import java.util.ArrayList;

/*
* 1338. Reduce Array Size to The Half
* problem url: https://leetcode.com/problems/reduce-array-size-to-the-half/
* leetcode profile url: https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class ReduceArraySizeHalf {
	public static void main(String[] args) {
		System.out.println(minSetSize(new int[] {0,1,2,3,3,3,3,3,33}));
		System.out.println(minSetSize(new int[] {0,1,2,3,3,4444}));
	}

	public static int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int n = arr.length;
        for(int i = 0; i < list.size(); i++){
            n -= list.get(i);
            if(n * 2 <= arr.length)
                return i + 1;
        }
        
        return 0;
    }
}