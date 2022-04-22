package datastrucutresAndAlgorithms.ey.training.week3.day13;

interface OneParam{
	int add(int a);
}


interface TwoParam{
	int add(int a, int b);
	default void sub() {
		System.out.println("Sub");
	}
	static void add2(){
		System.out.println("added");
	}
}



public class LambdaExamples {
	
	public int add(int a) {
		return 0;
	}

	public static void main(String[] args) {
		LambdaExamples lambdaExamples = new LambdaExamples();
		lambdaExamples.add(1);
		
		OneParam oneParam = a -> a+2;
		oneParam = a -> a/2;
		System.out.println(oneParam.add(10));
		
		TwoParam twoParam = (a, b) -> a+b;
		System.out.println(twoParam.add(5, 5));
		
		TwoParam safeDivide = (a,b) -> {
			if(b == 0) return 0;
			return a/b;
		};
		
		System.out.println(safeDivide.add(2, 2));
		TwoParam.add2();
		
	}
	
}
