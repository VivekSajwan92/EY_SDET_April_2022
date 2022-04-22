package datastrucutresAndAlgorithms.ey.training.week3.day13;

interface I {
	default void add() {
		System.out.println("From I");
	}
}

interface J {
	default void add() {
		System.out.println("From J");
	}
}

class A{
	public void add() {
		System.out.println("From Class");
	}
}

class D extends A implements I, J{

	
}


public class Ambiguity {

	public static void main(String[] args) {
		D d = new D();
		d.add();
	}
	
}
