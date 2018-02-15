import java.util.ArrayList;
import java.util.List;

public class GarbageCollectoinTest {
	public static void main(String[] args) {
		
		String str = "Count";
		List<String> ls = new ArrayList<String>();
		for(int i =0; i < 1000 ; i++){
			for(int j = 0 ; j< 1000; j++){
				String str1 = str + "::"+ j +" "+ i;
				ls.add(str1);
				//System.out.println(str1);
			}
		}
		
	}
	//1245 
	public static boolean isPalindrom(int number){
		Integer i = number;
		char[] array = i.toString().toCharArray();
		
		int k = 0;
		int j = 0;
		int length = array.length;
		int middle = length / 2;
		if(length %2 == 1){ 
			j = k = middle;
		} else  {
			j = middle - 1;
			k = middle;
		}
		
		for( ; j >=0 && k <= length ; j--,k++){
			arr[]
		}
		
	}
}
