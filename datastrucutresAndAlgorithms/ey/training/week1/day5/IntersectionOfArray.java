package datastrucutresAndAlgorithms.ey.training.week1.day5;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class IntersectionOfArray {

	@Test
	public void td(){
		System.out.println(Arrays.toString(intersection(new Integer[]{1,2,2,1}, new Integer[]{2,2})));
		System.out.println(Arrays.toString(optimized(new Integer[]{1,2,2,1}, new Integer[]{2,2})));
		System.out.println(Arrays.toString(alternate_solution(new Integer[]{1,2,2,1}, new Integer[]{2,2})));
	}

	@Test
	public void td1(){
		System.out.println(Arrays.toString(intersection(new Integer[]{1,1,2}, new Integer[]{2,2,1})));
		System.out.println(Arrays.toString(optimized(new Integer[]{1,1,2}, new Integer[]{2,2,1})));
		System.out.println(Arrays.toString(alternate_solution(new Integer[]{1,1,2}, new Integer[]{2,2,1})));
	}

	@Test
	public void td2(){
		System.out.println(Arrays.toString(intersection(new Integer[]{2}, new Integer[]{})));
		System.out.println(Arrays.toString(optimized(new Integer[]{2}, new Integer[]{})));
		System.out.println(Arrays.toString(alternate_solution(new Integer[]{2}, new Integer[]{})));
	}

	@Test
	public void td3(){
		System.out.println(Arrays.toString(intersection(new Integer[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}, new Integer[]{0,1,3,Integer.MAX_VALUE})));
		System.out.println(Arrays.toString(optimized(new Integer[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}, new Integer[]{0,1,3,Integer.MAX_VALUE,Integer.MAX_VALUE})));
		System.out.println(Arrays.toString(alternate_solution(new Integer[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}, new Integer[]{0,1,3,Integer.MAX_VALUE,Integer.MAX_VALUE})));
	}

	/*
	 * convert each array into ArrayList
	 * 
	 * create an output ArrayList
	 * 
	 * iterate over ArrayList one and find the value in ArrayList and and it should not contain in output ArrayList
	 * if satisfying above condition, add to the value into output ArrayList
	 * return as array by toArray method
	 * 
	 * O[N^N]
	 */

	public Integer[] intersection(Integer[] input1, Integer[] input2){
		ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(input1)); //o[m]
		ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(input2)); //o[n]
		ArrayList<Integer> output = new ArrayList<>();

		for(int eachElement: al1){

			if(al2.contains(eachElement) && !output.contains(eachElement))
				output.add(eachElement);
		}

		return output.toArray(new Integer[0]);
	}

	/*
	 *sort the input array
	 *fill the array with maximum value
	 *initialize output array which is minimum size of input1 and input2 arrays and counter for output array
	 * loop through array1 and find the number is not in output array and in input2 array, by binary search
	 * if so yes add to the output array and increments the counter
	 * return copy of range from 0 to the counter value
	 */

	public int[] optimized(Integer[] input1, Integer[] input2){
		Arrays.sort(input1);  // O[NlogN]
		Arrays.sort(input2); // O[MLogM]
		int[] output = new int[Math.min(input1.length, input2.length)];
		Arrays.fill(output, Integer.MAX_VALUE); //O[N]

		int counter=0;


		if(Arrays.binarySearch(input2, Integer.MAX_VALUE) > -1 && Arrays.binarySearch(input2, Integer.MAX_VALUE) > -1) counter++;

		for(int eachElement: input1){
			//O[log m] && O[log k]
			if(Arrays.binarySearch(output, eachElement) < 0 && Arrays.binarySearch(input2, eachElement) > -1){
				output[counter++] = eachElement;
			}
		}
		return Arrays.copyOfRange(output, 0 , counter);
	}

	/*
	 * 	initialize input array and temp array of maximum size
	 * mark the value index of the input 1 as true
	 * loop through input2 and mark those values false and add it ti output array
	 * slice the array
	 */
	public int[] alternate_solution(Integer[] input1, Integer[] input2) {

		int[] output = new int[Math.min(input1.length, input2.length)];
		boolean[] tempArray = new boolean[Integer.MAX_VALUE];

		int counter=0;

		for(int eachInt: input1)
			tempArray[eachInt] = true;

		for(int eachInt: input2) {
			if(tempArray[eachInt]) {
				output[counter++] = eachInt;
				tempArray[eachInt] = false;
			}
		}


		return Arrays.copyOfRange(output, 0 , counter);
	}


}
