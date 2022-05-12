package datastrucutresAndAlgorithms.ey.training.week6.day26;

public class LemonadeChange {

	public boolean lemonadeChange(int[] bills) {
		int[] change = new int[2];

		for(int each: bills){
			if(each == 5) change[0]++;
			else if(each == 10){
				if(change[0]==0) return false;
				change[1]++;
				change[0]--;
			}else{
				if(change[1]==0){
					if(change[0]<3) return false;
					change[0] -= 3;
				}else{
					change[1]--;
					if(change[0]==0) return false;
					change[0]--;
				}
			}
		}
		return true;
	}

}
