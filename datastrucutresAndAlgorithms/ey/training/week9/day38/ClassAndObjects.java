package datastrucutresAndAlgorithms.ey.training.week9.day38;

import org.junit.Test;

public class ClassAndObjects {

	public ClassAndObjects() {
		System.out.println("this is default constructor");
	}

	/*
	 * ClassAndObjects(String name) { System.out.println("this is constructor :" +
	 * name); }
	 */
	// from main -> m2 ->m1
	static ClassAndObjects obj = new ClassAndObjects();

	@Test
	public void tets() {
		for(int i=0; i< 3;i++) 
			obj.m2();
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * ClassAndObjects obj = new ClassAndObjects(); obj.m1();
	 * 
	 * new ClassAndObjects("parameterized constructor").m1();
	 * 
	 * 
	 * for(int i=0; i< 3;i++) obj.m2(); }
	 */

	public void m1() {
		System.out.println("inside method");
	}

	public void m2() {
		obj.m1();
	}

}
