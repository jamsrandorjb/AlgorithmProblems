package leetcode;

/*
* Fibonacci Number
* problem url: https://leetcode.com/problems/n-th-tribonacci-number/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class TribonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tribonacci(21));
	}
	
	public static int tribonacci(int N) {
        //checking the base conditions where we don't have to calculate at all
        if(N < 2) {
        	return N;
        } 
        
        //declaring few variables to track the previous Fibonacci numbers and temp var
        int fib0 = 0;
        int fib1 = 1;
        int fib2 = 1;
        int temp = 0;
        
        for(int i = 3; i <= N; i++){     
            //calculcating next Fibonacci numbers
            temp = fib0 + fib1 + fib2;
            fib0 = fib1;
            fib1 = fib2; 
            fib2 = temp;
        }
        
        //we got our fib here
        return fib2;
    }
}
