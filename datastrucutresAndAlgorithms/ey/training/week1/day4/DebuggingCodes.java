package datastrucutresAndAlgorithms.ey.training.week1.day4;

import java.util.Arrays;

import org.junit.Test;

public class DebuggingCodes {

	@Test
	public void td() {
		int[] input = {1,2,3,4};
		failure2(input);
	}

	private void failure(int[] input) {
		int output[] = new int[input.length-1];

		for(int i=0; i < output.length;i++) {
			output[i] =  input[i]+input[i+1];
		}

		System.out.println(Arrays.toString(output));
	}


	private void failure2(int[] input) {
		int output[] = new int[input.length-1];
		int count =0;
		
		while(count < output.length) {
			output[count] =  input[count]+input[count+1];
		}

		System.out.println(Arrays.toString(output));

	}

}
