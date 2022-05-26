package datastrucutresAndAlgorithms.ey.training.week8.day34;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {


	/*
	 * 
	 * 5,6,3,1,5,7,2,4
	 * 
	 * 
	 * 5,6,3,1   5,7,2,4
	 * 5,6  3,1   5,7  2,4
	 * 
	 * 5 6   3  1   5  7   2  4
	 * 
	 * 5,6  1,3  5,7  2,4
	 * 
	 * 
	 * 1,3,5,6   2,4,5,7
	 * 
	 * 1,2,3,4,5,5,6,7
	 * 
	 */

	void mergeSort(int[] arr, int start, int end) {

		if(start < end) {
			int mid = (start+end)/2;

			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);	
			
			merge(arr, start,mid,end);
		}
	}

	private void merge(int[] arr, int start, int mid, int end) {
		
		
		int temp[] = new int[end-start+1];
		
		int i =start, j=mid+1,k=0;
		
		while(i <=mid && j <=end) {
			if(arr[i] <= arr[j]) temp[k++] = arr[i++];
			else temp[k++] =arr[j++];
		}
		
		while(i <= mid) temp[k++] = arr[i++];
		
		while(j <= end)  temp[k++] = arr[j++];
		
		
		for(i = start;  i <= end;i++) {
			arr[i]= temp[i-start];
		}
		
	}
	
	@Test
	public void test1() {
		int[] input = {5,6,3,1,7,2,4};
		
		mergeSort(input, 0, input.length-1);
		
		System.out.print(Arrays.toString(input));
	}

}
