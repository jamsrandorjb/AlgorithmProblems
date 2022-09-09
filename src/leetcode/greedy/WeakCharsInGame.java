package leetcode.greedy;

import java.util.Arrays;

/*
 * 1996. The Number of Weak Characters in the Game
 * problem url: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 * leetcode profile url: https://leetcode.com/jamsrandorj/
 * solved by jama
 */
public class WeakCharsInGame {
	public static void main(String[] args) {
		System.out.println(numberOfWeakCharacters(new int[][] { {100, 100}, {100, 100}, {100, 100}, {100, 100} }));
	}

	public static int numberOfWeakCharacters(int[][] p) {
        int result = 0;    
        int len = p.length;
        // b[1], a[1] because we need the 2nd values in descending order
        Arrays.sort(p, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int max = p[len-1][1];
       
        for(int i = len-2; i>=0 ;i--)
        {
            if(p[i][1] < max)
            {
                result++;
            }
            else
            {
                max = p[i][1];
            }
        }
        
        return result;
    }
}
