package datastrucutresAndAlgorithms.ey.training.week1.day2;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArrayListPackageUnderstanding {

	public void arrayListmethods() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(10);

		//printing the ArrayList which prints the values, which internally calls toString in 'AbstractCollection'
		System.out.println(arrayList);

		//indexOf - prints the index of the array, -1 if no index found
		System.out.println(" Index of "+arrayList.indexOf(19));

		//lastIndexOf - finds the last index of the array, -1 if no index found
		System.out.println(" Last Index of "+arrayList.lastIndexOf(19));

		//toArray - return Object array
		System.out.println("TO Array" +Arrays.toString(arrayList.toArray()));


		ArrayList arrayList_1 = new ArrayList<Integer>();

		//add - add element in the end of the array list
		arrayList_1.add(40);

		//add - add element in the specific index of the array list
		arrayList_1.add(0, 46);

		//addAll - add all the collection at end of the current array list
		arrayList.addAll(arrayList_1);

		//addAll - add all the collection at specific index of the current array list
		arrayList.addAll(3,arrayList_1);

		//remove - remove the value from the array
		arrayList.remove(4);

		// removeAll - remove all the element of the collection in the current array list 
		arrayList.removeAll(arrayList_1);

		//set - reassign the value of the specific index
		arrayList.set(6, 22);

		//clone - clone the current array list to new instance
		ArrayList al3 = (ArrayList) arrayList.clone();

		//isEmpty() - return is the array list is empty
		System.out.println(arrayList.isEmpty());

		// contains - check if the element present in the array list
		System.out.println("contains 19 "+arrayList.contains(19));

		//clear - clear the entire array
		arrayList.clear();
	}

	public void arrayListContainsOfObject() {

		ArrayList<EmployeeClass> employees = new ArrayList<EmployeeClass>();

		EmployeeClass kamal = new EmployeeClass("Kamal");

		employees.add(kamal);

		employees.add(new EmployeeClass("Muthu"));

		employees.add(new EmployeeClass("Sandhya"));

		System.out.println(employees.contains(new EmployeeClass("Kamal")));
		System.out.println(employees.contains(kamal));
	}


	@Test
	public void main() {
		arrayListmethods();
	}

}
