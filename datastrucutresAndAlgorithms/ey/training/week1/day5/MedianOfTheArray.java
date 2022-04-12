package datastrucutresAndAlgorithms.ey.training.week1.day5;

import org.junit.Test;

public class MedianOfTheArray {

	/*
	 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
	 * return the median of the two sorted arrays with linear time complexity
	 */
	
	@Test
	public void td1(){
		System.out.println(findMedian(new int[]{1,3,15,72}, new int[]{5,10,33,45}));
	}
	@Test
	public void td2(){
		System.out.println(findMedian(new int[]{}, new int[]{5,10,33,45}));
	}
	@Test
	public void td3(){
		System.out.println(findMedian(new int[]{-15,1,3,72}, new int[]{-5,10,33,45}));
	}

	/*
	 * assign pointers for first index, second index and output array index
	 * output array is calculated with length of both array divide by 2 +1
	 * assign the sorted values in output array
	 * if 	odd - return center value
	 * 		even - return sum / 2 of median values
	 */

	private float findMedian(int[] input1, int[] input2){

		int firstArrayIndex = 0, secondArrayIndex = 0, outputArrayIndex =0;

		/*
		 * input1 length = 4
		 * input2 length = 4
		 *
		 *  output length = 8
		 *
		 * [1,2,3,4,5,7,10,12]
		 */
		int[] output = new int[(input1.length+input2.length)/2+1];

		// (m+n)/2
		for( ; outputArrayIndex<output.length && input1.length > firstArrayIndex && input2.length > secondArrayIndex ;outputArrayIndex++){
			if(input1[firstArrayIndex] < input2[secondArrayIndex])
				output[outputArrayIndex] = input1[firstArrayIndex++];
			else
				output[outputArrayIndex] = input2[secondArrayIndex++];
		}

		while(outputArrayIndex < output.length) {
			if (input1.length > firstArrayIndex) {
				output[outputArrayIndex++] = input1[firstArrayIndex++];
			}else{
				output[outputArrayIndex++] = input2[secondArrayIndex++];
			}
		}

		if((input1.length+input2.length) %2 ==0) return ((float)output[output.length-2]+(float)output[output.length-1])/2;
		else return output[output.length-1];
	}


}
