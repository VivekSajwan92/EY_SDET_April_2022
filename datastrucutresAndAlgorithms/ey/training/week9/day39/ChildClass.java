package datastrucutresAndAlgorithms.ey.training.week9.day39;

public class ChildClass extends ParentClass{
	String a = "from child class 1";

	public ChildClass(String a) {
		this.a = a;
	}
	
	
	public ChildClass() {
		System.out.println("this is child class 1 default constructor");
	}
}
