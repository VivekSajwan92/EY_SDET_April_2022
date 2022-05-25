package datastrucutresAndAlgorithms.ey.training.week8.day35;

import datastrucutresAndAlgorithms.ey.training.week4.day15.Node;

public class Problem2 {

    Node<Integer> head1, temp;
    public Node<Integer> reverseList(Node<Integer> head) {
        recursive(head);
        return head1;
    }
/*
 * 1,2,3,4,5
 * 
 * 5,4,3,2,1
 * 
 * 
 * 
 *  
 */

    public void recursive(Node<Integer> node){
        if(node == null) return;
        recursive(node.next);
        if(head1 == null) head1 = temp = node;
        else temp = temp.next = node;
        temp.next = null;
    }
    
    
    
   
	public static void main(String[] args) {

        Node<Integer> head =null, temp=null;

        for (int each : new int[]{5,4,3,2,1}) {
            if(head ==null)
                head = temp = new Node<Integer>(each);
            else temp = temp.next = new Node<Integer>(each);
        }

        Node<Integer> a = new Problem2().reverseList(head);

        while(a != null){
            System.out.print(a.value+" ");
            a = a.next;
        }
    }
}
