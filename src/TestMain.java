
public class TestMain {
	public static void main(String[] arr) {
int count =0;
		while(true){
			if(count ==5) break;
			count++;
			System.out.println("count " + count);
		}
	}
	
	
	public static Object checkLoop(){
		int count = 0;
		
		while(true){
			if(count ==5) return null;
			System.out.println("Count " + count);
		}
	}
}
