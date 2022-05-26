package datastrucutresAndAlgorithms.ey.training.week8.Day36;

import org.junit.Test;

public class BinarySearchAlgorithm {
	/*
	 * Divide and Conquer Algorithm
	 * helps to find the element on some conditions
	 * 	1. the array or list should be sorted
	 * 	2. if duplicated of the target, will return any of the index
	 * 
	 * 
	 * Can be done by iterative and recursive
	 * 
	 * if no element return -1
	 * 
	 */

	@Test
	public void test() {	
		int[] input = {1,4,4,6,8,10,23};
//		System.out.println(bsa_iterative(input, 10));
		System.out.println(bsa_recursive(input, 10,0,input.length-1));
		System.out.println(bsa_recursive(input, 4,0,input.length-1));
//		System.out.println(bsa_iterative(input, 1));
//		System.out.println(bsa_iterative(input, 6));
//		System.out.println(bsa_iterative(input, 11));
//		System.out.println(bsa_iterative(input, 23));

		/*
		 * int[] input = {1}; System.out.println(bsa_iterative(input, 1));
		 */
	}

	int bsa_iterative(int[] arr, int target) {

		//initializing the left and the tight
		int left = 0, right = arr.length-1;

		//loop breaks when left > right
		while(left <= right) {

			//calculate middle index
			int mid = (left+right)/2;

			//if middle index value is equal to target, return index
			if(arr[mid] == target) return mid;

			//if middle index value is lesser to target, set left as middle index+1, else set right as middle index-1
			if(arr[mid] < target)  left = mid+1;
			else right = mid-1;		
		}

		//if code reached here, target is not in the array
		return -1;
	}

	int bsa_recursive(int[] arr, int target, int left, int right) {
		if(left <= right) {

			int mid = (left+right)/2;

			if(arr[mid] == target) return mid;

			if(arr[mid] < target) return bsa_recursive(arr, target, mid+1, right);

			return bsa_recursive(arr, target, left, mid-1);
		}
		return -1;
	}


}
