package datastrucutresAndAlgorithms.ey.training.week7.day31;

import org.junit.Test;

public class FibonacciSeries {


    @Test
    public void test(){
        System.out.println(getFibonacciValue(0));
        System.out.println(getFibonacciValue(1));
        System.out.println(getFibonacciValue(2));
        System.out.println(getFibonacciValue(3));
        System.out.println(getFibonacciValue(4));
        System.out.println(getFibonacciValue(5));
        System.out.println(getFibonacciValue(6));
        System.out.println(getFibonacciValue(7));
        System.out.println(getFibonacciValue(8));
    }

    public int getFibonacciValue(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else return fibonacci(2,n,0,1);
    }

    public int fibonacci(int n, int target, int val1, int val2){
        if(n == target) return val1+val2;
        return fibonacci(n+1,target,val2,val2+val1);
    }

}
