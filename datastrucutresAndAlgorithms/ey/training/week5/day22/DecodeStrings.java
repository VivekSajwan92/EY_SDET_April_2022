package datastrucutresAndAlgorithms.ey.training.week5.day22;

import java.util.Stack;

import org.junit.Test;

public class DecodeStrings {

	
	/*
	 * 3[a]2[c5[f]]
	 * 
	 * 3 a
	 * 2 c5[f]
	 * 		5 f   2 c 5 f 2	cfffff cfffffcfffff
	 */
	
//	@Test
	public void test() {
		System.out.println(decode("3[a]2[c5[f]]"));
	}
	
	
	/*
	 * 2 * c5[f]
	 * 2 * c + 5 * f
	 * 2 * cfffff
	 * cfffffcfffff
	 */

//	@Test
	public void test1() {
		System.out.println(decode("2[c5[f]]"));
	}
	
	@Test
	public void test2() {
		String a = decode("232[c]");
		System.out.println(a.length());
	}
	
	private String decode(String input) {

		Stack<StringBuilder> builderStack = new Stack<StringBuilder>();
		Stack<Integer> timesStack = new Stack<Integer>();
		builderStack.push(new StringBuilder());
		
		int number = 0;
		
		for(char ch : input.toCharArray()) {
			
			if(ch == '[') {
				timesStack.push(number);
				builderStack.push(new StringBuilder());
				number =0;
			}else if(ch == ']') {
				int times = timesStack.pop();
				String temp = builderStack.pop().toString();
				StringBuilder sb = builderStack.peek();
				while(times-- > 0) sb.append(temp);
			}else if(Character.isDigit(ch)) {
				number = number*10+(ch-'0');
			}else {
				builderStack.peek().append(ch);
			}
			
			
		}
		
		return builderStack.pop().toString();
	}

}
