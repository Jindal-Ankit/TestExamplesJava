package com.ankit.practice.problems;

import java.util.Scanner;

public class SubArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int noOfTestCases = sc.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
		int inputlenght =  	sc.nextInt();
		int[] iArr = new int[inputlenght];
		for (int j = 0 ; j < inputlenght ; j++){
			iArr[j] = sc.nextInt();
		}
		int n = sc.nextInt();
		int maxSum = findMaxSumOfSubArr(iArr, n);
		System.out.println("\n" + maxSum);
		}

	}
	
	private static int[] convertStringToIntArr(String[] arr){
		int[] intArr = new int[arr.length];
		if (arr.length == 0) return null;
		else {
			for (int i = 0 ; i < arr.length ; i++) {
				intArr[i] = Integer.parseInt(arr[i]);
			}
		}
		return intArr;
	}
	
	private static int findMaxSumOfSubArr(int[] arr, int n){
		int maxSum = 0;
		
		for(int i = 0 ; i < arr.length; i++){
			int sumSubArray = 0;
			for(int j= i ; j < arr.length ; j++){
				sumSubArray += arr[j];
				if(sumSubArray >= n ){
					if (maxSum < (sumSubArray - arr[j])){
					maxSum = sumSubArray - arr[j];
					}
					break;
				}
			}
		}
		return maxSum;
	}
}
