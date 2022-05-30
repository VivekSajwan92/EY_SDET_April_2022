package datastrucutresAndAlgorithms.ey.training.week9.day38;

import org.junit.Test;

public class LongestCommonPrefix {

	
	/*
	 * "flower"
	 * "flow"
	 * "flight"
	 */
	
	@Test
	public void test() {
		System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs.length ==0) return "";
		if(strs.length ==1) return strs[0];

		// Minimum length substring and its index
		int minLengthIndex = -1;
		int minLength = Integer.MAX_VALUE;
		for(int i=0; i<strs.length; i++){
			if(minLength > strs[i].length()){
				minLength = strs[i].length();
				minLengthIndex =i;
			}
		}
		
		
		String first = strs[minLengthIndex];
		StringBuilder output = new StringBuilder();
		//outer loop will be with the min length string
		for(int index =0 ; index < minLength; index++){
			
			//get the character of the min length string
			char currentChar = first.charAt(index);

			//validate the char with other strings
			for(String each: strs){
				//validate the current outer loop char in the index matches the other string char in same index
				if(each.charAt(index) != currentChar) return output.toString();
			}
			
			// appending the char in SB
			output.append(currentChar);
		}
		return output.toString();
	}
}
