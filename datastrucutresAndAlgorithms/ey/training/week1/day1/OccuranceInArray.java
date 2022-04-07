package datastrucutresAndAlgorithms.ey.training.week1.day1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class OccuranceInArray {

	public int findTheIntegerArray(int[] input, int number) {
		int counter =0 ;

		for(int i=0; i < input.length; i++)
			if(input[i] == number)counter++;

		return counter;
	}


	public int findTheIntegerArrayList(List<Integer> input, int number) {
		int counter =0 ;

		for(int i=0; i < input.size(); i++)
			if(input.get(i) == number)counter++;

		return counter;
	}

	@Test
	public void tc1() {
		System.out.println("Array "+findTheIntegerArray(new int[] {5,6,7,4,2,3,4}, 4));
		System.out.println("ArrayList "+findTheIntegerArrayList(Arrays.asList(new Integer[]{5,6,7,4,2,3,4}), 2));
	}

}
