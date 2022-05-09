package datastrucutresAndAlgorithms.ey.training.week3.day11;

import java.util.LinkedList;

public class SinglyLinkedList<T> {

	/**
	 * 
	 * Head
	 * Tail
	 * Node
	 * 	Pointer
	 * 	Value
	 * 
	 * 
	 * 3 -> 6 -> 7 -> 12
	 */


	public SinglyNode<T> head, tail;
	private int size;

	public void add(T value) {
		if(head == null) head = tail = new SinglyNode(value);
		else {
			tail = tail.next = new SinglyNode(value);
		}
		size++;
	}

	public void remove(T value) {

		if(head.value == value) {
			if(head == tail) head = tail = null;
			else head = head.next;
			size--;
		}else {
			SinglyNode<T> tempNode = head;

			while(tempNode.next != null) {
				if(tempNode.next.value == value) {
					tempNode.next = tempNode.next.next;
					size--;
					break;
				}else
					tempNode = tempNode.next;
			}
		}
	}

	public void removeAll(T value) {

		if(head.value == value) {
			if(head == tail) head = tail = null;
			else head = head.next;
			size--;
		}

		SinglyNode<T> tempNode = head;

		while(tempNode.next != null) {
			if(tempNode.next.value == value) {
				tempNode.next = tempNode.next.next;
				size--;
			}else
				tempNode = tempNode.next;
		}
	}

	public T get(int index) {

		if(size < index) throw new IndexOutOfBoundsException();

		int i =0;
		SinglyNode<T> tempNode = head;

		while(tempNode != null) {
			if(i++ == index) {
				return (T) tempNode.value;
			}
			tempNode = tempNode.next;
		}

		return null;
	}


	public boolean contains(T value) {
		SinglyNode<T> tempNode = head;

		while(tempNode != null) {
			if(tempNode.value == value) {
				return true;
			}
			tempNode = tempNode.next;
		}

		return false;
	}


	public int indexOf(T value) {
		int index = 0;
		SinglyNode<T> tempNode = head;

		while(tempNode != null) {
			if(tempNode.value == value)
				return index;

			tempNode = tempNode.next;
			index++;
		}

		return -1;
	}


	public void insert(int index, T value) {
		if(index ==0) {
			head = new SinglyNode(value, head);
		}else if (index == size) {
			add(value);
		}else {
			int temp = 0;
			SinglyNode tempNode = head;

			while(tempNode != null) {
				if(temp+1==index) {
					tempNode.next = new SinglyNode(value, tempNode.next);
					return;
				}
				tempNode = tempNode.next;
				temp++;
			}
		}
	}


	public String toString() {
		if(size == 0) return "{}";
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		SinglyNode tempNode = head;

		while(tempNode != null) {
			builder.append(tempNode.value);
			builder.append(",");
			tempNode = tempNode.next;
		}

		builder.deleteCharAt(builder.length()-1);
		builder.append("}");
		return builder.toString();
	}
	
	public int size() {
		return size;
	}
	
	
	//Queue implementation - FIFO
	
	
	public void offer(T value) {
		add(value);
	}
	
	//poll == remove
	public T poll() {
		if(size == 0) throw new IndexOutOfBoundsException();
		
		T temp = head.value;
		
		head = head.next;
		size--;
		return temp;
	}



	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);

	}



	/*** Stack Implementation **/


	public void push(T val) {
		//		SinglyNode<T> node = new SinglyNode<T>(val);
		//		 node.next = head;
		//		 head = node;

		head = new SinglyNode<T>(val,head);
		size++;
	}

	public T pop() {
		if(size == 0) throw new IndexOutOfBoundsException();
		size--;
		T temp = head.value;
		head = head.next;
		return temp;
	}
	
	

	public T peek() {
		if(size == 0) throw new IndexOutOfBoundsException();
		return head.value;
	}

}


