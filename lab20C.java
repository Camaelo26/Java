import java.io.BufferedReader;

import java.io.FileReader;

import java.util.*;

class Main
{
  
public static void main (String arr[])
  {
    

      Deque < Orders > queue = new ArrayDeque < Orders > ();
    
String line;
    
try
    {
      
// read the apprpopriate  file 
	FileReader file = new FileReader ("Lab20C.txt");
      
	BufferedReader widg = new BufferedReader (file);
      
	while ((line = widg.readLine ()) != null)
	{
	  
	    String words[] = line.split (" ");
	  
//add orders to queue
	    queue.add (new Orders (words[0], Integer.parseInt (words[1])));
	
}
    
}
    
catch (Exception e)
    {
      
System.out.println (e);
    
}
    

      Main object = new Main ();
    
object.ordersprocess (45, queue);
  
}
  
 
void ordersprocess (int availableWidgets, Deque queue)
  {
    

      for (int i = 0; i <= queue.size (); i++)
      {
	

	  Orders order = (Orders) queue.peek ();
	

	  if (order.widgetsordered () <= availableWidgets)
	  {
	    
System.out.println (order.toString ());
	    
System.out.println ("Orders processed");
	    
availableWidgets -= order.widgetsordered ();
	    

	      queue.poll ();
	  
}
      
}
    
System.out.println ("Avaialable widgets left are " + availableWidgets);
    
System.out.println ("Remaining queue");
    
Iterator iter = queue.iterator ();
    
while (iter.hasNext ())
      
System.out.println (iter.next ().toString ());
  
}

}


class Orders
{
  
String customer;
  
int numberofwidgets;
  
Orders (String customer, int numberofwidgets)
  {
    
this.customer = customer;
    
this.numberofwidgets = numberofwidgets;
  
} 
int widgetsordered ()
  {
    
return this.numberofwidgets;
  
}
  
public String toString ()
  {
    
String receipt =
      " " + this.customer + " ordered " + this.numberofwidgets +
      " widgets";
    
return receipt;
  
}

}
