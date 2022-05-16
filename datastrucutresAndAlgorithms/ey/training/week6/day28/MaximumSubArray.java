package datastrucutresAndAlgorithms.ey.training.week6.day28;

public class MaximumSubArray {
	
	public int maxSubArray(int[] nums) {
        return kadaneAlgorithm(nums);
    }
    
    private int kadaneAlgorithm(int[] input){
        
        if(input.length ==1) return input[0];
        
        int maximum = Integer.MIN_VALUE, currentMaximum = Integer.MIN_VALUE;
        
        
        for (int firstIndex =0 ;firstIndex < input.length;firstIndex++){
            
            if(currentMaximum < 0){
				currentMaximum = input[firstIndex];
			}else	currentMaximum += input[firstIndex];
			
			maximum = Math.max(maximum, currentMaximum); 
		}
        
        return maximum;
    }

}
