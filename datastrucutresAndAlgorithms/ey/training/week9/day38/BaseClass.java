package datastrucutresAndAlgorithms.ey.training.week9.day38;

public class BaseClass {

	/*
	 * Abstraction, polymorphism
	 * AbstractClass a = new ConcreteClass();


		a.m1();

		a = new ConcreteClass2();
		a.m1();
//		a.m2();
	 */
	public static void main(String[] args) {
		ChildClass2 ch2 = new ChildClass2();
		
		
		ch2.parent();
		ch2.child();
		ch2.elderChild();
		ch2.youngerChild();
		

		ChildClass ch1 = new ChildClass();
		
		
		ch1.parent();
		ch1.child();
		ch1.elderChild();
		
		//have no access to child class methods
		//ch1.youngerChild();
	}
}
