package datastrucutresAndAlgorithms.ey.training.week5.day19;

import org.junit.Test;

public class MaximumSubStringBetweenCharacters {
	
	// ayudfbamkooklky
	
	
	@Test
	public void test() {
		System.out.println(maxSubstring("ayudfbamkooklky"));
		System.out.println(maxSubstring("asdfg"));
		System.out.println(maxSubstring("aa"));
	}
	
	/*
	 * lower case
	 * substring between same char
	 * 
	 * -1
	 * 
	 * 
	 * abnha
	 */
	// currentindex-firstindex-1 -> 5-1-1 => 3
	
	private int maxSubstring(String input) {
		int maxLength = -1;
		int[] arr = new int[26];
		
		for(int i= 1; i <= input.length();i++) {
			int index = input.charAt(i-1) - 'a';
			if(arr[index] != 0) {
				maxLength = Math.max(maxLength, i-arr[index]-1);
			}else arr[index] = i;
		}
		
		
		return maxLength;
	}

}
