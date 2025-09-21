package arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

/*
 * TC: O(n) - Single pass through the array. SC: O(1) - Only two variables used.
 */

public class BestTimetoBuyandSellStock {
	public static void main(String[] args) {

		int[] arr = { 7, 1, 5, 3, 6, 4 };
		System.out.println(bestTimeToBuyAndSellStock(arr));

	}

	static int bestTimeToBuyAndSellStock(int[] arr) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 1; i < arr.length; i++) {
			minPrice = Math.min(arr[i], minPrice);
			maxProfit = Math.max(maxProfit, arr[i] - minPrice);
		}
		return maxProfit;
	}

}
