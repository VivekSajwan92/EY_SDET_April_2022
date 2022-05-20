package datastrucutresAndAlgorithms.ey.training.week7.day32;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSort {
	
	
	@Test
	public void insertionSort() {
		int[] arr = {3,6,2,1,7,-4, 3};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	void insertionSort(int[] arr) {
		
		for( int i =0 ;i < arr.length-1;i++) {
			
			if(arr[i] > arr[i+1]) {
				swap(arr, i, i+1);
				
				int pointer = i;
				
				while(pointer > 0) {
					if(arr[pointer] < arr[ pointer-1])
						swap(arr, pointer, pointer-1);
					else 
						break;
					pointer--;
				}
			}
		}
	}
	
	
	void swap(int[] arr, int index1 ,int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
