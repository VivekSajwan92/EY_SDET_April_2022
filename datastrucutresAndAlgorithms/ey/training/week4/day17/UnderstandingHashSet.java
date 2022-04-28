package datastrucutresAndAlgorithms.ey.training.week4.day17;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class UnderstandingHashSet {

	@Test
	public void tes() {
		directHashMap(3);
		directHashMap(4);
		directHashMap(6);
		System.out.println(map.keySet());
		
		understandHS();
		System.out.println(set);
	}
	
	HashMap<Integer, Object> map = new HashMap<>();
	HashSet<Integer> set = new HashSet<>();

	public void understandHS() {

		set.add(3);
		set.add(4);
		set.add(6);




	}

	private void directHashMap(int key) {

		map.put(key, null);
	}
}
