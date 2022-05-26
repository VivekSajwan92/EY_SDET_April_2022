package datastrucutresAndAlgorithms.ey.training.week8.Day36;

import org.junit.Test;

public class AddingBinaryNumbers {

	/*
	 * 101 , 111 -> say the sum binary number
	 * 
	 * 5 + 7 => 12
	 * 
	 * result should be 1100
	 * 
	 * 
	 */


	@Test
	public void test() {
		System.out.println(addBinary("11", "11"));
	}
	/*
	 *  0+0 -> 0
	 *  1+0 -> 1
	 *  1+1 -> 0
	 *  
	 *  	11 -> 3
	 *  	11 -> 3
	 *     110 -> 6
	 */

    public String addBinary(String a, String b) {
        int aIndex = a.length()-1 , bIndex = b.length()-1, carryOver = 0;
        StringBuilder builder = new StringBuilder("");

        while(aIndex >= 0 && bIndex >= 0)
            carryOver = sum(Character.getNumericValue(a.charAt(aIndex--)) +Character.getNumericValue(b.charAt(bIndex--)) +carryOver, builder);

        while(aIndex >= 0)
            carryOver = sum(Character.getNumericValue(a.charAt(aIndex--)) +carryOver, builder);

        while(bIndex >= 0)
            carryOver = sum(Character.getNumericValue(b.charAt(bIndex--)) +carryOver, builder);

        if(carryOver == 1)  builder.append('1');

        return builder.reverse().toString();
    }

    private int sum(int sum, StringBuilder builder){
        if(sum == 0) {
            builder.append( '0');
            return 0;
        }else if( sum ==1){
            builder.append( '1');
            return 0;
        }else{
        	// sum is 2 or 3 carryover will be 1, but the the value to append on below conditions
            if(sum == 2)
                builder.append( '0');
            else {
                builder.append( '1');
            }
            return 1;
        }
    }
}
