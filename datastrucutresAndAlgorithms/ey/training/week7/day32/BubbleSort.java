package datastrucutresAndAlgorithms.ey.training.week7.day32;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSort {
	
	/*
	 * outer loop from o to n-1 ( if we do till n, we get index bound exception, as n and its adjacent is being considered)
	 * inner loop from 0 to n-1-i(we are finalizing the highest number first, so reducing the range from right side of the array)
	 * consider j and j+1, if j is largest, swap.
	 */
	
	
	@Test
	public void test() {
		int[] arr = {3,6,2,1,7,-4, 3};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	private void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length-1;i++) {
			for(int j =0; j < arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
