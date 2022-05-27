package datastrucutresAndAlgorithms.ey.training.week8.Day37;

import org.junit.Test;

public class PeakElement {

	/*
	 * Given an integer array, find the peak element in it. A peak element is an element that is 
	 * greater than its neighbors. There might be multiple peak elements in an array,
	 * and the solution should report any peak element.
	 * 
	 * 
	 * {8, 9, 10, 12, 25, 6} -> 10
	 * 
	 * return -1, if no peak found
	 */


	@Test 
	public void test() {
//		System.out.println(findPeakElement(new int[] {8, 9, 10, 12, 25, 6}));
		System.out.println(findPeakElement(new int[] {1,2,13,4,5,6,7,8,12,13}));
	}

	public static int findPeakElement(int[] nums, int left, int right){
		// find the middle element. To avoid overflow, use mid = (high + low) / 2
		int mid = (left + right) / 2;

		// check if the middle element is greater than its neighbors
		if ((mid == 0 || nums[mid - 1] <= nums[mid]) &&
				(mid == nums.length - 1 || nums[mid + 1] <= nums[mid])) {
			return mid;
		}

		// If the left neighbor of `mid` is greater than the middle element,
		// find the peak recursively in the left subarray
		if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
			return findPeakElement(nums, left, mid - 1);
		}

		// If the right neighbor of `mid` is greater than the middle element,
		// find the peak recursively in the right subarray
		return findPeakElement(nums, mid + 1, right);
	}

	int findPeakElement(int[] nums) {
		if (nums.length == 0) return -1;

		return nums[findPeakElement(nums, 0, nums.length - 1)];
	}

}
