package datastrucutresAndAlgorithms.ey.training.week3.day13;

@FunctionalInterface
interface Decide{
	boolean isOdd(int a);
	default void isEven() {
		System.out.println("Even");
	}
}


public class Temp {

	public static void main(String[] args) {
		Decide decide = (a) -> {
			if(a % 2 == 0) {
				return false;
			}
			return true;
		};
		
		
		System.out.println(decide.isOdd(7));
	}
	
}
