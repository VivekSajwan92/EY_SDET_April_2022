package datastrucutresAndAlgorithms.ey.training.week1.day2;

import org.junit.Test;

public class TimeComplexity {
	
	
	public void constantTimeComplexity() {
		
		//O[1]
		
		
		int a = 30, b = 67;
		
		//O[1] , O[1]  
		
		int sum = a/b;  // O[1]
		
		//20ms
		
		/**
		 * 
		 * O[1] + O[1] + O[1] + O[1]=> O[4] => O[C] ~ O[1]
		 * 
		 * 
		 */
		
		
		// Constant time complexity is O[1]
	}

	
	public void linearTimeComplexity() {
		
		int[] input = {1,2,3,4}; //o[1] 
		
		
		int sum = 0, loop =0 ;  //O[2]
		
		for(int eachElement: input) {
			sum +=eachElement; //O[1]
			loop++; //O[1]
			
		
		}
		
		System.out.println(loop);
		
		
		/**
		 * 
		 * O[1]
		 * 
		 * O[2]
		 * 
		 * 
		 *  7 * O[1]
		 * 
		 * 
		 *
		 * 
		 * O[1] * 7
		 * 
		 * 
		 * O[N]
		 * 
		 */
	}
	
	public void logTimeComplexity() {
		int a = 21, loop =0, loop1=0;
		
		while(a > 1) {
			a /= 2;
			loop++;
		}
		
		for(int b = 21 ; b >1 ;) {
			b /= 2;
			loop1++;
		}
		
		System.out.println(loop+" "+loop1);
		
		/*
		 * 
		 * log base 2
		 * 
		 * log2(32) => 5
		 * 
		 */
		
	}
	
	//quadratic time complexity - look for sorting
	
	@Test
	public void test() {
		logTimeComplexity();
	}
}
