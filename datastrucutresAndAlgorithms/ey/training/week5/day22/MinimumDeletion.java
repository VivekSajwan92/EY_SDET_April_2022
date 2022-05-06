package datastrucutresAndAlgorithms.ey.training.week5.day22;

import org.junit.Test;

import java.util.Stack;

public class MinimumDeletion {
	
    @Test
    public void td1(){
        System.out.println(minimumDeletions("aababbab"));
    }

    public int minimumDeletions(String s) {
        int count = 0;
        Stack<Character> balance = new Stack<>();
        char c = ' ';
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(!balance.empty() && c == 'a'){
                balance.pop();
                count++;
            }else if(c == 'b')
                balance.push(c);
        }
        return count;
    }
}
