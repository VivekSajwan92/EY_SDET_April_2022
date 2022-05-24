package datastrucutresAndAlgorithms.ey.training.week8.day34;

public class CountNumberOfOne {
	
	
	/*
	 * 
	 *  number so ones in the array 
	 *  		 [0,0,0,0,1,1,1,1,1]
	 *  
	 *  
	 *  start, mid, end
	 *  
	 *  mid = start+end/2
	 *  
	 *  
	 *  1st recursive => countofOnes(arr, start, mid)
	 *  2nd recursive => countofOnes(arr, mid+1, end)
	 *  
	 *  
	 *  1. if the right is zero mean all the elements in the sub-array is zero, so return count as 0
	 *  2. if the left is one(first ele of the array), mean the whole subarray is one, so count is end-mid+1+1
	 * 
	 * 
	 * L1 => s =0,end = 8 , mid = (8+0)/2 = 4
	 * 			0,0,0,0,1    || 1,1,1,1
	 * 			s = 0, end = 4, mid =2  
	 * 			0,0 || 0,1 
	 * 			0  || 0 || 1
	 * 							start = 5, end = 8	=> length 8-5+1 => count as 4
	 * 
	 */
	
	//[NumberOfZeros, NumberOFOnes]
	
	public static void main(String[] args) {
		int[] arr = {0,0,0,0,1,1,1,1,1};
		System.out.println(recursive(arr, 0, arr.length-1));
		
		int[] arr1 = {1,1,1,1,1,1,1,1};
		System.out.println(recursive(arr1, 0, arr1.length-1));
		
		
		int[] arr2 = {0,0,0,0};
		System.out.println(recursive(arr2, 0, arr2.length-1));
	}
	
	
	static int recursive(int[] arr, int start, int end) {
		if(arr[end] == 0) return 0;
		if(arr[start] == 1) return end-start+1;
		
		
		int count = 0;
		
		count += recursive(arr, start, (start+end)/2);
		count += recursive(arr, (start+end)/2+1, end);
		
		return count;
	}

}
