package datastrucutresAndAlgorithms.ey.training.week7.day31;

import org.junit.Test;

/*
 * fact of 6
 * 
 * 6*5*4*3*2*1 =>
 *  6 *5!
 * 		5 * 4! ... 1* 0!(1)
 * 
 * 0! = 1
 * 
 * 
 * 
 */
public class Factorial {
	
	
	@Test
	public void test() {
		System.out.println(bruteforce(5));
		System.out.println(fact(5));
//		System.out.println(bruteforce(6));
//		System.out.println(bruteforce(7));
	}
	
	
	
	/*
	 * Recursion - > method calling itself
	 * 
	 * 
	 * Memory =>
	 * 
	 *  5 * fact(4)
	 *  4 * fact(3)
	 *  3 * fact(2)
	 *  2 * fact(1)
	 *  1 * fact(0)
	 * 
	 *  5 * fact(4)
	 *  4 * fact(3)
	 *  3 * fact(2)
	 *  2 * 1 
	 *  1 * 1 => removed
	 *  
	 *  5 * fact(4)
	 *  4 * fact(3)
	 *  3 * 2
	 *  2 * 1 => removed
	 *  1 * 1 => removed
	 *  
	 *  5 * fact(4)
	 *  4 * 6
	 *  3 * 2 => removed
	 *  2 * 1 => removed
	 *  1 * 1 => removed
	 *  
	 *  5 * fact(4)
	 *  4 * 6 => removed
	 *  3 * 2 => removed
	 *  2 * 1 => removed
	 *  1 * 1 => removed
	 *  
	 *  5 * 24 
	 *  4 * 6 => removed
	 *  3 * 2 => removed
	 *  2 * 1 => removed
	 *  1 * 1 => removed
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	private int fact(int n) {
		if(n==0) return 1;
		return n*fact(n-1);
	}
	
	
	private int bruteforce(int n) {
		int output = 1;
		
		
		for(int i =1; i <= n; i++) {
			output *= i;
		}
		
		return output;
	}

}
