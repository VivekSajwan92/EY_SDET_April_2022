package datastrucutresAndAlgorithms.ey.training.week4.day14;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {
		int[] number = {1,2,3,4,5};
		int key = 1;
		addKey(number, (i,j) -> System.out.println(i+j), key);
	}
	
	public static void addKey(int arr[], BiConsumer<Integer, Integer> biConsumer, int key) {
		for(int i:arr) {
			biConsumer.accept(i, key);
		}
	}
	
}
