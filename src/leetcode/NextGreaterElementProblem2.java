package leetcode;

/*
* 503. Next Greater Element II 
* problem url: https://leetcode.com/problems/next-greater-element-ii/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class NextGreaterElementProblem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i : nextGreaterElements(new int[] {5,4,3,2,1}))
			System.out.println(i);
	}
	
	public static int[] nextGreaterElements(int[] nums) {
        int[] result = nums.clone();
        
        for(int i = 0; i < nums.length; i++){
            boolean isChanged = false;
            for(int j = i+1; j < nums.length; j++ ){
                if(nums[j] > nums[i]){
                    result[i] = nums[j];
                    isChanged = true;
                    break;
                }
            }
            if(!isChanged) {
                for(int k = 0;  k < i; k++ ){
                    if(nums[k] > nums[i]){
                    	result[i] = nums[k];
                        isChanged = true;
                        break;
                    }
                }
            }
            if(!isChanged) {
            	result[i] = -1;     
            }
        }
        
        return result;
    }
}