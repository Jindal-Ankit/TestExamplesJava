package com.ankit.practice.problems;

public class AllPermutations {

	public static void main(String[] args) {

/*		double d = -9.0;
		System.out.println(Math.sqrt(d));
		
		int i,j =1,k;
		for (i=0; i< 5 ; i++){
			k = j++ + ++j;
			System.out.println(k);
		}
		*/
		
		try{
			int i =0;
			int y = 5/i;
			
		} catch (Exception e) {
			System.out.println("Exception");
		}/* catch (ArithmeticException e) {
			System.out.println("B");
		}*/
		
/*		System.out.println(0 & 1<<2);
		String str = "xyz";
		//x yz zy
		
		//x yz xy z --> xyz
		// x yz
		
		//y xz zy
		permutation(str);*/
	}
	
	public static void permutation(String str){
		perm("", str);
	}

	private static void perm(String h, String word){
		
		if(word.isEmpty()){
		System.out.println(h+word);
		} else {
			for(int i =0 ; i < word.length();i++){
				perm(h + word.charAt(i), word.substring(0, i) + word.substring(i+1));
			}
		}
	}
	
}
