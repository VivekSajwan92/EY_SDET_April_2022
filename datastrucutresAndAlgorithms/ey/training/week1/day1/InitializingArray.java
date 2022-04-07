package datastrucutresAndAlgorithms.ey.training.week1.day1;

import java.util.ArrayList;
import java.util.HashSet;

public class InitializingArray {

	public static void main(String[] args) {
	
		ArrayList<Integer> a = new ArrayList<Integer>(5);
		

		a.add(1);
		a.add(2);
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(2);
		a.add(1);
		a.remove(10);
		
		
		int[] s = {1,2,3,4,5};
		
		int g = 3;
		
		
		/**
		 * Calculate new capacity for AL
		 * 
		 *  oldLng + Math.max(minCapacity-oldLeng , oldLeg >> 1)
		 *  
		 *  oldLng => 10
		 *  minCapacity => 11
		 *  oldLeg >> 1 => 5
		 * 
		 *  10 + max(1 , 5) = > 10+5 => 15
		 * 
		 * power of 2 
		 * 
		 * 2 p 0 - 1
		 * 2 p 1 - 2
		 * 
		 * 			4
		 * 			8
		 * 			16
		 * 			32
		 * 			64
		 * 
		 * 15 => 1111
		 * 7
		 * 3
		 * 1
		 * >> 1 -> 1111 => 0111 => 1+2+4 => 7
		 * 
		 *  1+0+4+0 => 5
		 * 10-8 = 2
		 * 2-2 =0 
		 * 
		 */
		
	}

}
