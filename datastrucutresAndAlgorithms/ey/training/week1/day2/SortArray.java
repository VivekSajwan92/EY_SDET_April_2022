package datastrucutresAndAlgorithms.ey.training.week1.day2;

import java.util.Arrays;

import org.junit.Test;

public class SortArray {

	public void sortArray(int[] input) {

		int loop =0;
		for(int i =0;i < input.length; i++) {
			for(int j =i+1; j < input.length; j++) {
				if( input[i] > input[j]) {
					int temp = input[j];
					input[j] = input[i];
					input[i] = temp;
				}
				loop++;
			}
		}
		
		
		
		System.out.println(Arrays.toString(input));
		System.out.println(loop);
		
		/*
		 * O[1]
		 * 
		 * O[1] * O[N] ..... O[1]*O[N]
		 * 
		 * O[N] * O[N] => O[N*N] => O[N^2]
		 */
	}
	
	

	@Test
	public void testcase() {
		sortArray(new int[]{3,5,7,1,10,8});
	}

}
