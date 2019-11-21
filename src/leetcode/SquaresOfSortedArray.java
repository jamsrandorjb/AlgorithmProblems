package leetcode;

import java.util.Arrays;

/*
* Sorted Squares of an Array
* problem url: https://leetcode.com/problems/squares-of-a-sorted-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class SquaresOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int x : sortedSquares(new int[] {1,2,3,4,5,6})) {
			System.out.println(x);
		}
	}
	
	public static int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];    
        }
        //merge or quick sort based on the length of the Array
        Arrays.sort(A);
        
        return A;
    }
}
