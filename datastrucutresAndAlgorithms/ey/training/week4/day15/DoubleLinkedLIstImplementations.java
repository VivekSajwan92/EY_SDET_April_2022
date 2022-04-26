package datastrucutresAndAlgorithms.ey.training.week4.day15;

public class DoubleLinkedLIstImplementations<T> {

	/*
	 * 1
	 * 2
	 * 
	 * 
	 * 9
	 */
	DoublyNode<T> head, tail;
	int size;
	
	public void add(T value) {
		if(head == null) head = tail = new DoublyNode<T>(value,null);
		else {
			tail = tail.next = new DoublyNode<>(value, tail);
		}
		size++;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();

		build.append("{");

		DoublyNode<T> tempNode = head;
		while(tempNode  != null) {
			build.append(tempNode.value+",");
			tempNode = tempNode.next;
		}

		build.deleteCharAt(build.length()-1);
		build.append("}");

		return build.toString();
	}
	
	public String toStringReverse() {
		StringBuilder build = new StringBuilder();

		build.append("{");

		DoublyNode<T> tempNode = tail;
		while(tempNode  != null) {
			build.append(tempNode.value+",");
			tempNode = tempNode.previous;
		}

		build.deleteCharAt(build.length()-1);
		build.append("}");

		return build.toString();
	}
}
