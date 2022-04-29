package datastrucutresAndAlgorithms.ey.training.week4.day18;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class Anagram {


	/*
	 * 
	 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

			An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

			Input: s = "anagram", t = "nagaram"
			Output: true

			Input: s = "rat", t = "car"
			Output: false
	 */

	@Test
	public void testcase() {
//		System.out.println(isAnagram_array("anagram", "nagaram"));
		System.out.println(isAnagram_array("anaGram", "nagAram"));
		System.out.println(isAnagram("anaGram", "naGaram"));
	}
	
//	@Test
//	public void testcase2() {
//		System.out.println(isAnagram_array("a", "n"));
//	}

	/*
	 * a-z
	 * 0-25
	 * 
	 * b-> 1
	 * 98-97
	 * b-a
	 */

	private boolean isAnagram(String s, String p) {

		if(s.length() != p.length()) return false;

		HashMap<Character, Integer> sMap = new HashMap<>();
		HashMap<Character, Integer> pMap = new HashMap<>();

		for( int i =0; i < s.length();i++) {

			//			if(sMap.containsKey(s.charAt(i))) {
			//				int currentCOunt = sMap.get(s.charAt(i));
			//				sMap.put(s.charAt(i), currentCOunt+1);
			//			}else sMap.put(s.charAt(i), 1);

			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
			pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
		}

		return sMap.equals(pMap);
	}


	private boolean isAnagram_array(String s, String p) {
		int[] sArr = new int[128];
		int[] pArr = new int[128];

		for( int i =0; i < s.length();i++) {
			sArr[s.charAt(i)]++;
			pArr[p.charAt(i)]++;
		}
		
//		int[] sArr = new int[26];
//		int[] pArr = new int[26];
//
//		for( int i =0; i < s.length();i++) {
//			sArr[s.charAt(i)-'a']++;
//			pArr[p.charAt(i)-'a']++;
//		}
		
//		System.out.println(Arrays.toString(sArr));
//		System.out.println(Arrays.toString(pArr));

		return Arrays.equals(sArr, pArr);	 
	}

}
