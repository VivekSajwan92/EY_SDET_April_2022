package datastrucutresAndAlgorithms.ey.training.week6.day26;

import java.util.Arrays;


public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		int carryForward = 0;

		if(digits[digits.length-1] == 9){
			carryForward =1;
			digits[digits.length-1] = 0;
		}else digits[digits.length-1]++;

		for(int i = digits.length-2; i>=0; i--){
			if(carryForward!=0){
				if(digits[i] == 9){
					digits[i] = 0;
				}else {
					digits[i]++;
					carryForward=0;
				}
			}
		}

		if(carryForward==1){
			digits = Arrays.copyOf(digits, digits.length+1);
			digits[0] = 1;
		}

		return digits;
	}
}
