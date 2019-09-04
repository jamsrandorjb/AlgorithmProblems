package leetcode;

import java.util.HashSet;

/*
*problem name: Jewels and Stones
*problem link: https://leetcode.com/problems/jewels-and-stones/
*/
public class JewelAndStones {
	
	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
	}
	
	
	public static int numJewelsInStones(String J, String S) {
        //declaring set to store the Jewels
        HashSet<Character> set = new HashSet<Character>();
        //declaring the counter to track the Jewels number 
        int result = 0;
        
        //setting Set from the Jewel
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        
        //checking the Jewel from the Stones and adding incrementing the counter
        for(int i = 0; i< S.length(); i++){
            if(set.contains(S.charAt(i))){
              result++;  
            } 
        }
        
        //O(n+m)
        return result;    
    }
}
