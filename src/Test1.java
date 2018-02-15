public class Test1 {
    
    public static int[] findMaximumNumber(int array[],int moves)
    {
        for(int i=0;i<array.length-moves;i++)        
        {
            int max = array[i];
            int maxindex = i;
            for(int j=i+1;j<i+moves+1;j++)
            {
            if(array[j]>max)
            {
             max = array[j];
             maxindex = j;
            }
            }
            if(array[i]<max)
            {
                int shift = maxindex;
                while(shift>i)
                {
                swap(array,shift,shift-1);
                shift--;
                moves--;
                }
                if(moves==0)
                {
                return array;
                }
                else
                {
                    if(moves>0)
                    	findMaximumNumber(array,moves);    
                 break;
                }
            }
        }
        return array;
        
    }
    
    public static void main(String[] args)
    {
        int array[] ={1,4,8,6,9,3,4};
        int moves = 3;
        findMaximumNumber(array,moves);
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
    
    public static void swap(int array[],int i,int j)
    {
        int moves =array[i];
        array[i]=array[j];array[j]=moves;
    }
}