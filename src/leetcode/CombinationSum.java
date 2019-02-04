package leetcode;

import java.util.ArrayList;

import java.util.List;


/**
* Roman to Integer
* problem url: https://leetcode.com/problems/combination-sum/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
*/
public class CombinationSum {
	public static void main(String[] args) {
		int[] intArray = new int[]{ 1,8,6,2,5,4,8,3,7 }; 
		System.out.println(combinationSum(intArray, 5));
		
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        checkSubset(result, candidates, target,  new ArrayList<Integer>(), 0);
        return result;
        
    }
	public static void checkSubset(List<List<Integer>> result, int[] candidates, int target, List<Integer> holder, int index)
    {
        //bingo this is our guy
        if(target==0) {
        	//creating new instance because we are using on memory list
        	result.add(new ArrayList<>(holder));
        	return;
        }
        
        //if target is less than zero we have to go to next loop
        //if the index is more than the length of input array we have to return
        if(target < 0 || index > candidates.length) return;
        
        
        for(int i=index; i< candidates.length; i++){
        	//new target for recursion
            int newTarget = target-candidates[i];
            //holder contain our solution
            holder.add(candidates[i]);
            //i will indicate next time from where we should start
            checkSubset(result, candidates, newTarget, holder, i);
            //since we already checked on this element, we can remove it
            holder.remove(holder.size()-1);
        }
    }
}


