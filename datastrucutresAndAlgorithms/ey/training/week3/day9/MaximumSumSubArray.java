package datastrucutresAndAlgorithms.ey.training.week3.day9;

import org.junit.Test;

public class MaximumSumSubArray {

	@Test
	public void td1() {
		System.out.println(bruteForce(new int[] {1,2,3,5,7,11}, 3));
		System.out.println(slidingWindow(new int[] {1,2,3,5,7,11}, 3));
	}

	@Test
	public void td2() {
		System.out.println(bruteForce(new int[] {-2, 0 ,0}, 3));
		System.out.println(slidingWindow(new int[] {-2, 0 ,0}, 3));
	}



	@Test
	public void td3() {
		System.out.println(bruteForce(new int[] {-2 ,-2, -2}, 3));
		System.out.println(slidingWindow(new int[] {-2 ,-2, -2}, 3));
	}

	private int bruteForce(int[] input, int k) {
		int sum = Integer.MIN_VALUE, currentSum =0;

		for(int i =0; i<= input.length-k; i++) {
			currentSum = input[i];
			for( int j =i+1; j < i+k; j++) {
				currentSum +=input[j];
			}
			
//			if(i==0) sum = currentSum;
			
			sum = Math.max(currentSum, sum);
		}

		return sum;
	}
	
	/*
	 * 1,2,3,5,7,11    3
	 * 
	 * 
	 * 1 , 2 -> first while loop
	 * 
	 * 3
	 * find the maxSum
	 * 
	 * 1 minus the pointer-k
	 * 
	 * 
	 * 
	 * 
	 *  1,2 -> csum 3
	 *  
	 *  csum + 3 -> 6
	 *  
	 *  sum 6 , csum 5
	 * 
	 *  
	 */
	
	
	private int slidingWindow(int[] input, int k) {
		int pointer =0, sum = Integer.MIN_VALUE, currentSum =0;
		
		/*
		 * k is the sub array length
		 * 
		 * loop 1 we are adding the subarr length - 1 elements
		 * loop 2 we are adding the last element of the subarray
		 * 		 and then finding the maximum sum so far
		 * 		 sub the first index value
		 */
		
		while(pointer < k-1)
			currentSum +=input[pointer++];
		
		while(pointer < input.length) {
			currentSum += input[pointer++];
			sum = Math.max(sum, currentSum);
			currentSum -= input[pointer-k];
		}
		
		return sum;
	}

}
