package datastrucutresAndAlgorithms.ey.training.week3.day13;

interface Phone{
	void call();
	default void message() {
		System.out.println("Messge sent");
	}
}


class AndriodPhone implements Phone{

	@Override
	public void call() {
		System.out.println("Calling");
		
	}
	
	@Override
	public void message() {
		System.out.println("Message Not sent");
		
	}
	
}

public class Backward {
	public static void main(String[] args) {
		AndriodPhone andriodPhone = new AndriodPhone();
		andriodPhone.call();
		andriodPhone.message();
	}
}
