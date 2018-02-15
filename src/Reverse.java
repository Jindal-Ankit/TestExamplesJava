
public class Reverse {
	
	public static void main(String[] args) {
		String str = "My,Name&isAnk.t";
		char[] arr = new char[str.length()];
		
		for(int i =0 ,j= str.length()-1; i < str.length(); i++){
			char ch = str.charAt(i);
			if(Character.isLetterOrDigit(ch)){
				if(Character.isLetterOrDigit(str.charAt(j))){
				arr[j] = ch;
				j--;
				}
				else{
					--j;
					arr[j] = ch;
					--j;
				}
			} else {
				arr[i] = ch;
			}
		}
		System.out.println(new String(arr));
	}
}
