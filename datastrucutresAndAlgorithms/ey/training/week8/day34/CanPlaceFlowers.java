package datastrucutresAndAlgorithms.ey.training.week8.day34;

public class CanPlaceFlowers {

	//https://leetcode.com/problems/can-place-flowers/

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(flowerbed.length == 1){
			if(flowerbed[0] == 0) n--;
			return n < 1;
		}

		int pointer=2;
		if(flowerbed[0] ==0 && flowerbed[1] ==0){
			flowerbed[0] =1;
			n--;
		} 

		for(; pointer< flowerbed.length-1; pointer++){
			if(flowerbed[pointer-1] == 0 && flowerbed[pointer+1] == 0 && flowerbed[pointer] == 0) {
				flowerbed[pointer] =1;
				n--;				
			}
		}

		if(flowerbed[flowerbed.length-1] ==0 && flowerbed[flowerbed.length-2] ==0 && flowerbed.length > 2) n--;

		return n<1;
	}

}
