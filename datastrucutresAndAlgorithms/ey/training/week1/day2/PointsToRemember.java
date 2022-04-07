package datastrucutresAndAlgorithms.ey.training.week1.day2;

import org.junit.Test;

public class PointsToRemember {

	public static void differentInputs() {
		int loop =0;
		for(int i=0; i< 4; i++) {
			for(int j = 0 ; j < 2 ;j++) {
				System.out.println(i +" "+j);
				loop++;
			}
		}
		
		System.out.println(loop);
		
	}
	
	public void dropingConstants() {
		
		// is array is sorted
		// adding the values
		
		int[] input = { 3,6,8,10};
		//o[1]
		
		//o[n]
		for(int i =1 ;i < input.length;i++) {
			if(input[i-1] > input[i])
				System.out.println("error");
		}
		int sum =0;  //o[1]
		
		
		//o[n]
		for(int i =0 ;i < input.length;i++) {
			sum+=input[i];
		}
		
		
		//O[N]+O[N] => O[2N] => O[N]
		System.out.println(sum);
		
	}
	
	/**
	 * 
	 * 
	 * 3 LOOPS -> 
	 * 
	 * LOOP1 
	 * 	LOOP2
	 * 		
	 * LOOP3
	 * 
	 * O[N^2] + O[N] + O[1] => O[N^2]
	 * 
	 * 
	 */
	
	@Test
	public void tc() {
		dropingConstants();
	}
	
}
