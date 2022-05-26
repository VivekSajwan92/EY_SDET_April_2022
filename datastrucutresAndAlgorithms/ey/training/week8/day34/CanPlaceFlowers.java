package datastrucutresAndAlgorithms.ey.training.week8.day34;

import org.junit.Test;

public class CanPlaceFlowers {

	//https://leetcode.com/problems/can-place-flowers/

	/*
	 * 
	 * 1,0,0,0,1   n =1 
	 * 
	 * 1,0,1,0,1 -> true
	 * 
	 * 
	 * 1,0,0,0,0,1 ;  n = 2
	 * 
	 * 1,0,0,0,0,1 ; n = 2 -> false
	 * 
	 * 0,0 
	 */
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
	
	@Test
	public void test() {
		System.out.println(canPlaceFlowers(new int[] {1,0,0,0,0,0,1}, 2));
	}
	
	

}
