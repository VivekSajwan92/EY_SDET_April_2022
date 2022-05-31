package datastrucutresAndAlgorithms.ey.training.week9.day39;

import java.util.HashMap;

public class WordPattern {

	/*
	 * 
	 * Input: pattern = "abba", s = "dog cat cat dog"
	 * Output: true
	 * 
	 * a dog
	 * b cat
	 * b cat
	 * a dog
	 * 
	 * 
	 * a -> dog
	 * b -> cat
	 * 
	 * 
	 * 
	 *  "abba", s = "dog cat cat fish"
	 *  
	 *  a -> dog
	 *  b -> cat
	 *  b -> cat
	 *  a -> fish
	 *  
	 */
	public boolean wordPattern(String pattern, String input) {

		HashMap<Character, String> counter = new HashMap<Character, String>();
		String[] inputArray = input.split(" ");
		char[] charArray = pattern.toCharArray();
		
		if(inputArray.length !=pattern.length())
			return false;

		for(int i=0; i<pattern.length();i++) {
			boolean flag= counter.containsKey(charArray[i]);
			if( flag && !counter.get(charArray[i]).equals(inputArray[i]) || !flag && counter.containsValue(inputArray[i]))
				return false;

			counter.put(charArray[i], inputArray[i]);
		}
		return true;
	}

}
