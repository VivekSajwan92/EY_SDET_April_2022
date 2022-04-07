package datastrucutresAndAlgorithms.ey.training.week1.day2;

import java.util.Arrays;

public class FillMethodunderstanding {
	
	public static void main(String[] args) {
		
		int[] input = new int[5];
		
		System.out.println(Arrays.toString(input));
		
		input[0] = 20;
		System.out.println(Arrays.toString(input));
		
		Arrays.fill(input, 11);
		System.out.println(Arrays.toString(input));
		
	}

}
