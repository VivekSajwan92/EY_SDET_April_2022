package datastrucutresAndAlgorithms.ey.training.week2.day3;

import org.junit.Test;
import org.openjdk.jol.vm.VM;

public class ReverseString {

	@Test
	public void td() {
//		System.out.println(twoPointer("input"));
//		System.out.println(bruteForce("input"));
//		System.out.println(stringBufferImp("input"));
		System.out.println(stringBufferReverse("input"));
	}


	private String bruteForce(String input) {
		String temp = "";

		for(int i = input.length()-1; i > -1 ; i--) {
			temp += input.charAt(i);
			System.out.println(VM.current().addressOf(temp));
		}
		return temp;
	}

	private String twoPointer(String input) {
		char[] arr = input.toCharArray();
		for ( int i = 0; i <arr.length/2; i++) {
			char temp = arr[arr.length-1-i];
			arr[arr.length-1-i] = arr[i];
			arr[i] = temp;
		}
		return new String(arr);
	}
	

	private String stringBufferImp(String input) {
		StringBuffer buff = new StringBuffer();

		for(int i = input.length()-1; i > -1 ; i--) {
			buff.append(input.charAt(i));
			System.out.println(VM.current().addressOf(buff));
		}
		return buff.toString();
	}

	
	private String stringBufferReverse(String input) {
		return new StringBuffer(input).reverse().toString();
	}
}
