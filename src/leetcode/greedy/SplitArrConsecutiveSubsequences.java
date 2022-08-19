package leetcode.greedy;

import java.util.HashMap;

/*
 * 659. Split Array into Consecutive Subsequences
 * problem url: https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class SplitArrConsecutiveSubsequences {
	public static void main(String[] args) {
		System.out.println(isPossible(new int[] { 100, 200, 300, 400 }));
		System.out.println(isPossible(new int[] { 1, 2, 3 }));
	}

	public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> oneSeq = new HashMap<>();
        Map<Integer, Integer> twoSeq = new HashMap<>();
        Map<Integer, Integer> threeSeq = new HashMap<>();
        for(int num : nums)
        {
            int preSeq = num - 1;
            
            if(oneSeq.containsKey(preSeq))
            {
                oneSeq.put(preSeq, oneSeq.get(preSeq) - 1);
                if(oneSeq.get(preSeq) == 0) oneSeq.remove(preSeq);
                twoSeq.put(num, twoSeq.getOrDefault(num, 0) + 1);
                continue;
            }
            
            if(twoSeq.containsKey(preSeq))
            {
                twoSeq.put(preSeq, twoSeq.get(preSeq) - 1);
                if(twoSeq.get(preSeq) == 0) twoSeq.remove(preSeq);
                threeSeq.put(num, threeSeq.getOrDefault(num, 0) + 1);
                continue;
            }
            
            if(threeSeq.containsKey(preSeq))
            {
                threeSeq.put(preSeq, threeSeq.get(preSeq) - 1);    
                if(threeSeq.get(preSeq) == 0) threeSeq.remove(preSeq);
                threeSeq.put(num, threeSeq.getOrDefault(num, 0) + 1);
                continue;
            }
            
            oneSeq.put(num, oneSeq.getOrDefault(num, 0) + 1);
        }
        
        if(!oneSeq.isEmpty() || !twoSeq.isEmpty())
            return false;
        
        return true;
    }
}
