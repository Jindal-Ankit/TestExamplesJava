package com.ankit.practice.problems;

import java.util.Arrays;

public class DynamicProgramming {

	public static void main(String[] args) {

		TimeTaken timeTaken = new TimeTaken();
		int n = 40;

		timeTaken.captureStartTime();
		System.out.println(fibMemorisation(n));
		timeTaken.calculateTimeTakeninSec(); 
		
		// recusive fib(40)
		timeTaken.captureStartTime();
		System.out.println(fib(n));
		timeTaken.calculateTimeTakeninSec();

		

	}

	// calculating nth fibonacci number
	
	/** Plain recursive fibaonacci implementation.
	 * In this implementation function is getting recalculating.
	 * Example: 
	 *            
		                         fib(5)
		                     /             \
		               fib(4)                fib(3)
		             /      \                /     \
		         fib(3)      fib(2)         fib(2)    fib(1)
		        /     \        /    \       /    \
		  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
		  /    \
		fib(1) fib(0)
		fib(3), fibe(2) etc is calculated multiple times, which increases the time complexity.
		
		We can improve this solution by calculating function once and reusing its value. Improvements will be shown in 
		after this method.
	 * @param n position in the fibaonacci series 
	 * @return nth number
	 * 
	 * f(0) = 0; f(1) = 1 , f(2) = 1, f(3) = f(2)+f(1) = 2
	 * f(0,1) = 0,1 respectively
	 * 
	 */
	private static long fib(int n) {
		if(n <= 1) return n;
		return fib(n-1) + fib(n-2);
	}
	
	
	/** This is improvement over plain recursive function. By keeping the computed results. 
	 * @param n
	 * @return
	 */
	private static long fibMemorisation(int n ){
		long[] cache  = new long[n+1];
		Arrays.fill(cache, -1);
		return fibDPMem(n, cache);
	} 
	private static long fibDPMem(int n, long[] cache ){
		if(cache[n] == -1) {
			if(n <=1) cache[n] = n;
			else {
				cache[n] = fibDPMem(n - 1 , cache) + fibDPMem(n - 2, cache);
			}
		}
		return cache[n];
	}
}
