package leetcode.heap;

import java.util.Arrays;

/*
* 378. Kth Smallest Element in a Sorted Matrix
* problem url: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthSmallest(new int[][] {{-5}}, 1));
		System.out.println(kthSmallest(new int[][] {{1, 2}, {1, 3}}, 2));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (k > matrix.length * matrix[0].length) {
            return -1;
        }
        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++){
                arr[index] = matrix[i][j];
                index++;
            }
        Arrays.sort(arr);
        
        return arr[k-1];
    }
}
