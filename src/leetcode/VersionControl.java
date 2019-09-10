package leetcode;

/*
* Check First Bad Version
* problem url: https://leetcode.com/problems/first-bad-version/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class VersionControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstBadVersion(1000));
	}
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */

	public static int firstBadVersion(int n) {
		//used binarySearch
		return firstBadVersionInner(0, n);
	}
	  
	private static int firstBadVersionInner(int first, int last){
		if (last>=first){  
			int mid = first + (last - first)/2;  
			if (isBadVersion(mid)){  
				return firstBadVersionInner(first, mid-1);//search in left
			}else{  
				return firstBadVersionInner(mid+1, last);//search in right 
			}  
		}
		//if the start and end point is equal we hit the jackpot
		return first;  
	}
	
	private static boolean isBadVersion(int n) {
		 //TODO this function should be implemented in the calling class.
		 return true;
	}
}
