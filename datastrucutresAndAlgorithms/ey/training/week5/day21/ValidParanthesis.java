package datastrucutresAndAlgorithms.ey.training.week5.day21;

import java.util.Stack;

import org.junit.Test;

public class ValidParanthesis {
	@Test
	public void td() {
		System.out.println(validateParathesis("()[]{}"));
		System.out.println(validateParathesis("([])[]{}"));
		System.out.println(validateParathesis("({{{}{}}})[]{}"));
	}
	
	
	private boolean validateParathesis(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		for(Character ch : input.toCharArray()) {
			if(ch == '}') {
				if(stack.pop() != '{') return false;
			}else if( ch == ']') {
				if(stack.pop() != '[') return false;
			}else if(ch == ')') {
				if(stack.pop() != '(') return false;
			}else stack.push(ch);
		}
		
		return true;
	}
}
