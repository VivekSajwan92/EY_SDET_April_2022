package datastrucutresAndAlgorithms.ey.training.week1.day3;

import java.util.Arrays;

public class ReverseArray {
	
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		
		// 4bytes * 10 => 40 bytes
		
		int[] output = new int[input.length];
		
		for(int i =0;i < input.length; i++)
			output[input.length-1-i] = input[i];
		
		System.out.println(Arrays.toString(output));
		
		
	}

}
