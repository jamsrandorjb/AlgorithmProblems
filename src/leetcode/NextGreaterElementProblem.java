package leetcode;

import java.util.HashMap;

/*
* 503. Next Greater Element I
* problem url: https://leetcode.com/problems/next-greater-element-i/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class NextGreaterElementProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i : nextGreaterElement(new int[] {1,5,3,4}, new int[] {7,1,5,3,6,4}))
			System.out.println(i);
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();    
        
        for(int i = 0; i < nums2.length; i++) hMap.put(nums2[i], i);
        
        for(int i = 0; i < nums1.length; i++){
            int j = hMap.get(nums1[i]);
            boolean isChanged = false;
            for(; j < nums2.length; j++ ){
                if(nums2[j] > nums1[i]){
                    nums1[i] = nums2[j];
                    isChanged = true;
                    break;
                }
            }
            if(!isChanged) nums1[i] = -1;
        }
        
        return nums1;
    }
}