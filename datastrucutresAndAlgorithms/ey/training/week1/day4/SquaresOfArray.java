package datastrucutresAndAlgorithms.ey.training.week1.day4;

import java.util.Arrays;

import org.junit.Test;

public class SquaresOfArray {

	@Test
	public void positive() {
		int[] nums = {2,3,5,6};
		System.out.println(Arrays.toString(squareAndSort(nums)));
	}

	@Test
	public void negative() {
		int[] nums = {};
		System.out.println(Arrays.toString(squareAndSort(nums)));
	}

	@Test
	public void edgeCase() {
		int[] nums = {3,3,5,6,6};
		System.out.println(Arrays.toString(squareAndSort(nums)));
	}	

	@Test
	public void edge() {
		int[] nums = {-12,3,5,6};
		System.out.println(Arrays.toString(squareAndSort(nums)));
	}

	/*
	 * o[NlogN], O[1]
	 * Traverse to the array 
	 * square and replace at same index
	 * swapping
	 */


	private int[] squareAndSort(int[] input) {

		//O[N]
		for(int i =0 ; i < input.length;i++)
			input[i] *= input[i];
		
		
		// non -decrese
		// O(n log(n)) 
			Arrays.sort(input);
		
		// o[n^2]
		
		
		/* 1  LOGN N NLOGN N^2
		*
		*
		*N = 4
		*
		*  1
		*  2
		*  4
		*  8
		*  16
		*/

		
		// o[N] + o[N logN]   =>  o [N logN] 
		return input;
	}




























}
