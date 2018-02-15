import java.util.HashSet;
import java.util.Set;

public class PatterFinder {

	public static void main(String[] args) {

		boolean patternFound = false;
		String source = "1872728723";
		String pattern = "123";
		
		char firstChar = pattern.charAt(0);
		Set<Character> set = new HashSet<Character>();
		int j = 0;
		for(int i = 0 ; i < source.length(); i++){
			if(j > pattern.length() -1 ) {
				patternFound = true;
				break;
			}
			else if(source.charAt(i) == firstChar){
				j = 1; 
				set.clear();
			} else if(set.contains(source.charAt(i))){
				j = 0;
				set.clear();
			} else if(source.charAt(i) == pattern.charAt(j)){
				set.add(pattern.charAt(j));
				j++;
			}
		}
		
		if(j == pattern.length()) patternFound = true;
		
		System.out.println("Pattern Found " + patternFound);
	}

}
