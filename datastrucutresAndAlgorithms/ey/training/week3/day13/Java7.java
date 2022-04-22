package datastrucutresAndAlgorithms.ey.training.week3.day13;



interface Greeting{
	void perform();
}


//class Greet implements Greeting{
//
//	@Override
//	public void perform() {
//		System.out.println("Hello");
//		
//	}
//	
//}

public class Java7 {
	
	public void greet(Greeting greet) {
		greet.perform();
	}
	
	public static void main(String[] args) {
		Greeting greet = new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("perform");
				
			}
		};
		
//		Greeting greeting =  () -> System.out.println("an class");
//		greeting.perform();
		
		Java7 java = new Java7();
		java.greet(() -> System.out.println("an class"));
	}
	

}
