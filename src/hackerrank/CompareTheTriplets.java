package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/compare-the-triplets/problem
 * solved by jama
 */



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CompareTheTriplets {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
        int aliceScoer;
        int bobScoer;
        aliceScoer = 0;
        bobScoer = 0;
        if(a0 > b0)
        {
            aliceScoer ++;
        }
        if(a1 > b1)
        {
            aliceScoer ++;
        }
        if(a2 > b2)
        {
            aliceScoer ++;
        }
        if(a0 < b0)
        {
            bobScoer ++;
        }
        if(a1 < b1)
        {
            bobScoer ++;
        }
        if(a2 < b2)
        {
            bobScoer ++;
        }
        int[] A = {aliceScoer,bobScoer};
        return A;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        

    }
}
