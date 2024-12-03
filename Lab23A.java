// Macarthur Camael Diby
//Lab 23A
// program to sorts arrays with fifferents sorting types and their time taking.

public class Main 
{
    public static void filllistwithrandomsarrays(Integer[] arrayscreated)    
    {
        for(int i=0; i< arrayscreated.length; i++)
        {
            // numbers between 0 and 500
            arrayscreated[i] = (int) (Math.random() *( 500) ); 
        }
    }
// Use the insertion sort to sort the first array
    public static void insertion_sort(Integer[] arrayscreated)
    {
        int i, key, j;

        for (i = 1; i < arrayscreated.length; i++)
        {
            key = arrayscreated[i];
            j = i - 1;
    
    

            while (j >= 0 && arrayscreated[j] > key)
            {
                arrayscreated[j + 1] = arrayscreated[j];
                j = j - 1;
            }

            arrayscreated[j + 1] = key;
        }

        System.out.print("arrays after insertion sort: \n");

        for(i=0; i< arrayscreated.length; i++)
            System.out.print(arrayscreated[i] + "  ");

        System.out.println();
    }

//	Bubble sort for the second array
    public static void bubble_sort(Integer[] arrayscreated)
    {
        int n = arrayscreated.length;

        for (int i = 0; i < n-1; i++)
        {
            
            for (int j = 0; j < n-i-1; j++)
            {
                if (arrayscreated[j] > arrayscreated[j+1])
                {
                    
                    int temp = arrayscreated[j];
                    arrayscreated[j] = arrayscreated[j+1];
                    arrayscreated[j+1] = temp;
                }
            }
        }


        System.out.print("arrays after bubble sort: ");
        for(int i=0; i< n; i++)
            System.out.print(arrayscreated[i] + "  ");

        System.out.println();
    }


//sorting with merge sort the last array
    
    private static void merge_sort(Integer[] arrayscreated, int lw, int mid, int high)
    {
        
        int x1 = mid - lw + 1;
        int x2 = high - mid;
 
 
        int X[] = new int[x1];
        int Z[] = new int[x2];
 
        
        for (int i = 0; i < x1; ++i)
            X[i] = arrayscreated[lw + i];


        for (int j = 0; j < x2; ++j)
            Z[j] = arrayscreated[mid + 1 + j];
 

        
        int i = 0, j = 0;
 
        
        int k = lw;
        

        
        while (i < x1 && j < x2) 
        {
            if (X[i] <= Z[j]) 
            {
                arrayscreated[k] = X[i];
                i++;
            }
            else 
            {
                arrayscreated[k] = Z[j];
                j++;
            }

            k++;
        }
 

        
        while (i < x1) 
        {
            arrayscreated[k] = X[i];
            i++;
            k++;
        }
 
        
        while (j < x2) 
        {
            arrayscreated[k] = Z[j];
            j++;
            k++;
        }
    }
 

    // recursion for merge sort
    private static void sort(Integer[] arrayscreated, int lw, int high)
    {
        if (lw < high) 
        {
            
            int mid =lw+ (high-lw)/2;
 
            
            sort(arrayscreated, lw, mid);
            sort(arrayscreated, mid + 1, high);
 
            
            merge_sort(arrayscreated, lw, mid, high);
        }
    }


    // MERGE SORT MAIN FUNCTION
    public static void merge_sort(Integer[] arrayscreated)
    {
        sort(arrayscreated, 0, arrayscreated.length-1);
    }


    public static void main(String args[])
    { //Create 3 arrayscreatedays of 200 integers and call the fill arrayscreateday method 3 times,
        Integer arrayscreated1[] = new Integer[200];
        Integer arrayscreated2[] = new Integer[200];
        Integer arrayscreated3[] = new Integer[200];

        System.out.println();

        //fill with data
        filllistwithrandomsarrays(arrayscreated1);
        filllistwithrandomsarrays(arrayscreated2);
        filllistwithrandomsarrays(arrayscreated3);


        long begin = System.nanoTime();
        insertion_sort(arrayscreated1);
        long end = System.nanoTime();

        System.out.println();
        System.out.println("INSERTION TIME: " + (end- begin) + " nanoseconds.\n");

        begin = System.nanoTime();
        bubble_sort(arrayscreated2);
        end = System.nanoTime();
        
        System.out.println();
        System.out.println("BUBBLE SORT TIME: " + (end- begin) + " nanoseconds.\n");

        begin = System.nanoTime();
        merge_sort(arrayscreated3);
        end = System.nanoTime();

        
        System.out.print("with the merge sort: \n");
        for(int i=0; i<200; i++)
            System.out.print( arrayscreated3[i] + "  ");

        System.out.println();

        System.out.println("MERGE SORT TIME:" + (end- begin) + " nanoseconds.");
    }
}




