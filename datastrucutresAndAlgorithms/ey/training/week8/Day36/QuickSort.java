package datastrucutresAndAlgorithms.ey.training.week8.Day36;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort {


	/*
	 * right most will be the pivot
	 * 
	 * arr[left] >= pivot and arr[right] <=pivot -> swap
	 * 
	 * left > right -> swap the pivot and the arr[right]
	 * 
	 * 
	 */

	@Test
	public void test() {
		int[] arr = {10,5,7,1,3,4};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	void sort(int[] arr, int left, int right) {
		if(left <right) {

			int pivot = partition(arr,left,right);

			sort(arr, left, pivot-1);
			sort(arr,pivot+1,right);
		}
	}

	private int partition(int[] arr, int left, int right) {

		for(int i =left; i <=right;i++) {
			if(arr[i] <= arr[right]) {
				int temp = arr[right];
				arr[right] = arr[i];
				arr[i] = temp;
			}
		}
		// swapped arr[left arr[right]

		int temp = arr[right];
		arr[right] = arr[left];
		arr[left] = temp;

		return left;
	}

}
