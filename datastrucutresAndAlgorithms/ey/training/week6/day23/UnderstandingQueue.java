package datastrucutresAndAlgorithms.ey.training.week6.day23;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import datastrucutresAndAlgorithms.ey.training.week3.day11.SinglyLinkedList;

public class UnderstandingQueue {
	
	
	private void queueUnderstanding(){
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		int[] input = {1,5};
		
		list.offer(input[0]);
		System.out.println(list.toString());
		
		list.poll();
		System.out.println(list.toString());
		
		list.add(input[1]);
		System.out.println(list.toString());
		
	}
	
	
	private void queueInterface() {
		Queue<Integer> queue = new LinkedList<Integer>();
	}
	
	@Test
	public void test() {
		queueUnderstanding();
	}


}
