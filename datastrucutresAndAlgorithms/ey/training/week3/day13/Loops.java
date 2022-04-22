package datastrucutresAndAlgorithms.ey.training.week3.day13;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Loops {

	
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,5);
		List<String> lststr = Arrays.asList("hi","Hello","welcome");
		
//		for(int i = 0; i<lst.size(); i++) {
//			System.out.println(lst.get(i));
//		}
//		
//		for(Integer i : lst) {
//			System.out.println(i);
//		}
		Consumer<Integer> consumer = (i)->System.out.println(i);
		Consumer<String> consumer2 = (i)->System.out.println(i);
		lst.forEach(consumer);
		lststr.forEach(consumer2);
		
	}
	
}
