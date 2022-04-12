package datastrucutresAndAlgorithms.ey.training.week2.day1;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicates {

	@Test
	public void td1() {
		removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
	}

	/*
	 * private void removeDuplicates_twoPointer(int[] input) { if(input.length ==1)
	 * return; int start=0, end = 1,counter =0;
	 * 
	 * while(end < input.length) { if(input[start]==input[end]) { counter++; end++;
	 * }else { input[++start] = input[end++]; } }
	 * System.out.println(Arrays.toString(input)+" -> "+(input.length-counter)); }
	 */
	public int removeDuplicates(int[] nums) {
		if(nums.length==0)
			return 0;
		int length=1,temp=nums[0];
		for(int i=1;i<nums.length;i++){
			if(temp!=nums[i]){
				temp=nums[i];
				nums[length]=nums[i];
				length++;
			}
		}
		return length;
	}

	public static int[] removeDuplicate(int[] a)
	{
		int first =0;
		int second= 1;
		int i=0;
		while(second<a.length-1)
		{
			if(a[first]!=a[second])
			{
				a[i]=a[first];
				a[i+1]=a[second];
				i++;
				first = second;
				second++;
			}
			else if(a[i]==a[second])
			{ 
				second++;
			}
		}
		return a;
	}

}
