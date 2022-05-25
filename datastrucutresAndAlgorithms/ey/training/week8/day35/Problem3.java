package datastrucutresAndAlgorithms.ey.training.week8.day35;

import org.junit.Test;

public class Problem3 {
	@Test
	public void tets() {
		count(21,0);
		System.out.println(count);
	}
	
	/*
	 * int count(int n) { return count(n, 0); }
	 */
	
	
	/*
	 * n ->
	 * 
	 * 2 ^ k
	 * 
	 * min number of weights to equalise the n weight
	 * 
	 *  
	 *  32 -> 2^5 -> 1
	 *  30 -> 2^4 + 2^3 + 2^2 + 2^2 -> 4
	 *  
	 *  
	 *  32 -> break
	 *   16 -> 30-16=14, count++
	 *   	8 -> 14-8= 6, count++
	 *   		4 -> 6-4=2,count++
	 *   			2 -> 2-2 =0,count++
	 *   				 1 -> no action taken
	 *   
	 *   
	 *   n = 25
	 *   
	 *   32 -> break
	 *   	16 -> 25-16 = 9, count++
	 *   		8 -> 9-8=1, count++
	 *   			4 -> 1 <4 -> no action taken
	 *   				2 -> 1 < 2 -> no action taken
	 *   					1 -> 1-1=0, count++
	 *   
	 *   16+8+1 = 25
	 *   
	 * 
	 * 
	 * 
	 * 
	 */
	
	int count =0, num = 0;;
	private void count(int n, int k) {
		if(n < (int)Math.pow(2, k) ) {
			num = n;
			return;
		}
		
		count(n,k+1);
		
		if( num >= (int)Math.pow(2, k)) {
			num -= (int)Math.pow(2, k);
			count++;
		}
		
	}

}
