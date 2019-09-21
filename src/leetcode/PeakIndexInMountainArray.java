package leetcode;

/*
* Peak Index in a Mountain Array
* problem url: https://leetcode.com/problems/peak-index-in-a-mountain-array/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(peakIndexInMountainArray(new int[] {0,1,0}));
	}
	
	public static int peakIndexInMountainArray(int[] A) {
        if(A.length < 3) return -1;
        for(int i = 1; i < A.length - 1; i++){
            if(A[i+1] < A[i]) return i;
        }
        
        return 1;
    }
}
