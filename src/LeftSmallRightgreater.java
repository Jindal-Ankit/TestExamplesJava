
public class LeftSmallRightgreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={ 2 , 4 , 6, 5, 8, 23};
		int n = arr.length -1 ;
		
		
	    int[] leftmax = new int[n];
	    int[] rightmax = new int[n];
	    int lmax = Integer.MIN_VALUE;
	    int rmax = Integer.MAX_VALUE;
	    
	    for(int i = 0;i<n;i++){
	        leftmax[i]=lmax;
	        rightmax[n-i-1]=rmax;
	        if(arr[i] > lmax)
	        lmax = arr[i];
	        if(arr[n-1-i]<rmax)
	        rmax = arr[n-1-i];
	    }
	     
	    for(int i = 0;i<n;i++){
	        if(arr[i] > leftmax[i]&&arr[i] < rightmax[i])
	        System.out.println(arr[i]);
	    }
	     
	}

}
