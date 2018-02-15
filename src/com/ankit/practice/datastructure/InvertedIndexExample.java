package com.ankit.practice.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndexExample {

	public static void main(String[] args) {
		String[] words = {"","",""};
		String dirPath = "";
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		
		Map<String, Set<String>> invertedIdxMap = readFiles(dirPath, map);
		
		List<String> fileNames = searchDocument(words, invertedIdxMap); 
		
		for (String string : fileNames) {
			System.out.println();
		}
	}
	
	private static List<String> searchDocument(String[] words,Map<String, Set<String>> invertedIdxMap ){
		List<String> fileNames = null;
		
		for (String word : words) {
			Set<String> fileNamesSet = invertedIdxMap.get(word);
			Iterator<String > itr = fileNamesSet.iterator();
			while(itr.hasNext()){
				fileNames.add(itr.next());
			}
		}
		
		return fileNames;
	}
	private static Map<String, Set<String>> readFiles(String fileDirPath, Map<String, Set<String>> indexedMap){
		Map<String, Set<String>> invertedIndexedMap = indexedMap;
		BufferedReader br =  null;
		
		File dir = new File(fileDirPath);
		File[] files = null;
		if(dir.isDirectory()){
			files = dir.listFiles();
		}
		if(files != null && files.length >0 ){
			for (File file : files) {
				String fileName = file.getName();
				try {
					br = new BufferedReader(new FileReader(file));
					String line = br.readLine();
					while(line != null){
						line = br.readLine();
						
						String[] words = line.split(" ");
						for (String string : words) {
							if(invertedIndexedMap.containsKey(string)){
								Set<String> fileNames =  invertedIndexedMap.get(string);
								fileNames.add(fileName);
							} else {
								Set fileNames = new HashSet<String>();
								fileNames.add(fileName);
								invertedIndexedMap.put(string, fileNames);
							}
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		return invertedIndexedMap;
	}
}
