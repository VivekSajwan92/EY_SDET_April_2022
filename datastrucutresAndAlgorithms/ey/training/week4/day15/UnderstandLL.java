package datastrucutresAndAlgorithms.ey.training.week4.day15;

public class UnderstandLL {

	private void singly() {
		SinglyLinkedListImplementation<Integer> sll = new SinglyLinkedListImplementation<>();

		sll.add(1);
		sll.add(7);
		sll.add(9);
		sll.add(17);

		System.out.println(sll.toString());
		sll.insert(4,22);
		System.out.println(sll.toString());
	}


	private void doubly() {
		DoubleLinkedLIstImplementations<Integer> sll = new DoubleLinkedLIstImplementations<>();

		sll.add(1);
		sll.add(7);
		sll.add(9);
		sll.add(17);

		System.out.println(sll.toString());
		System.out.println(sll.toStringReverse());
	}
	
	public static void main(String[] args) {

		new UnderstandLL().doubly();
	}

}
