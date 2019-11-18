package leetcode;

import java.util.Arrays;

/*
* 455. Assign Cookies
* problem url: https://leetcode.com/problems/assign-cookies/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AssignCookies {

	public static void main(String[] args) {
	    System.out.println(findContentChildren(new int[] {1,2,3}, new int[] {1,1}));
	}

	public static int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int result = 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
              result++;
              i++;
              j++;
              continue;
            }
            j++;
        }
        
        return result;
    }
}
