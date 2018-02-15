package com.ankit.practice.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MinSubArrayWithAllCharOfStr {

	public static void main(String[] args) {

		String sourceStr = "ABBBZCAZBBDEFBCGADBC";
		String subStr = "ABCDEFGI";
/*		int a = 'A';
		int z = 'Z';
		System.out.println(a + " " + z);
		
		*/
		System.out.println("SourceString  " + sourceStr + " \n" + subStr);
		int length  = findMinSubArr(sourceStr, subStr);
		System.out.println(length);
	}
	
	private static int findMinSubArr(String str, String sub){
		int length = 0;
		char[] sourceArr = str.toCharArray();
		Map<Character,Integer> matchedChars = new HashMap<Character,Integer>();
		String smallestSubStr = null;
		
		for(int i = 0 ; i < sourceArr.length; i++){
			
			int idx = sub.indexOf(sourceArr[i]);
			if(idx >=0)	{
				matchedChars.put(sourceArr[i], i);
				if(matchedChars.size() == sub.length()){
					smallestSubStr = findSubString(matchedChars , str);
					System.out.println(smallestSubStr);
					if(length == 0 || length > smallestSubStr.length()) length = smallestSubStr.length();
				}
			}
		}
		return length;
		
	}
	
	private static String findSubString(Map<Character, Integer> map , String sourceStr){
		int minIdx = 0;
		int maxIdx = 0;
		
		Iterator<Integer> values =  map.values().iterator();
		if(values.hasNext()) minIdx = maxIdx = values.next();
		while(values.hasNext()){
			int value = values.next();
			if(minIdx > value ) minIdx = value;
			else if(maxIdx < value) maxIdx = value;
		}
		return sourceStr.substring(minIdx, maxIdx+1);
	}

}
