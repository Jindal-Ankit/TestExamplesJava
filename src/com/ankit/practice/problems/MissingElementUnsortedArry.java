package com.ankit.practice.problems;

public class MissingElementUnsortedArry {

	public static void main(String[] args) {

		int[] arr = { 21, 6, 3, 9, 12, 18 };
		try {
			System.out.println(missingElem(arr) +" \n "+ missigElemMiddile(arr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int missingElem(int[] arr) {
		int element = 0;
		int first, second, third = 0;
		first = second = third = arr[0];
		int orgSum = 0;
		for (int i = 1; i < arr.length; i++) {
			orgSum += arr[i];
			if (first > arr[i]) {
				second = first;
				first = arr[i];
			} else if (arr[i] > first && arr[i] < second) {
				third = second;
				second = arr[i];
			} else if(arr[i] > second && arr[i] < third){
				third = arr[i];
			}
		}
		if(second-first == third-second){
			int diff = second - first;
			System.out.println("diif" + diff);
			int sum = (arr.length)/2*(2*first + (arr.length-1)*diff);
			element = sum - orgSum;
		}
		System.out.println(first + " " + second + " " + third);

		return element;
	}
	
	private static int missigElemMiddile(int[] arr) throws Exception{
		int element = 0;
		if(arr == null || arr.length == 0) throw new Exception("No data in array");
		if(arr.length == 1 ) return arr[0]+1;

		// finding min an max element i.e. first and last element of AP
		int max = arr[0];
		int min = arr[0];
		int orgSum = 0;
		for(int i = 0 ; i < arr.length; i++){
			orgSum += arr[i];
			if(arr[i] < min){
				min = arr[i];
			} else if(arr[i] > max){
				max = arr[i];
			}
		}
		// sum if first and last element are not missing
		System.out.println(min +" " + max);
		int sum = (arr.length+1)*(min + max)/2;
		
		return sum - orgSum;
	}

}
