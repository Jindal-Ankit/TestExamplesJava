package com.ankit.practice.problems;

public class MaxProfit {

	public static void main(String[] args) {
		int[] arr = { 18, 30, 26, 31, 35, 30, 29, 18 };
		simpleButSlow(arr);
		betterPerProfit(arr);
	}
	private static void simpleButSlow(int[] arr) {
		int maxProfit = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (maxProfit < arr[j] - arr[i]) {
					maxProfit = arr[j] - arr[i];
				}
			}
		}
		System.out.println("MaxProfit: " + maxProfit);
	}
	private static void betterPerProfit(int[] arr) {
		if (arr.length < 2) {
			System.out.println("Can not calculate profit");
			return;
		}
		int maxSellPrice = -1;
		int maxProfit = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i == arr.length - 1) {
				maxSellPrice = arr[i];
			}
			if(maxProfit < maxSellPrice - arr[i]){
				maxProfit = maxSellPrice - arr[i];
			}
			if (maxSellPrice < arr[i]) {
				maxSellPrice = arr[i];
			}
		}
		System.out.println("Max Profit : " + maxProfit);
	}
}
