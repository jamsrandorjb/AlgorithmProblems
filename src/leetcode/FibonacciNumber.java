package leetcode;

/*
* Fibonacci Number
* problem url: https://leetcode.com/problems/fibonacci-number/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class FibonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(30));
	}
	
	public static int fib(int N) {
		//checking the base conditions where we don't have to calculate at all
        if(N < 2) {
        	return N;
        } 
        
        //declaring few variables to track the previous Fibonacci numbers and temp var
        int fib1 = 0;
        int fib2 = 1;
        int temp = 0;
        
        for(int i = 2; i <= N; i++){     
            //calculcating next Fibonacci numbers
            temp = fib1;
            fib1 = fib2; 
            fib2 = temp + fib1;
        }
        
        //we got our fib here
        return fib2;
    }
}
