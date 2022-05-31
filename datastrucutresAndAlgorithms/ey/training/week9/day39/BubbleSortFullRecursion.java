package datastrucutresAndAlgorithms.ey.training.week9.day39;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortFullRecursion {


	@Test
	public void test() {
		int[] arr = {3,6,2,1,7,-4, 3};
		bubbleSort_recursive(arr,arr.length);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[]{3,6,2,1,7,-4, 3};
		bubbleSort_recursive_Desc(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}



	private void bubbleSort_recursive(int[] arr, int n) {

		if(n==1) return;

		recursiveSwap(arr, n, 0);

		bubbleSort_recursive(arr, n-1);

	}


	private void recursiveSwap(int arr[], int n, int index) { 
		if(arr.length-1 ==index) return; 
		if(arr[index] > arr[index+1]) {
			int temp = arr[index];
			arr[index] = arr[index+1];
			arr[index+1] = temp;
		}
		recursiveSwap(arr, n, index+1);
	}
	
	private void bubbleSort_recursive_Desc(int[] arr, int n) {

		if(n==1) return;

		recursiveSwap_Desc(arr, n, 0);

		bubbleSort_recursive_Desc(arr, n-1);

	}


	private void recursiveSwap_Desc(int arr[], int n, int index) { 
		if(arr.length-1 ==index) return; 
		if(arr[index] < arr[index+1]) {
			int temp = arr[index];
			arr[index] = arr[index+1];
			arr[index+1] = temp;
		}
		recursiveSwap_Desc(arr, n, index+1);
	}

}
