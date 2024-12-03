//Macarthur Cammael Diby
//Lab 25A
//Program  that will create our own tree node class and use binary search . 


//TreeItem.java

//TreeItem class
import java.util.*;
import java.io.*;


class TreeItem
{
   int element; //the required element
   TreeItem left; // left variable
   TreeItem right; // right variable
  
   
   public TreeItem(int element)
   {
       this.element = element;
       left = null;
       right = null;
   }
  
   //return the value of the instance variable
   public int findElement()
   {
       return element;
   }
  
   // return string representation of the element
   public String toString()
   {
       if(left != null && right != null)
           return element + " - have 2 childrens whether left right\n";
       else if(left != null)
           return element + " - have 1  child on the left\n";
       else if(right != null)
           return element + " - have 1 child on the right\n";
       else
           return element + " - have no childrens\n";
   }
}




//BinarySearchTree.java

import java.util.*;
import java.io.*;

//class BinarySearchTree 
public class BinarySearchTree {
  
   private TreeItem root; // declare a variable type treeitem root 
  
   // a constructor  with no parameter putting root to null
   public BinarySearchTree()
   {
       root = null;
   }
  
   // BOOLEAN METHOD TO INSERT ELEMENT TO A BINARY TREE
   public boolean insertinteger(int element)
   { 
       if(root == null) 
           root = new TreeItem(element);
       else
       {
       	   // find the treeitem parents and the current one
       	   TreeItem parents = null;
           TreeItem current = root; 
           //while  loop to iterate through over the tree 
           while(current != null)
           {
           	   // verify the peresence of the element .
               if(current.findElement() == element) 
                   return false;
               else if(current.findElement() > element) {
                   parents = current;
                   current = current.left;
               }
               else {
                   parents = current;
                   current = current.right;
               }
           }
           
           if(element < parents.findElement())
           		parents.left = new TreeItem(element);
           	else
           		parents.right = new TreeItem(element);
       }
       
       return true; // true if the insertion is working
   }
  
   // BOOLEAN METHOD TO SEARCH SOME  VALUES IN THE TREE
   public boolean search(int element)
   {
       TreeItem current = root; // SET THE CURRENT TREE TO ROOT
      
       //while lopp to iterate through the tree to find the element
       while(current != null)
       {
       	   // if statement to find the differents elements in the right place
           if(current.findElement() == element) 
               return true;
           
           else if(current.findElement() > element) 
               current = current.left;
           
           else 
               current = current.right;
       }
       return false; 
   }
  
      
   //VOID METHOD THAT USE THE INORDER TRAVERSAL ALGORITHM
   private void inorder(TreeItem root)
   {
   		if(root!=null)
   		{
   			inorder(root.left);
   			System.out.print (root);
   			inorder(root.right);
   		}
   }
   
   
   public void inorder()
   {
   		inorder(root);
   		System.out.println ();
   }
}






//Main.java

import java.util.*;
import java.io.*;

class Main
{
   
   public static void main (String[] args) throws IOException
   {
   		//scanner to print the file
   		Scanner requiredfile = new Scanner(new File("Lab25A.txt"));
   		
   		
   		BinarySearchTree tree = new BinarySearchTree();
   		
   		//read the integers from the file and add to the tree 
   		while(requiredfile.hasNextInt())
   		{
   			//Read integer values from the text file
   			int element = requiredfile.nextInt();
   			//add each value to the tree
   			tree.insertinteger(element);
   		}
   		
   		requiredfile = new Scanner(System.in);
   		//ask user for an integer to search in the tree and verify its presence
   		System.out.print ("Enter an integer: ");
   		int key = requiredfile.nextInt();
   		
   		
   		if(tree.search(key))
   			System.out.println ("Tree Found");
   		else
   			System.out.println ("Tree Not Found");
   		
   		//Print the tree in inorder traversal
   		System.out.println ("Inorder traversal: ");
   		tree.inorder();
   }
}
