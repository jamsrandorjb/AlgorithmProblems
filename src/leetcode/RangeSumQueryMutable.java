package leetcode;

/*
* Range Sum Query Immutable
* problem url: https://leetcode.com/problems/range-sum-query-mutable/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RangeSumQueryMutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArrayMutable na = new NumArrayMutable(new int[] {1,2,3,4,5});
		System.out.println(na.sumRange(1, 2));
		System.out.println(na.sumRange(2, 3));
		System.out.println(na.sumRange(0, 4));
	}
}

class NumArrayMutable {
    private int[] numArray;
    
    public NumArrayMutable(int[] nums) {
        numArray = nums;    
    }
    
    public void update(int i, int val) {
        numArray[i] = val;    
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++){
        	sum += numArray[k];
        }
        
        return sum;
    }
}
