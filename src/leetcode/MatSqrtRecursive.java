package leetcode;

/*
* MatSqrt
* problem url: https://leetcode.com/problems/sqrtx/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
*/
public class MatSqrtRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(16));
	}
	
	       
	public static int mySqrt(int x) {
        if(x == 0) return 0;
        return mySqrtRecursive(x, 1, x/2);    
    }
    
    private static int mySqrtRecursive(int target, int lo, int hi){
        int mid = (hi - lo)/2 + lo;
        
        if(target/mid >= mid && target/(mid + 1) < (mid + 1)) return mid;
        
        if(target/mid > mid ) return mySqrtRecursive(target, mid + 1, hi);
        
        return mySqrtRecursive(target, lo, mid - 1);
    }      


}
