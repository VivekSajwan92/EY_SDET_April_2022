package datastrucutresAndAlgorithms.ey.training.week8.Day37;

import org.junit.Test;

public class SmallestMissingNumber {
	
	/*
	 * Given a sorted array of non-negative distinct integers,
	 * find the smallest missing non-negative element in it.
	 *  
	 *  
	 *  
	 *  0,1,3,4,5 -> 2
	 */
	
	@Test
	public void test() {
		System.out.println(findSmallestMissing(new int[] {0,1,3,5,7}));
		System.out.println(findSmallestMissing(new int[] {0,1,2,3,5,7}));
	}
	
	int findSmallestMissing(int[] nums) {
		//0th index is not zero return zero
		if(nums.length > 1 && nums[0] != 0) return 0;
		return findSmallestMissing(nums, 0, nums.length);
	}
	/*
	 * 0,1,3,4,5
	 * L = 0, R = 4, mid = 2
	 * 
	 * 0,1 -> l =0, r=1, mid =0
	 * 
	 * 1 -> l = 1 , r = 1 , mid = 1
	 * 
	 * l = 2, r = 1 -> smallest missing number is 2
	 * 
	 * 
	 * mid == nums[mid] -> consider right side subarray
	 * else consider left side subarray
	 */
	
	int findSmallestMissing(int[] nums, int left, int right) {
        // base condition
        if (left > right) return left;

        int mid = (right+left) / 2;

        // if the mid-index matches with its value, then the mismatch
        // lies on the right half
        if (nums[mid] == mid)
            return findSmallestMissing(nums, mid + 1, right);
        else
            // mismatch lies on the left half
            return findSmallestMissing(nums, left, mid - 1);
        
    }

}
