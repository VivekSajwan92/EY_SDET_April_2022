package datastrucutresAndAlgorithms.ey.training.week1.day5;

import java.util.Arrays;

import org.junit.Test;

public class RemoveTheElement {


	@Test
	public void td1(){
		System.out.println(twoPointer(new int[]{1,2,3,3,7,5,3,8,2}, 3));
	}	

	@Test
	public void td2(){
		System.out.println(twoPointer(new int[]{3,3}, 3));
	}

	/*
	 * 
	 * find the occurrence of the given number in the array
	 * initialize an array pointer and loop the array and place the current numberue in the pointer numberue of array, if current numberue is not the given numberue
	 * 
	 */

	private int removeElement(int[] input, int number){
		int arrayCount =0, numberCount =0 ;
		for(int i =0; i <input.length;i++){
			if( input[i] == number) numberCount++;
		}

		for(int i =0; i <input.length && input.length!=numberCount+arrayCount ;i++){
			if( input[i] != number){
				input[arrayCount++] = input[i];
			}
		}

		return input.length-1-numberCount;
	}
	
	/*

	* initialize first Index and second Index
	* Loop until secondIndex is less than input length
	* if value in secondIndex and FirstIndeX is not equal to number
	* Increment both firstIndex and secondIndex
	* if value in secondIndex is equal to number, increment secondIndex
	* if value of secondIndex is not equal to number and value of firstIndex is equal to number, swap the elements
	* Increment both firstIndex and secondIndex
	*/



	private int twoPointer(int[] input, int number) {

		int firstIndex = 0, secondIndex = 0;

		while(secondIndex<input.length) {

			if(input[secondIndex] != number && input[firstIndex] == number) {

				input[firstIndex++] = input[secondIndex];

				input[secondIndex++] = number;

			}else if(input[secondIndex]!=number && input[firstIndex] != number) {

				firstIndex++;

				secondIndex++;

			}else if(input[secondIndex] == number)secondIndex++;
		}
		return firstIndex;
	}

}
