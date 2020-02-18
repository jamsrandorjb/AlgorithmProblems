package leetcode;

/*
* 896. Monotonic Array
* problem url: https://leetcode.com/problems/monotonic-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MonotonicArray {
	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] {1,2,2,3}));
		System.out.println(isMonotonic(new int[] {6,5,4,4}));
		System.out.println(isMonotonic(new int[] {1,3,2}));
		System.out.println(isMonotonic(new int[] {1,2,4,5}));
		System.out.println(isMonotonic(new int[] {1,1,1}));
		System.out.println(isMonotonic(new int[] {11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
		System.out.println(isMonotonic(new int[] {1,2,3,3,3}));
		
	}
	
	public static boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}