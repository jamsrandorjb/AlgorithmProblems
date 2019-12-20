package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/*
* 56. Merge Intervals
* problem url: https://leetcode.com/problems/merge-intervals/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] array = new int[4][];
		array[0] = new int[] {1, 3};
		array[1] = new int[] {2, 6};
		array[2] = new int[] {8, 10};
		array[3] = new int[] {15, 18};
		
		for(int[] item : merge(array))
			System.out.println(item[0]+" : "+item[1]);
	}
	
	public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<int[]>();
        
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);   
            }
            else
            {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }   
        }
        
        int[][] result = new int[merged.size()][];
        int i = 0;
        for(int[] interval : merged){
            result[i] = interval;
            i++;
        }
            
        return result;
    }
}