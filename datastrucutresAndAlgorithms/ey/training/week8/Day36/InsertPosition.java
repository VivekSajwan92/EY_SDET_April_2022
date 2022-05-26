package datastrucutresAndAlgorithms.ey.training.week8.Day36;

import java.util.Arrays;

import org.junit.Test;

public class InsertPosition {
	
	/*
	 * 1,3,5  ;  target = 2
	 * 
	 * which position target needs to be placed in the array. solved in O[logN]
	 */
	
	
	@Test
	public void test() {
		//1,3,5,6,7,8
		int[] input = {1,3,5,6,8};
		System.out.println(searchInsert_impl(input, 9));
	}
	
	
	public int searchInsert(int[] nums, int target) {
		int index = Arrays.binarySearch(nums, target);
		return index < 0 ? (index+1)*-1 : index;
	}
	
	public int searchInsert_impl(int[] nums, int target) {
		int l = 0, r = nums.length-1;
		
		while(l <= r) {
			int mid = (l+r)/2;
			if(nums[mid] < target) l = mid+1;
			else if(nums[mid] > target) r = mid-1;
			else return mid;
		}
		return l;
	}

}
