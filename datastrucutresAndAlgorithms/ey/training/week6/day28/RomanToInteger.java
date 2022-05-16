package datastrucutresAndAlgorithms.ey.training.week6.day28;

public class RomanToInteger {
	private static int romanValue(char romanCharcater) {
		switch(romanCharcater) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
	public int romanToInt(String input) {

		char[] inputArray = input.toCharArray();
		int numericValue =0;
		for(int i=0;i<inputArray.length;i++) {
			boolean flag=true;
			int currentRomanValue = romanValue(inputArray[i]);
			if(i<inputArray.length-1) {
				int nextRomanValue = romanValue(inputArray[i+1]);
				if(currentRomanValue<nextRomanValue)
					flag=false;
			}
			if(flag)
				numericValue +=currentRomanValue;
			else
				numericValue -=currentRomanValue;
		}

		return numericValue;

	}
}
