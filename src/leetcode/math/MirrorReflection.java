package leetcode.math;

/*
* 858. Mirror Reflection
* problem url: https://leetcode.com/problems/mirror-reflection/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/

public class MirrorReflection {
	public static void main(String[] args) {
		System.out.println(mirrorReflection(3,1));
		System.out.println(mirrorReflection(10,7));
	}

	public static int mirrorReflection(int p, int q) {
        int totalLen = p*q / gcd(p,q);
        int boxes = totalLen / p;
        
        if(boxes % 2 == 0)
            return 0;
        if((totalLen / q) %2 == 0)
            return 2;
        
        return 1;
    }
    
    private static int gcd(int a, int b) { 
		return b == 0 ? a : gcd(b, a%b); 
	}
}