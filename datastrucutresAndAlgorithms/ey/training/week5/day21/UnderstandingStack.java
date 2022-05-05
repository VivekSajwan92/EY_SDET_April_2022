package datastrucutresAndAlgorithms.ey.training.week5.day21;

import java.util.Stack;

import org.junit.Test;

import datastrucutresAndAlgorithms.ey.training.week3.day11.SinglyLinkedList;

public class UnderstandingStack {

	/*
	 * 
	 * 1,3,5,2
	 * 
	 * 
	 * add 13
	 * 
	 * 13 1 3 5 2
	 * 
	 * push -> create an node for 13 and replace that as head, current head will be its next node
	 * 
	 * pop -> first entity in the stack should be removed
	 */

	SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

	@Test
	public void test() {

		dataSetup();


		//		pushValue();
		popValue();
	}

	private void dataSetup() {
//		int[] arr = new int[] {1,4,5,6};
		int[] arr = new int[] {1};

		for(int a : arr) {
			sll.add(a);
		}

		System.out.println(sll.toString());
	}

	private void pushValue() {
		sll.push(13);
		System.out.println(sll.toString());
	}


	private void popValue() {
		while(sll.size() > 0) {
			System.out.println(sll.pop());
			System.out.println(sll.toString());
		}
	}

}
