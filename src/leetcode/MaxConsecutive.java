package leetcode;

/*
* 485. Max Consecutive Ones
* problem url: https://leetcode.com/problems/max-consecutive-ones/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class MaxConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxConsecutiveOnes(new int[] {1, 1, 1, 0, 0, 0, 0, 0, 1}));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsequence = 0;
        int consequence = 0;
        
        for(int i : nums){
            consequence = i == 1 ? consequence + 1 : 0;
            if(consequence > maxConsequence) maxConsequence = consequence;
        }
        
        return maxConsequence;
    }
}
