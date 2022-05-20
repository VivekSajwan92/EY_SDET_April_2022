package datastrucutresAndAlgorithms.ey.training.week7.day32;

import java.util.Arrays;

import org.junit.Test;

public class SelectionSort {
	@Test
	public void test() {
		int[] arr = {3,6,2,1,7,-4};
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	/*
	 * outer loop element as pivot
	 * inner loop to find the minimum value
	 * swap the values
	 */
	
	private void selectionSort(int[] arr) {
		for( int i =0; i <arr.length-1; i++) {
			int minValue = arr[i], minValueIndex = i;
			for(int j = i+1; j < arr.length;j++) {
				if(arr[j] < minValue) {
					minValue = arr[j];
					minValueIndex = j;
				}
			}
			
			if(minValueIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minValueIndex];
				arr[minValueIndex] = temp;
			}
		}
	}
	

}
