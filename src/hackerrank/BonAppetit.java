package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/bon-appetit/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BonAppetit {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] list = scanner.nextLine().split(" ");

        String[] last = scanner.nextLine().split(" ");

        int m = Integer.parseInt(last[0]);
        int sum =0;
        for(int i =0; i<list.length; i++){
            if(t!=i)
                sum+=Integer.parseInt(list[i]);     
        }
        System.out.println(m-sum/2 == 0 ? "Bon Appetit" :  m-sum/2);
        scanner.close();

    }
}