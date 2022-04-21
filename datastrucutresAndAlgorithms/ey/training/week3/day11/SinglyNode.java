package datastrucutresAndAlgorithms.ey.training.week3.day11;

public class SinglyNode<T> {
	
	T value;
	public SinglyNode<T> next;

	public SinglyNode(T value) {
		this.value = value;
		this.next = null;
	}

	public SinglyNode(T value, SinglyNode<T> next) {
		this.value = value;
		this.next = next;
	}

}
