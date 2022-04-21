package datastrucutresAndAlgorithms.ey.training.week3.day12;

public class UnderstandingDoublyLinkedList {


	public static void main(String[] args) {

		int[] input = {1,2,-13,54,25};

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

		for(int each : input) dll.add(each);

		
		  System.out.println(dll.toString());
		  System.out.println(dll.reverseToString());
		  
		  System.out.println(dll.indexOf(-13)); System.out.println(dll.contains(-1));
		 
		  System.out.println(dll.get(4));
		 



		dll.insert(0,70);
		dll.insert(dll.size(),80);
		dll.insert(2,90);
		
		System.out.println(dll.toString());

	}

}
