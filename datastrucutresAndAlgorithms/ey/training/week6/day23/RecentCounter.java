package datastrucutresAndAlgorithms.ey.training.week6.day23;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
	Queue<Integer> recentRequests;
    public RecentCounter() {
        recentRequests = new LinkedList<Integer>();
    }

    public int ping(int t) {
        recentRequests.offer(t);
        while (recentRequests.peek() < t - 3000) {
            recentRequests.poll();
        }
        return recentRequests.size();
    }
    
}
