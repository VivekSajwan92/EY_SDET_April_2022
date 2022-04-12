package datastrucutresAndAlgorithms.ey.training.week2.day1;

import org.junit.Test;

public class TwoSum {
	
	/*
	 * 1 2 3 4 5 7
	 * 
	 * 5
	 * 
	 * 
	 */
	
	@Test
	public void td1() {
		int[] input = {1,2,3,4,4,5,7};
		int target = 5;
		twoSum(input, target);
	}
	
	/*
	 * 
	 * initializing right and left index
	 * find the sum,
	 * 	sum > target value decrement the right
	 * 	sum < target value increment the left
	 * 	sum == target value, print the index and 
	 * 			decrementing the right and increment the left
	 * 
	 */
	
	private void twoSum(int[] input, int target) {
		int right = input.length-1, left =0;
		
		while(right > left) {
			int sum = input[right] + input[left];
			if( sum == target) {
				System.out.println("{"+left+++","+right--+"}");
			}else if(sum > target) {
				right--;
			}else {
				left--;
			}
		}
		
	}
	

}
