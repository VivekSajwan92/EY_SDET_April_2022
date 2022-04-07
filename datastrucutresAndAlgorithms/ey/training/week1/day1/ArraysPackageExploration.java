package datastrucutresAndAlgorithms.ey.training.week1.day1;

import java.util.Arrays;
import java.util.List;

public class ArraysPackageExploration {


	private void initializeArray() {
		//declare and non-initialize the array
		int[] input = {1,2,3,4,5};

		//declare and initialize the array
		int[] inputArray = new int[5];

		//non declare and initialize the array
		System.out.println(Arrays.toString(new int[5]));
		System.out.println(Arrays.toString(new int[] {1,2,3,4,5}));
	}


	private void arrayPackageMethod() {
		int[] input = {1,2,3,4,6};

		//Multi-Dimension Array
		int[][] multiDimesionArray = {{1,2,3},{4,5}};

		//this is will print the reference of the array location
		System.out.println(input);

		// deepToString - to convert multi dimension array to string
		String twoDimensionArrayString = Arrays.deepToString(multiDimesionArray);

		//toString - to convert array to string
		String oneDimensionArrayString = Arrays.toString(input);

		Integer[] integerArray = {1,2,3};
		//asList - convert array to List
		List<Integer> a = Arrays.asList(integerArray);

		//binarySearch - find the given element to search in the array -> O[log(N)]
		int index = Arrays.binarySearch(input, 5);

		//sort - sort the given array -> O[N log(N)]
		Arrays.sort(input);

		//copyOf - copy the current array elements into a new array with the given size
		int[] b = Arrays.copyOf(input, 10);

		//copyOfRange - slice the given array from the given start and end index, end index is exclusive
		int[] cpr = Arrays.copyOfRange(input, 1, 3);

		//fill - fill the entire array with the given values, irrespective of the values in it
		Arrays.fill(input, 2);
	}

}
