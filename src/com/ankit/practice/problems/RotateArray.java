package com.ankit.practice.problems;

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		leftRotate(arr, 2, arr.length);

		for (int i : arr) {
			System.out.print(i + ",");
		}
	}
	// 1,2,3,4,5
	
	private static void leftRotate(int[] arr, int d, int n){
		
		for(int idx = 0 ; idx < d; idx++){
			
				int overRideIdx = n-d+idx;
				int replaceIdx = d+idx;
				if(replaceIdx >= n){
					break;
				}
				int temp = arr[idx];
				arr[idx] = arr[replaceIdx];
				arr[replaceIdx] = arr[overRideIdx];
				arr[overRideIdx] = temp;
						
		}
	}

}
