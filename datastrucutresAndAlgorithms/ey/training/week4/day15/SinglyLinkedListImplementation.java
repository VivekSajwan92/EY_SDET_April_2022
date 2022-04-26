package datastrucutresAndAlgorithms.ey.training.week4.day15;

public class SinglyLinkedListImplementation<T> {

	// 1 5 7 2 9 22 13 66

	/*
	 * 1
	 */

	/*
	 * 
	 * Head, Tail
	 * 
	 * 
	 */

	Node<T> head, tail;
	int size;

	public void add(T value) {

		/*
		 * is list is empty -> add to the head and tail as same 
		 * if not -> just add to the tail
		 */

		if(head == null) {
			tail = head = new Node<T>(value);
		}else {
			tail.next =  new Node<T>(value);
			tail = tail.next;
		}
		size++;
	}
	// 1, 5 7 9    -> 2, 22  -> 1 ,5 7

	public void insert(int index, T value) {
		if(index > size) throw new IndexOutOfBoundsException();
		int tempIndex =0;
		Node<T> currentNode = head;

		if(index == size) 
			add(value);
		else {
			while(tempIndex < index-1) {
				currentNode = currentNode.next;
				tempIndex++;
			}
			//Old code
			//		Node<T> tempNode = currentNode.next;
			//		currentNode.next = new Node<T>(value);
			//		currentNode.next.next = tempNode;

			//new code with new Node constructor
			currentNode.next = new Node<T>(value, currentNode.next);
		}
		size++;
	}

	public String toString() {
		StringBuilder build = new StringBuilder();

		build.append("{");

		Node<T> tempNode = head;
		while(tempNode  != null) {
			build.append(tempNode.value+",");
			tempNode = tempNode.next;
		}

		build.deleteCharAt(build.length()-1);
		build.append("}");

		return build.toString();
	}


	public int size() {
		return size;
	}
}
