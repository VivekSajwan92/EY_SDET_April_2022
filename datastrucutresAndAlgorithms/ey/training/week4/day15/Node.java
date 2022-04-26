package datastrucutresAndAlgorithms.ey.training.week4.day15;


public class Node<T> {
	
	
	
	/**
	 * 
	 * singly link list -> buckets -> connect like trains
	 * 
	 * value - generic
	 * next -> holds the next object reference Node variable
	 * 
	 * 
	 */
	
	T value;
	Node<T> next;
	
	Node(T val){
		this.value = val;
	}

	
	Node(T val, Node<T> nextNode){
		this.value = val;
		this.next = nextNode;
	}

}
