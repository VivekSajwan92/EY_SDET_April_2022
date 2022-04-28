package datastrucutresAndAlgorithms.ey.training.week4.day17;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class TwoSum {

	@Test
	public void td1() {
		System.out.println(Arrays.toString(twoSum(new int[] {1,4,7,8}, 12)));
	}
	

	@Test
	public void td2() {
		System.out.println(Arrays.toString(twoSum(new int[] {4,4,1}, 5)));
	}
	
	
	private int[] twoSum(int[] input, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		
		/*
		 * find the target - currentValue is there in map
		 * 	yes, return the index of target-currentValue and current index
		 * 	no, add the currentValue and its respective index in the hashmap
		 */
		for( int i =0; i<input.length; i++) {
			if(map.containsKey(target-input[i])) {
				return new int[] {map.get(target-input[i]), i};
			}else map.put(input[i], i);
		}
				
		return null;
	}

}




//https://leetcode.com/problems/destination-city/
