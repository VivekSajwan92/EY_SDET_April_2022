package datastrucutresAndAlgorithms.ey.training.week2.day1;

import java.util.Arrays;

import org.junit.Test;

public class ReverseArray {

	@Test
	public void td1() {
		int[] input = {1,2,3,4,5};
		bruteForce(input);
		twoPointer(input);
		System.out.println(Arrays.toString(input));
	}
	
	private void bruteForce(int[] input) {
		int[] output = new int[input.length];
		
		for(int i =0; i < input.length;i++)
			output[input.length-1-i] = input[i];
		
		System.out.println(Arrays.toString(output));
	}
	
	 /* 1 2 3 4 5
	  * 
	  * 1 5
	  * 
	  * temp 1
	  *  5 <- 1
	  *  
	  *  5 2 3 4 5
	  *  
	  *  5 2 3 4 1
	  *  
	  *  temp 2
	  *  
	  *  4 <- 2
	  *  
	  *  5 4 3 2 1
	  * 
	  */
	private void twoPointer(int[] input) {
		 int firstPointer =0 , secondPointer = input.length-1;
		 
		 while(firstPointer < secondPointer) {
			 int temp = input[firstPointer];
			 input[firstPointer++] = input[secondPointer];
			 input[secondPointer--] = temp;
		 }
		 
		 System.out.println(Arrays.toString(input));
	}
	
	
}
