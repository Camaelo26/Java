//Macarthur Diby
//Lab 22c
// create a random 2D array and sort it

import java.util.Arrays;
import java.util.Random;

//Create a Main class
class Main
{
  
//Create method to sort a 2d array
  public static void Sortmyarray (int[][] arr){ 
 int[] arr1D = new int[20];
   
int a= 0;
   

  for (int i = 0; i < arr.length; i++){
    for (int j = 0; j < arr.length; j++){
        arr1D[a++] = arr[i][j];
    } 
} 
int small, ind, temp;
	 
int lenght = arr1D.length;
	 
//for loop to sort a 1D array
	 for (int i = 0; i <= lenght - 1; i++) 
	 {
	 small = arr1D[i]; 
        ind = i; 
        for (int x=i+1; x < lenght; x++) {
            
	 if (arr1D[x]<small) 
	     {
	     
            small = arr1D[x]; 
            ind = x; 
         }
	     
}
	     
temp = arr1D[i]; 
arr1D[i]=arr1D[ind]; 
arr1D[ind] = temp;
}
//copy elements of 1D array to back to 2D array
for(int i=0;i<4;i++)
{
for(int j=0;j<4;j++)
{
arr[i][j] = arr1D[(j*4)+i];
}
}
}
//driver function
public static void main(String[] args)
{
    
//Create an initilize 2D array
//int[][] arr = {{15, 25, 22, 23 }, { 33, 11, 10, 44},{
//17, 12, 19,77 }, {31, 21, 51, 47}} ;
int arr[][] = new int[4][4];
Random random = new Random();

for (int i = 0; i < arr.length; i++) {
 for (int j = 0; j < arr[i].length; j++) {
          arr[i][j] = random.nextInt(50);
         }
}

//print 2D array before sort
System.out.print (" array before sorting \n");
for (int i = 0; i < 4; i++) {
for (int j = 0; j < 4; j++) {
System.out.print(arr[i][j] +"");

}
System.out.println();
}
//call my sorting method to sort the array
Sortmyarray(arr);
//print sorted 2D array
System.out.print("\narray after sorting \n");
for (int i = 0; i < 4; i++) {
for (int j = 0; j < 4; j++) {
System.out.print(arr[j][i]+"");
}
System.out.println();
}
System.out.print("\ntime complexity is O(n^2) \n");
}
}