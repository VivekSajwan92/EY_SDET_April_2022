package datastrucutresAndAlgorithms.ey.training.week1.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PascalTriangle {

	/**
	 * 
	 * 
	 * 1   ,   1 1   ,  1 2 1   ,  1 3 3 1,   1 4 6 4  1,   1 5 10 10 5 1
	 * 
	 * 
	 *  5
	 */


	@Test
	public void td() {
//		System.out.println(Arrays.toString(bruteForce(7)));
		optimised_1(3);
	}
	
	public int[] bruteForce(int n) {
		// to store each value, either we can store 2d array or object array, 
		//because 2D array uses more space than the object array
		Object[] primaryArray = new Object[n+1];
		
		//first index static value
		primaryArray[0] = new int[] {1};
		
		//loop from 1 to n values
		for(int i =1; i<=n;i++){
			
			// finding the last row values
			int[] oldArray = (int[]) primaryArray[i-1];
			
			//creating temp array 
			int[] tempArray = new int[oldArray.length+1];
			
			//assign first value in temp array as 1
			tempArray[0]= 1;
			
			//loop from 1 to last index -1 to add the values of previous row and add to current row
			for(int j =1; j< tempArray.length-1;j++){
				tempArray[j] = oldArray[j]+oldArray[j-1];
			}
			
			//assign last value in temp array as 1
			tempArray[tempArray.length-1] = 1;
			primaryArray[i] =  tempArray;
		}
		return (int[])primaryArray[n];
	}

	

	public int[] optmised(int n) {
		int[] oldArray = new int[] {1};
		
		for(int i =1; i<n;i++){
			int[] tempArray = new int[oldArray.length+1];
			tempArray[0]= 1;
			for(int j =1; j< tempArray.length-1;j++){
				tempArray[j] = (oldArray[j]+oldArray[j-1]);
			}
			tempArray[tempArray.length-1] = 1;
			oldArray = tempArray;
		}

		return oldArray;
	}

/*
 * 1
 * 11
 * 121
 * 
 * 
 * 
 */
	private ArrayList<Integer> optimised_1(int n){
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i =0; i <=n;i++) {
			al.add(1);
			for(int j= i-1; j> 0; j--) {
				al.set(j,  al.get(j-1)+al.get(j));
			}
		}
		
		return al;
	}


}
