package datastrucutresAndAlgorithms.ey.training.week7.day32;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortRecursion {


	@Test
	public void test() {
		int[] arr = {3,6,2,1,7,-4, 3};
		bubbleSort_recursive(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}



	private void bubbleSort_recursive(int[] arr, int n) {

		if(n==1) return;
		
		for(int j =0; j < n-1;j++) {
			if(arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
		
		bubbleSort_recursive(arr, n-1);

	}

}
