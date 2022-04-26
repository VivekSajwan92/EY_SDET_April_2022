package datastrucutresAndAlgorithms.ey.training.week3.day15;

public class DoublyNode<T> {
/*
 * 
 *    1 <-> 2 <-> 6
 *    
 *     
 *     node next , previous
 *     t value
 */
	T value;
	DoublyNode<T> next, previous;
	
		
	public DoublyNode(T val, DoublyNode<T> prv) {
		this.value = val;
		this.previous = prv;
	}
}
