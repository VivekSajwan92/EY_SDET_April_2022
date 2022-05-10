package datastrucutresAndAlgorithms.ey.training.week6.day24;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class MaximumXOROperation {

	/*nums = [0,1,1,3], maximumBit = 2
	 * 
	 * output = [0, 3, 2, 3]
	 * 
	 * output = [k number with with if we does xor of the current xor value, will get maximum number]
	 * 
	 * 
	 * 
	 * 0 -> 00
	 * 1 -> 01
	 * 3 -> 11
	 * 
	 * 00 ^ 01 ^ 01 ^ 11  => 01^ 01 ^ 11 => 00 ^ 11 => 11 ^ k => 11  => k -> 11 ^ 11 => 0
	 * 
	 *  00 ^ 01 ^ 01   => 01^ 01  => 00 ^ k => 11 => k -> 00 ^ 11 => 11
	 *  
	 *  00 ^ 01   => 01 ^ k  => 11 => k -> 01 ^ 11 => 10
	 *  
	 *  00 ^ k => 11 => k -> 00 ^ 11 => 11
	 * 
	 */

	@Test
	public void test() {
//		System.out.println(Arrays.toString(getmaximumNumber_withQueueOrStack(new int[] {0,1,1,3}, 2)));
		System.out.println(Arrays.toString(getmaximumNumber(new int[] {2,3,4,7}, 3)));
		}

	
	//using array
	public int[] getmaximumNumber(int[] nums, int maxBit) {
		int[] out = new int[nums.length];
		int maxValue = (int)Math.pow(2, maxBit)-1, xor = nums[0];
		
		out[out.length-1]= maxValue^xor;

		for(int i =1; i< nums.length;i++) {
			xor ^=nums[i];
			out[out.length-i-1]= maxValue^xor;
		}

		return out;
	}

	public int[] getmaximumNumber_withQueueOrStack(int[] nums, int maxBit) {
		LinkedList<Integer> list = new LinkedList<Integer>();


		int maxValue = (int)Math.pow(2, maxBit)-1, xor = nums[0];
		list.add(xor);


		/*Stack implementation*/
		//		for(int i =1; i< nums.length;i++) {
		//			xor ^=nums[i];
		//			list.addFirst(xor);
		//		}
		//		
		//		for(int i=0; i<nums.length;i++) {
		//			nums[i] = maxValue ^ list.pop();
		//		}
		//		

		/*Queue implementation*/
		for(int i =1; i< nums.length;i++) {
			xor ^=nums[i];
			list.add(xor);
		}

		for(int i=0; i<nums.length;i++) {
			nums[nums.length-1-i] = maxValue ^ list.pop();
		}

		return nums;
	}

}
