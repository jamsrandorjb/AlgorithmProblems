package leetcode;

/*
* Range Sum Query Immutable
* problem url: https://leetcode.com/problems/range-sum-query-immutable/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class RangeSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArray na = new NumArray(new int[] {1,2,3,4,5});
		System.out.println(na.sumRange(1, 2));
		System.out.println(na.sumRange(0, 4));
	}
}

class NumArray {
    private int[] sumArray;

    public NumArray(int[] nums) {
        sumArray = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sumArray[i+1] = sumArray[i] + nums[i];     
        }
    }
    
    public int sumRange(int i, int j) {
        return sumArray[j+1] - sumArray[i];
    }
}
