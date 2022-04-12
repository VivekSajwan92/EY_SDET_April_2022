package datastrucutresAndAlgorithms.ey.training.week1.day5;

import org.junit.Test;

public class MissingNumber {


	@Test
	public void td1() {
		System.out.println(findMissingNumber(new int[] {5,2,1,3,0}));
	}

	@Test
	public void td2() {
		System.out.println(findMissingNumber(new int[] {5,2,1,3,4}));
	}

	@Test
	public void td3() {
		System.out.println(findMissingNumber(new int[] {0,2,1,3,4}));
	}
	

	/*
	 * Add values of the index and subtract with the current index array value 
	 */
	private int findMissingNumber(int[] input) {
		int missingNumber =input.length;

		for(int i=0; i< input.length; i++) {
			missingNumber += i - input[i];
		}

		return missingNumber;
	}

}
