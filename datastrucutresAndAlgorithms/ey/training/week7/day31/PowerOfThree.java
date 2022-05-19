package datastrucutresAndAlgorithms.ey.training.week7.day31;

import org.junit.Test;

public class PowerOfThree {

    @Test
    public void test(){
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(26));
        System.out.println(isPowerOfThree(81));
        System.out.println(isPowerOfThree(243));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(2));
    }
    public boolean isPowerOfThree(int n) {
        if( n <= 2){
            if(n ==1) return true;
            return false;
        }
        return recursion(1,n);
    }

    public boolean recursion(int n, int target){
        n *= 3;
        if(n==target) return true;
        else if( n > target) return false;
        else return recursion(n,target);
    }
}
