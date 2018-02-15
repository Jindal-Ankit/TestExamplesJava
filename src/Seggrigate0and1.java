
public class Seggrigate0and1 {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1 };

		
		for(int i =0, j = arr.length-1; i<j;){
			while(arr[i]== 0)i++;
			while(arr[j] == 1) j--;
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		for (int i : arr) {
			System.out.print(i+",");
		}
	}

}
