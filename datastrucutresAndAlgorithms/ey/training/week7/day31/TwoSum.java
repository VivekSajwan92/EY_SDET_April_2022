package datastrucutresAndAlgorithms.ey.training.week7.day31;

import java.util.Arrays;

import org.junit.Test;

public class TwoSum {



	@Test
	public void test() {
		System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 26)));
	}
	
	public int[] twoSum(int[] nums, int target) {
		return rec(nums, target, 0, 1);
	}
	
	private int[] rec(int[] nums, int target, int start, int end) {
		if(end == nums.length)  return rec(nums, target, start+1, start+2);
		
		if(nums[start]+nums[end] == target) return new int[] {start,end};
		else return rec(nums,target, start, end+1);
	}

}
