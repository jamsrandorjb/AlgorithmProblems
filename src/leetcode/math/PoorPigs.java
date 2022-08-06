package leetcode.math;

/*
* 458. Poor Pigs
* problem url: https://leetcode.com/problems/poor-pigs/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class PoorPigs {
	public static void main(String[] args) {
		System.out.println(poorPigs(1000, 15, 60));
		System.out.println(poorPigs(1, 1, 1));
	}

	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int iterations = minutesToTest/minutesToDie + 1;
        double total = 1;
        int totalPigsNeeded = 0;
        while(total < buckets){
            total = Math.pow(iterations, totalPigsNeeded);
            totalPigsNeeded++;
        }
        
        return Math.max(0, totalPigsNeeded-1);
    }
}