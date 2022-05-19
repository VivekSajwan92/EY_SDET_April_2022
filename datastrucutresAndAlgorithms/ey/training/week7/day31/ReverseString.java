package datastrucutresAndAlgorithms.ey.training.week7.day31;

import org.junit.Test;

import java.util.Arrays;

public class ReverseString {

    @Test
    public void test() {
        char[] arr = "InputText".toCharArray();
        reverseString(arr);
        System.out.println(new String(arr));
    }

    public void reverseString(char[] s) {
        reverse(s,0);
    }

    static void reverse(char[] s,int i){
        int n=s.length;
        if(i>=n/2) return;
        swap(i,n-i-1,s);
        reverse(s,i+1);
    }

    static void swap(int s1,int s2,char[] s) {
        char temp=s[s1];
        s[s1]=s[s2];
        s[s2]=temp;
    }

}
