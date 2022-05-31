package datastrucutresAndAlgorithms.ey.training.week9.day39;

import org.junit.Test;

public class ChildClass2 extends ChildClass{
	String a ="";


	public ChildClass2(String a) { 
		super(a);
		System.out.println("printing" + super.a);
		this.a = super.a; 
	}





	
	  @Test 
	  public void test() {
		  // print("this is from tets method"); //
	  System.out.println(new ChildClass2("this is from test method").a);
	  System.out.println(a);
	  }
	 


	public static void main(String[] args) { 
		ChildClass2 obj = new ChildClass2("this is from test method - 1");
		System.out.println(obj.a);
	}


	/*
	 * void print() {
	 * 
	 * //print global variable System.out.println(a);
	 * 
	 * //print super class same variable System.out.println(super.a);
	 * 
	 * }
	 * 
	 * 
	 * void print(String a) {
	 * 
	 * //print argument variable System.out.println(a);
	 * 
	 * //print super class same variable System.out.println(super.a);
	 * 
	 * //print class level variable System.out.println(this.a);
	 * 
	 * }
	 */

}
