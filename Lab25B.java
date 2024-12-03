//Macarthur Camael Diby
//Lab 25B
// program that will create a BinarySearchTree tree of string values and use the methods to fill and print it.




class TreeItem {
	String element;
	TreeItem left;
	TreeItem right;

// constructor to receive integer and set variables to null
	public TreeItem(String element) {
		this.element = element;
		left = null;
		right = null;
	}

	public String findElement() {
		return element;
	}

	public String toString() {
		if (left != null && right != null)
			return element + " has both children  on either side" + left.element + " & " + right.element + " \n";
		else if (left != null)
			return element + " has only a left child " + left.element + " \n";
		else if (right != null)
			return element + " has only a right child " + right.element + "\n";
		else
			return element + " has no children \n";
	}
}




//BinarySearchTree.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;
//class BinarySearchTree 
class BinarySearchTree {

	private TreeItem root;  // declare a variable type treeitem root
	private int size; // declare a variable with integer type named size

    // a constructor  with no parameter putting root to null
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
    // BOOLEAN METHOD TO INSERT ELEMENT TO A BINARY TREE
	public boolean insertelement(String element) {
		if (root == null)
			root = new TreeItem(element);
		else {
    // while loop to iterate through the tree and find the the parents and the current
			TreeItem parents = null;
			TreeItem current = root;
			while (current != null) {
				if (current.findElement() == element)
					return false;
				else if (element.compareTo(current.findElement()) < 0) {
					parents = current;
					current = current.left;
				} else {
					parents = current;
					current = current.right;
				}
			}

			if (element.compareToIgnoreCase(parents.findElement()) < 0)
				parents.left = new TreeItem(element);
			else
				parents.right = new TreeItem(element);
		}
		this.size++;
		return true;
	}

// Look for the element insertelemented
	public boolean search(String element) {
		TreeItem current = root;

// while loop over the tree until element is found or end of a path is reached
		while (current != null) {
			if (current.findElement() == element)
				return true;
			else if (current.findElement().compareTo(element) > 0)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}

	private void inorder(TreeItem root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root);
			inorder(root.right);
		}
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	
	public int findSize() {
		return size;
	}

	public void postorder() {
		postorder(root);
	}

	protected void postorder(TreeItem root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.element);
	}

	public void preorder() {
		preorder(root);
	}

	
	protected void preorder(TreeItem root) {
		if (root == null)
			return;
		System.out.println(root.element);
		preorder(root.left);
		preorder(root.right);

	}

}



//Main.java

//Main class

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
	    
		BinarySearchTree tree = new BinarySearchTree();
		//read the required file
		String filename = "Lab25B.txt";
		File thefile = new File(filename);
		Scanner requiredfile = new Scanner(new FileReader(thefile));// scanner for the file

		String line;
		while (requiredfile.hasNextLine()) {
			line = requiredfile.nextLine();
			tree.insertelement(line);
			System.out.println("the Size of tree: " + tree.findSize());
		}
		System.out.println("\nINORDER TRAVERSAL  "); // print the inorder traversal
		tree.inorder();

		System.out.println("\nPOSTORDER TRAVERSAL ");// print the post order traversal
		tree.postorder();

		System.out.println("\nPREORDER TRAVERSAL ");// print the preorder traversal
		tree.preorder();
	}

}