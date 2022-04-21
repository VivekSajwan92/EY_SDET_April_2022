package datastrucutresAndAlgorithms.ey.training.week3.day12;

public class DoublyLinkedList<T> {

	Node<T> head, tail;
	int size;

	public void add(T value) {
		if(head == null) head = tail = new Node<T>(value,null);
		else {
			tail = tail.next = new Node<T>(value, tail, tail.next);
		}
		size++;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");

		Node<T> tempNode = head;

		while(tempNode !=null) {
			builder.append(tempNode.value+",");
			tempNode = tempNode.next;
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append("}");
		return builder.toString();
	}

	public String reverseToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");

		Node<T> tempNode = tail;

		while(tempNode !=null) {
			builder.append(tempNode.value+",");
			tempNode = tempNode.previous;
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append("}");
		return builder.toString();
	}

	public int indexOf(T value) {
		int index = 0;
		Node<T> tempNode = head;

		while(tempNode != null) {
			if(tempNode.value == value)
				return index;

			tempNode = tempNode.next;
			index++;
		}
		return -1;
	}

	public boolean contains(T value) {
		Node<T> tempNode1 = head, tempNode2 = tail;
		int pointer = 0;

		while(pointer++ < size/2+1) {
			if(tempNode1.value == value) return true;
			else if(tempNode2.value == value) return true;

			tempNode1 = tempNode1.next;
			tempNode2 = tempNode2.previous;
		}
		return false;
	}

	public T get(int index) {

		if(index >= size) throw new IndexOutOfBoundsException();

		if(index < size/2) {
			int currentIndex = -1;
			Node<T> tempNode = head;
			while(++currentIndex != index) {
				tempNode = tempNode.next;
			}
			return tempNode.value;
		}else {
			int currentIndex = size;
			Node<T> tempNode = tail;
			while(--currentIndex != index) {
				tempNode = tempNode.previous;
			}
			return tempNode.value;
		}
	}

	public void insert(int index, T value) {
		if(index ==0) head = new Node<T>(value, head);
		else if (index == size) add(value);
		else {
			if(index < size/2) {
				int currentIndex = 0;
				Node<T> tempNode = head;
				while(++currentIndex != index) {
					tempNode = tempNode.next;
				}
				tempNode.next = new Node<T>(value, tempNode, tempNode.next);
			}else {
				int currentIndex = size;
				Node<T> tempNode = tail;
				while(--currentIndex != index) {
					tempNode = tempNode.previous;
				}
				tempNode.previous = new Node<T>(value, tempNode.previous, tempNode.next);
			}
		}
	}
	
	public int size() {
		return size;
	}
}


class Node<T>{
	T value;
	Node<T> next, previous;

	public Node(T value, Node<T> next) {
		this.value = value;
		this.previous = null;
		this.next = next;
	}

	public Node(T value, Node<T> previous,Node<T> next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}
}
