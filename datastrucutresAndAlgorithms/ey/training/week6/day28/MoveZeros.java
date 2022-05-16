package datastrucutresAndAlgorithms.ey.training.week6.day28;

import java.util.Arrays;

import org.junit.Test;

public class MoveZeros {

	public int[] moveZeroes(int[] nums) {
		int numberOfZeros=0,index=0;

		//O[N]
		for(int eachChar : nums){
			if(eachChar==0)
				numberOfZeros++;
		}

		//O[N+M]
		if(numberOfZeros!=0){
			for(int i=0; i<nums.length+numberOfZeros; i++){
				if(i < nums.length){
					if(nums[i]!=0)
						nums[index++]=nums[i];
				}else
					nums[index++]=0;
			}
		}
		
		return nums;
	}


	public int[] moveZeroes_twoPointer(int[] nums) {
		int zeroPointer =0, nonZeroPointer =0;

		while(zeroPointer<nums.length && nonZeroPointer<nums.length){

			if(nums[zeroPointer]==0 && nums[nonZeroPointer]!=0){
				if(zeroPointer>nonZeroPointer){
					nonZeroPointer++;
				}else{               
					nums[zeroPointer++] = nums[nonZeroPointer];
					nums[nonZeroPointer] = 0;
					nonZeroPointer =  zeroPointer;
				}
			}else{
				if(nums[zeroPointer]!=0)
					zeroPointer++;

				if(nums[nonZeroPointer]==0)
					nonZeroPointer++;
			}

		}
		return nums;
	}
	
	@Test
	public void test() {
		System.out.println(Arrays.toString(moveZeroes(new int[] {0,1,0,3,12})));
		System.out.println(Arrays.toString(moveZeroes_twoPointer(new int[] {0,1,0,3,12})));
	}
}
