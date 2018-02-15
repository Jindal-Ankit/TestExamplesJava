import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.activation.FileTypeMap;

class Solution {
	Map<String, String> fileTypeMap = new HashMap<String,String>();
	Map<String, Integer> finalFileType_Size_Map = new HashMap<String, Integer>();
	List<String> list_FileName_Size = new ArrayList<String>();
	
	private void init(){
		fileTypeMap.put("mp3", "music");
		fileTypeMap.put("aac", "music");
		fileTypeMap.put("flac", "music");
		fileTypeMap.put("jpg", "image");
		fileTypeMap.put("bmp", "image");
		fileTypeMap.put("gif", "image");
		fileTypeMap.put("mp4", "movie");
		fileTypeMap.put("avi", "movie");
		fileTypeMap.put("mkv", "movie");
		
		finalFileType_Size_Map.put("music", 0);
		finalFileType_Size_Map.put("image", 0);
		finalFileType_Size_Map.put("movie", 0);
		finalFileType_Size_Map.put("other", 0);
		
	}
/*	public static void main(String[] args) {
		String s = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.jpg 100b";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}*/
	public String solution(String S) {
		init();
		String solution = null;
		// write your code in Java SE 8
		
		String[] filename_size = S.split(" ");
		String firstFileName = filename_size[0];
		
		
		for(int i = 1 ; i < filename_size.length ;i++){
			String filePlussize = filename_size[i];
			int firstIndex = filePlussize.indexOf('b');
			String fileSize = filePlussize.substring(0, firstIndex);
			int fileSizeInInt = Integer.parseInt(fileSize);
			
			String fileType = getFileType(firstFileName);
			int size = finalFileType_Size_Map.get(fileType);
			size = size + fileSizeInInt;
			
			finalFileType_Size_Map.put(fileType, size);
			
			String fileName = filePlussize.substring(firstIndex+1);
			firstFileName = fileName;
			//System.out.println(fileSize +" "+fileName);
		}
		solution = convertMapToString(finalFileType_Size_Map);
		return solution;
	}
	
	//private 
	//private List<S>
	private String getFileType(String fileName){
		String fileType = null;
		int extIndex = fileName.lastIndexOf('.');
		
		String fileExtn = fileName.substring(extIndex + 1);
		
		fileType = fileTypeMap.get(fileExtn);
		if(fileType == null) fileType = "other";
		//System.out.println(fileExtn);
		return fileType;
	}
    // music mp3,aac,flac
    // image jpg,bmp,gif
    //movie  mp4,avi,mkv
    //other etc..
	
	private String convertMapToString(Map<String, Integer> map ){
		StringBuilder sb = new StringBuilder();
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> itr = entrySet.iterator();
		for (Entry<String, Integer> entry : entrySet) {
			sb.append(entry.getKey() + " "+ entry.getValue()+"b\n");
		}
		
		return sb.toString();
	}
}