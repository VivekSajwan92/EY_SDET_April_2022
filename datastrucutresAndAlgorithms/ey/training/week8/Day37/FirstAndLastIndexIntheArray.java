package datastrucutresAndAlgorithms.ey.training.week8.Day37;

import java.util.Arrays;

import org.junit.Test;

public class FirstAndLastIndexIntheArray {

	/*
	 *  {1,2,4,5,5,5,5,5,6,7} , 5
	 *  
	 *  3,7
	 *  
	 */
	@Test
	public void test() {
		System.out.println(Arrays.toString(searchRange(new int[] {1,2,4,5,5,5,5,5,6,7} , 5)));
		System.out.println(Arrays.toString(searchRange(new int[] {5,5,5,5,5} , 5)));
		System.out.println(Arrays.toString(searchRange(new int[] {5,5,6,7,8 } , 5)));
		System.out.println(Arrays.toString(searchRange(new int[] {1,2,4,6,7} , 5)));
	}

	public int[] searchRange(int[] nums, int target) {
		int left =0, right = nums.length-1;
		//apply binary search
		while(left<=right){
			int mid = (right+left)/2;
			if(nums[mid]==target){
				int start = mid, end = mid;
				///find min index
				while(start>0 && nums[start-1]==target) start--;

				//find max index
				while(end<nums.length-1 && nums[end+1]==target ) end++;

				return new int[]{start,end};
			}
			else if(nums[mid]<target) left = mid+1;
			else if(nums[mid]>target) right = mid-1;

		}
		return new int[]{-1,-1};
	}

}
