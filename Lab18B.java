//Lab 18B
//Macarthur Diby
//	A recursive method that accepts an array of integers and returns a true if each value in the array is equal to the previous value + 5.  Otherwise, it should return a false.



public class Main {
   
    
   public static boolean calcul(int arr[], int n)
        {
            if(n >= 1)
            {
                 if(( arr[n] - arr[n- 1]) ==5 )
                
                    {
                        return true && calcul(arr,n-1);
                    }
                else
                { 
                    return false;
                }
            }
           
            return true;
        }
    
   
    public static void main(String[] args) 
        {  
           // test cases
    int n = 6;
    int arr1[] = {5,10,15,20,30,35,50};//{2,4,8,16,32,64}; // array1
    int arr2[] = {10,15,20,25,35,40,60};//{2,4,5,16,3,60}; // array2
    int arr3[] = {0,5,10,15,25,30,70};//{8,16,32,64,128,256}; // array3
    System.out.println(calcul(arr1,n)); 
    System.out.println(calcul(arr2,n));
    System.out.println(calcul(arr3,n));
    
}

            
   
        }  
 
