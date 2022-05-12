package datastrucutresAndAlgorithms.ey.training.week6.day26;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		char[] char1 = new char[256];
		char[] char2 = new char[256];

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		for(int i =0; i <sArr.length;i++){
			if(char1[sArr[i]] == '\u0000' && char2[tArr[i]] == '\u0000'){
				char1[sArr[i]] = tArr[i];
				char2[tArr[i]] = sArr[i];
			}else{
				if(!(char1[sArr[i]] == tArr[i] && char2[tArr[i]] == sArr[i]))
					return false;
			}
		}

		return true;
	}
}
