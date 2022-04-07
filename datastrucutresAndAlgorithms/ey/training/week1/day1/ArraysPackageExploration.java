package datastrucutresAndAlgorithms.ey.training.week1.day1;

import java.util.Arrays;
import java.util.List;

public class ArraysPackageExploration {

	public static void main(String[] args) {

//		int[][] input = {{1,2,3},{4,5}};
		int[] input = {1,2,3,4,6};
		
		System.out.println(input);

//		System.out.println(Arrays.deepToString(input));
//		System.out.println(Arrays.toString(input));
		
		/*
		 * List<Integer> a = Arrays.asList(input);
		 * 
		 * System.out.println(a);
		 */
		
//		System.out.println(Arrays.binarySearch(input, 5));
//		
//		Arrays.sort(input);
		
		/*
		 * int[] b = Arrays.copyOf(input, 10);
		 * 
		 * System.out.println(Arrays.toString(b));
		 * 
		 * 
		 * int[] cpr = Arrays.copyOfRange(input, 01, 3);
		 * System.out.println(Arrays.toString(cpr));
		 */
		
		int[] e = new int[5];
		System.out.println(Arrays.toString(e));
		
		Arrays.fill(e, 2);
		System.out.println(Arrays.toString(e));
	}

}
