package datastrucutresAndAlgorithms.ey.training.week4.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

public class UnderstandingHash {



	private void hashCodeUnderstanding() {
		System.out.println("a".hashCode());
		System.out.println(new Integer(0).hashCode());
		System.out.println(new Boolean(false).hashCode());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		System.out.println(list.hashCode());
		System.out.println(list.get(0).hashCode());
	}

	private void hashCalculation(String input) {

		/*
		 * Hashcode for entity
		 * for the hash value rightshift of 16
		 * xor of hash and 16 rightshift of Hash
		 */
		//		String input = "nataraaj";
		int hashcode = input.hashCode();

		//		System.out.println(hashcode);

		int rightShiftvalue = hashcode >>> 16;

		int hashReturn = hashcode ^ rightShiftvalue;

		System.out.println("input "+ input +" :"+hashReturn);
	}
	//2038197380

	/*
	 * 10 -> 1010
	 * 
	 * 10 >>> 1  -> 101    5
	 * 
	 * 10 >>> 2   -> 10    2
	 * 
	 * 
	 * 1010 ^  0111  -> 1101
	 * 
	 * 1010
	 * 0111
	 * 1101
	 * 
	 * 
	 */


	/*
	 *20
	 * 
	 * 10100
	 * 01111
	 * 00100
	 * 
	 * 
	 * 20 -> 4
	 * 
	 * 118
	 * 
	 * 1110110
	 * 0001111
	 * 0000110
	 * 
	 * 
	 */

	private void hashMapUnderstanding() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();


		map.put("Aa", 1);
		map.put("Aa", 2);	

	}


	private void hashMapMthods() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		map.put("nataraaj", 11);

		System.out.println(map);
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();

		map1.put("w", 1);
		map1.put("q", 1);
		map1.put("a", 1);

		map1.putAll(map);
		System.out.println(map1);

		for(Entry<String, Integer> entry : map1.entrySet())
			System.out.println(entry.getKey() +" : "+entry.getValue());

		System.out.println(map1.keySet());
		System.out.println(map1.values());

		System.out.println(map1.get("q"));

		//		int counter = 0;
		//		if(map1.containsKey("q"))
		//			counter = map1.get("q");
		//		System.out.println(counter);

		System.out.println(map1.getOrDefault("t", 0));

		System.out.println(map1.containsKey("q"));
		System.out.println(map1.containsValue(3));
		map1.remove("q", 1);
		System.out.println(map1);
		map1.remove("w");
		System.out.println(map1);
	}


	@Test
	public void main() {
		//		hashCodeUnderstanding();
		//		hashMapUnderstanding();
		hashMapMthods();
		//		hashCalculation("Aa");
		//		hashCalculation("BB");
	}

}
