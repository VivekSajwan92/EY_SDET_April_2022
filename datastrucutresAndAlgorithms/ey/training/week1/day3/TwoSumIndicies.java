package datastrucutresAndAlgorithms.ey.training.week1.day3;

import org.junit.Test;

public class TwoSumIndicies {


	/*
	 * Given the input int array, find the sum of any two distinct indices of the matching 
	 * given the target 
	 * 
	 * 
	 * clarified - last indicies to be printed
	 * 
	 */

	@Test // +ve
	public void example1() {
		int[] nums = {2,7,11,15};
		int target = 9;
		twoSum_BruteForce(nums, target);
		// Output --> {0,1}
	}

	@Test // edge
	public void example2() {

		int[] nums = {2,2,3,1,4,0,5};
		int target = 5;
		twoSum_BruteForce(nums, target);
		//Output --> {5,6}

	}

	@Test // negative
	public void example3() {
		int[] nums = {2,2,3,1,4,0,5};
		int target = 45;
		twoSum_BruteForce(nums, target);

		//output => print saying no match
	}

	/* 
	 * Brute force !!
	 * Psuedo code here:
	 * 
	 * Time complexity - O[N^2] 
	 * 
	 *  initialize the String with "no match found"
	 * 1) Take the input array 
	 * 2) Traverse every element using for loop
	 * 3) Add with the next element with the outer loop
	 * 4) Compare the sum with the target
	 * 		a) If it matches, store them in a string !!
	 * 		b) If it does not match, continue
	 * 5) Finally, print the string !! 
	 * 
	 * Optimized solution with its respective time complexity
	 * 
	 */

	private void twoSum_BruteForce(int[] nums, int target) {
		
		
		
		String match = "No Match Found";
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target)
					match = "{"+i+","+j+"}";
			}
		}

		System.out.println(match);
	}
	
	
	
	
	
	/*
	 * 
	 * 
	 * Invalid data - 	{2,2,2,2,2,2} , target 4  // it will simplify the code by adding in set but that time and space complexity will get increased
	 * 					{} target 2   // as it wont go inside loop
	 * 
	 */

}
