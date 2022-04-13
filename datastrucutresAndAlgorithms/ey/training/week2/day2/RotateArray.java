package datastrucutresAndAlgorithms.ey.training.week2.day2;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray {

	
	/*
	 * 
	 * 1 2 3 4 5 6 7 8 9 ; 4 => 6 7 8 9 1 2 3 4 5
	 * 
	 * 6 7 8 9 |  1 2 3 4 5 
	 * 
	 * Step 1 reverse the array => 9 8 7 6 5 4 3 2 1 
	 * Step 2 reverse 0 to k-1 => 6 7 8 9 5 4 3 2 1
	 * Step 3 reverse k to EOA => 6 7 8 9 1 2 3 4 5
	 * 
	 */

	//6 7 8 9 1 2 3 4 5
	/*
	 *
	 * extra space
	 * 
	 * create a new array, then 2 loops place from length-k to length then from 0 to length-k-1
	 * 
	 */

	@Test
	public void td1() {
		System.out.println(Arrays.toString(rotateArray(new int[] {1,2,3,4,5,6,7,8,9}, 4)));
	}


	private int[] rotateArray(int[] input, int k) {
		k = k % input.length;
		if(k != 0) {
			swap(input, 0, input.length-1);
			swap(input, 0, k-1);
			swap(input, k, input.length-1);
		}
		return input;
	}

	private void swap(int[] input, int start, int end) {
		while(start < end) {
			int temp = input[start];
			input[start++] = input[end];
			input[end--] = temp;
		}
	}
}
