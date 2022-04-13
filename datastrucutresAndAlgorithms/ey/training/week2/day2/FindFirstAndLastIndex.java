package datastrucutresAndAlgorithms.ey.training.week2.day2;

import java.util.Arrays;

import org.junit.Test;

public class FindFirstAndLastIndex {

	@Test
	public void td1() {
		System.out.println(Arrays.toString(twoPointer(new int[]{1,2,3,5,5,5,5,5,6,8}, 5)));
	}

	@Test
	public void td2() {
		System.out.println(Arrays.toString(twoPointer(new int[]{1}, 1)));
	}

	@Test
	public void td3() {
		System.out.println(Arrays.toString(twoPointer(new int[]{11}, 1)));
	}
	@Test
	public void td4() {
		System.out.println(Arrays.toString(twoPointer_optmised(new int[]{1,1,2,3}, 1)));
	}
	private int[] bruteForce(int[] input, int target) {

		int pointer =0;

		//		for( ; pointer < input.length && input[pointer] != target; pointer++);
		while(pointer < input.length && input[pointer++] != target);

		if(pointer < input.length) {
			int second = --pointer;

			/*
			 * end of the array
			 * 
			 * 
			 */
			while(second < input.length && input[second] == target) {
				second++;
			}
			return new int[] {pointer,second-1};
		}

		return new int[] {-1,-1};
	}


	// 1,2,3,5,5,5,5,5,6,8 -> 5
	private int[] twoPointer(int[] input, int target) {
		int first =0, second = input.length-1;
		while(first <= second) {
			if(input[first] == target && input[second] == target)
				return new int[] {first,second};

			if(input[first]!= target) first++;

			if(input[second] != target) second--;

		}

		return new int[] {-1,-1};
	}
	// 5, 5, 5 

	// 1,1,2 3 -> 1
	private int[] twoPointer_optmised(int[] input, int target) {
		int index = Arrays.binarySearch(input, target);
		
		if(index < 0) return new int[] {-1,-1};
		else {
			int first = index, second =index;
			while(first >=0 && second < input.length) {
				
				if(input[first] != target && input[second] != target) break;

				if(input[first] == target) first--;

				if(input[second] == target) second++;

				
			}
			return new int[] {first+1,second-1};
		}
	}

}
