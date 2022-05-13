package datastrucutresAndAlgorithms.ey.training.week6.day27;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem2 {
//	Given a list of integers sort it according to last digit of the number using comparator.
//	Convert it to lambda

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(399, 234, 432, 554, 801);
		Comparator<Integer> cmp1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 % 10 > o2 % 10) {
					return 1;
				} else if (o1 % 10 < o2 % 10) {
					return -1;
				}
				return 0;
			}
		};
		
		Comparator<Integer> cmp2 = (o1, o2) -> {
				if (o1 % 10 > o2 % 10) {
					return 1;
				} else if (o1 % 10 < o2 % 10) {
					return -1;
				}
				return 0;
		};
		
		Comparator<Integer> cmp3 = (o1,o2) -> (o1 % 10 < o2 % 10) ? -1 : ((o1 % 10 == o2 % 10) ? 0 : 1);
		
		

		Collections.sort(lst, cmp3);;
		System.out.println(lst);
	}

}
