package datastrucutresAndAlgorithms.ey.training.week3.day11;

import org.junit.Test;

public class UnderstandingLinkedList {


	@Test
	public void td1() {
//		singleLinkedList();
		addMethod();
	}


	private void addMethod() {
		SinglyLinkedList<Integer> singly = new SinglyLinkedList<Integer>();


		singly.add(2);
		
		System.out.println(singly.head);
		System.out.println(singly.tail);
		singly.add(24);
	}

	private void singleLinkedList() {
		int[] input = {1,2,3,4,5,6,7};

		SinglyLinkedList<Integer> singly = new SinglyLinkedList<Integer>();


		singly.add(input[0]);
		singly.add(input[1]);
		singly.add(input[2]);
		singly.add(input[3]);

		System.out.println(singly.toString());

		//		singly.removeAll(input[0]);
		//		System.out.println(singly.toString());

		System.out.println(singly.get(2));

		System.out.println(singly.contains(2));
		System.out.println(singly.contains(1));

		System.out.println(singly.indexOf(3));
		System.out.println(singly.indexOf(33));


		singly.insert(4, 78);
		System.out.println(singly.toString());



	}

}
