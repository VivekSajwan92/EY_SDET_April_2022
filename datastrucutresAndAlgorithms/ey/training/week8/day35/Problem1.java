package datastrucutresAndAlgorithms.ey.training.week8.day35;

import org.junit.Test;

public class Problem1 {

	
	/*
	 * @Test public void
	 */


	//recursive
	public int kthGrammar(int n, int k) {
		return recursive(n, 1, k, new int[]{0});
	}

	public int recursive(int n, int counter, int k, int[] arr) {
		if (counter == n)
			return arr[k - 1];

		int[] temp = new int[arr.length * 2];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) temp[i * 2 + 1] = 1;
			else temp[i * 2] = 1;
		}
		return recursive(n, counter + 1, k, temp);
	}
	
	
	/*
	 *  n = 4 , k = 5
	 *  
	 *  
	 *  1 -> 0
	 *  2 -> 01
	 *  3 -> 0110
	 *  4 -> 01101001 
	 *  5 -> 0110100110010110
	 *  
	 *  0 -> 1 -> 1 -> 1
	 *  1,1 -> 2,2 -> 3,3 -> 4,5
	 *  
	 *  
	 * 
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void test() {
		System.out.println(solve(4, 5));
		System.out.println(solve(5,4));
		System.out.println(solve(3, 1));
		System.out.println(solve(1, 1));
	}
	

	//efficient most	
	int solve(int n, int k){

		if(n == 1)
			return 0;

		int prev = solve(n - 1, (k + 1)/2);

		if( k % 2  == 0){
			return prev == 0 ? 1 : 0;
		} else {
			return prev == 0 ? 0 : 1;
		}

	}
}
