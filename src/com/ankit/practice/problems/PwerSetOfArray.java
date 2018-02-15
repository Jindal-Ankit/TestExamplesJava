package com.ankit.practice.problems;

public class PwerSetOfArray {

	// print pwer set of giver int array
	public static void main(String[] args) {
		int[] arr = { 12, 12, 13, 14 };
		powerSet(arr);
//0,1,2
//
		String str = "abc";// a,ab,abc,b,bc,c
	}

	// {}{}{}{}
	// 0000,0011
	private static void powerSet(int[] arr) {
		int totalSet = 1 << arr.length;
		for (int i = 0; i < totalSet; i++) {
			System.out.print("{");
			for (int j = 0; j < arr.length; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.print("}");
		}

	}

	private static void allSUbString(String str) {
		int length = str.length();

		for (int i = 0; i < str.length(); i++) {

		}
	}
}
