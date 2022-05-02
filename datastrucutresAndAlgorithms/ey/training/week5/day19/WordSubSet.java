package datastrucutresAndAlgorithms.ey.training.week5.day19;

import java.util.ArrayList;
import java.util.List;

public class WordSubSet {
	public List<String> wordSubsets(String[] words1, String[] words2) {
		int[] arr2 = new int[26];
		List<String> list = new ArrayList<>();

		for(String eachString : words2){
			int[] temp = new int[26];
			for(char eachChar: eachString.toCharArray()){
				int currentChar = eachChar-'a';
				arr2[currentChar] = Math.max(arr2[currentChar], ++temp[currentChar]);
			}

		}

		for(String eachString : words1){
			int[] arr1 = new int[26];
			for(char eachChar: eachString.toCharArray()) arr1[eachChar-'a']++;
			boolean flag = true;
			for(int i =0; i < 26; i++){
				if(arr2[i]!=0){
					if(arr2[i] > arr1[i]){
						flag = false;
						break;
					}
				}
			}
			if(flag) list.add(eachString);
		}

		return list;
	}
}
