
public class Solution1 {

	public static void main(String[] args) {
		int[] arr = {10,20,1,11,123};
		printnuber(arr, 4);

	}

	public static void printnuber(int[] arr, int k) {
		//int dashlength = getlengthofNbr(getmax(arr));
		int dashlength = String.valueOf(getmax(arr)).length();
		if (k > 0 && k <= arr.length) {
			printboundry(arr, dashlength, k);
			System.out.println();
			int start = 0;
			int count = 0;

			for (int loopnbr = 0; loopnbr < arr.length / k; loopnbr++) {
				start = k * loopnbr;
				printnbr(arr, dashlength, start, start + k);
				System.out.print("|");
				System.out.println();
				printboundry(arr, dashlength, k);
				System.out.println();
			}
			int remainder = arr.length - (arr.length / k) * k;
			if (remainder > 0) {
				start = start + k;
				// System.out.print(start + " remainder" + remainder);
				printnbr(arr, dashlength, start, start + remainder);
				System.out.print("|");
				System.out.println();
				printboundry(arr, dashlength, remainder);
				System.out.println();
			}
		} else {
			printboundry(arr, dashlength, arr.length);
			System.out.println();
			int start = 0;
			int count = 0;

			printnbr(arr, dashlength, start, arr.length);
			System.out.print("|");
			System.out.println();
			printboundry(arr, dashlength, arr.length);
			System.out.println();

		}

		/*
		 * System.out.print("|"); System.out.println();
		 * printboundry(arr,dashlength);
		 */

	}

	public static int getmax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

/*	public static int getlengthofNbr(int n) {
		int i = 1;
		while (n/10 > 0) {
			i++;
			n = n / 10;
		}
		if (n == 10) {
			i++;
		}
		return i;
	}*/

	public static void printboundry(int arr[], int dashlength, int k) {
		for (int i = 0; i < k; i++) {
			System.out.print("+");
			for (int j = 0; j < dashlength; j++) {
				System.out.print("-");
			}
		}
		System.out.print("+");
	}

	public static void printnbr(int arr[], int dashlength, int start, int k) {
		for (int i = start; i < k; i++) {
			System.out.print("|");
			for (int j = 0; j < (dashlength -  String.valueOf(arr[i]).length() /*getlengthofNbr(arr[i])*/); j++)
				System.out.print(" ");
			System.out.print(arr[i]);
		}
	}

}
