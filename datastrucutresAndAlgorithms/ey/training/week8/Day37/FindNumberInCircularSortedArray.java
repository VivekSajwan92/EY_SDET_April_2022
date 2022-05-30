package datastrucutresAndAlgorithms.ey.training.week8.Day37;

import org.junit.Test;

public class FindNumberInCircularSortedArray {

	@Test
	public void test() {
		System.out.println(searchCircularArray(new int[] {9,10,2,5,6,8}, 6, 0 , 5));
		//		System.out.println(searchCircularArray(new int[] {7,8, 9, 10, 2, 5, 6}, 10));
	}

	public static int searchCircularArray(int[] nums, int target){
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){

			int mid = (left + right) / 2;

			if (target == nums[mid]) return mid;

			if (nums[mid] <= nums[right]){
				if (target > nums[mid] && target <= nums[right]) left = mid + 1;
				else right = mid - 1;
			}
			else {
				if (target >= nums[left] && target < nums[mid]) right = mid - 1;
				else left = mid + 1;        
			}
		}
		return -1;
	}

	public static int searchCircularArray(int[] nums, int target, int left, int right){
		if(left > right) return -1;
		int mid = (left + right) / 2;

		if (target == nums[mid]) return mid;

		if (nums[mid] <= nums[right]){
			if (target > nums[mid] && target <= nums[right]) return searchCircularArray(nums, target, mid+1, right);
			else return searchCircularArray(nums, target, left, mid-1);
		}
		else {
			if (target >= nums[left] && target < nums[mid]) return searchCircularArray(nums, target, left, mid-1);
			else return searchCircularArray(nums, target, mid+1, right);       
		}
	}
}
