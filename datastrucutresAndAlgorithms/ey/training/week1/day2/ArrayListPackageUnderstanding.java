package datastrucutresAndAlgorithms.ey.training.week1.day2;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArrayListPackageUnderstanding {

	public void arrayListmethods() {
		ArrayList<Integer> al = new ArrayList<Integer>();


		al.add(10);
		al.add(10);
		al.add(10);
		al.add(19);
		al.add(10);
		al.add(10);
		al.add(19);

		System.out.println(al);


		System.out.println(" Index of "+al.indexOf(19));

		System.out.println(" Last Index of "+al.lastIndexOf(19));

		System.out.println("TO Array" +Arrays.toString(al.toArray()));


		//merger 2 collections
		ArrayList al1 = new ArrayList<Integer>();

		al1.add(40);
		al1.add(46);

		al.addAll(al1);

		System.out.println(" Merger Al and AL1 "+al);

		al.addAll(3,al1);

		System.out.println(" Merger Al and AL1 "+al);

		al.remove(4);

		System.out.println("remove 4th index "+ al);

		al.removeAll(al1);

		System.out.println("remove al1 "+ al);

		al.set(6, 22);

		System.out.println("setting 19 to 22"+al);


		ArrayList al3 = (ArrayList) al.clone();


		System.out.println(al +" "+al3);

		System.out.println(al.isEmpty());


		System.out.println("contains 19 "+al.contains(19));

		ArrayList al4 = al;
		System.out.println(al4);

		al.clear();

		System.out.println(al+" "+al3);


		System.out.println(al+" "+al4);
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
