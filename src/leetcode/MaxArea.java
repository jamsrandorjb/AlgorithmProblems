package leetcode;

	
/**
* Container With Most Water
* problem url: https://leetcode.com/problems/container-with-most-water/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class MaxArea {

	public static void main(String[] args) {
		int[] intArray = new int[]{ 1,8,6,2,5,4,8,3,7 }; 
		System.out.println(maxArea(intArray));
	}
	
	
	/*
	 * @param - height[]
	 * return - maxArea int
	 */
	public static int maxArea(int[] height) {
        int return_val = 0;
        int j = height.length-1;
        int i=0;
        
        while(i < j)
        {
        	//choosing minimum height since water cannot be more than one side
        	int minHeight = Math.min(height[i], height[j]);
        	//calculating the area
        	return_val = Math.max(return_val, minHeight*(j-i));
        	
        	//we don't have to consider the short side
        	if(height[i]<height[j])
        		i++;
        	else
        		j--;
        }
        //during while loop this val already calculated
        return return_val;
    }
}
