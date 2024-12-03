//Lab 18D
//Macarthur Diby
//	A recursive method that will print an integer series.  Starting with n = 2, the method should print n2 / (n-1) for all values of n between 2 and 10.  The method cannot contain a loop.


	public class Main{
	     public  static void num(int n){
	        int number;
	        if(n>2 && n<10 )
	        {
	            return;
	        }
	        number = (n*n)/(n-1);
	        System.out.println(number);
	        
	    }
	    public static void main(String[] args) {
	        num(2);
	        num(3);
	        num(4);
	        num(5);
	        num(6);
	        num(7);
	        num(8);
	        num(15);
	    }
	    
	}
