package datastrucutresAndAlgorithms.ey.training.week8.day34;

import org.junit.Test;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {


	@Test
	public void test() {
//		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.print(maxProfit(new int[] {2,4,1}));	
	}

	public int maxProfit(int[] prices) {
		if(prices.length < 2 )
			return 0;

		int lowerValue = prices[0], higerValue =prices[1], pointer = 2,profit = higerValue < lowerValue ? 0 : higerValue-lowerValue;

		while(pointer< prices.length){
			lowerValue = Math.min(lowerValue, prices[pointer-1]);
			if(higerValue <= prices[pointer++] || profit < prices[pointer-1]-lowerValue){
				higerValue = prices[pointer-1];
				profit = higerValue-lowerValue;
			}
		}
		return profit;
	}
}
