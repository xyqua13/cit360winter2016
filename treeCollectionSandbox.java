package collectionSandboxProject;

import java.util.TreeSet;

public class treeCollectionSandbox {

	public static void main(String[] args) {
		TreeSet<String> treeSandbox=new TreeSet<String>();  
		
		//Happy Path Add
		treeSandbox.add("First");
		treeSandbox.add("Second");
		treeSandbox.add("Thrid");
		treeSandbox.add("Fourth");
		treeSandbox.add("Fifth");
		System.out.println(treeSandbox.toString());//automatically sorted 
		
		//Nast Path Add
		try {
			treeSandbox.add(null);// null value added RESULT error thrown
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			treeSandbox.add("");// add empty string RESULT Works fine adds empty string
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			treeSandbox.add("First");// add duplicate value RESULT Since its a set nothing is added. 
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			treeSandbox.add("\n\t\n\tTEST");// escaped new line and tab characters RESULT string pushes and displays with new lines and tabs 
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		treeSandbox.remove("\n\t\n\tTEST");//removes the ugly messed up no good string. Sanatize your input for goodness sake
		
		
		
		//Happy path remove 
		treeSandbox.remove("First");
		System.out.println(treeSandbox.toString());
		
		// Nasty Path Remove
		try {
			treeSandbox.remove(null);// null value removed RESULT error thrown
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			treeSandbox.remove("");// remove empy string RESULT no error Removes empty string fine.
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			treeSandbox.remove("Twenty");// remove non existant string RESULT no error no change
			System.out.println(treeSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		
		
		
		//Happy random happy paths
		System.out.println(treeSandbox.contains("Second")); // returns true if found false if not
		System.out.println(treeSandbox.first()); // first element in tree
		System.out.println(treeSandbox.last()); // last element in tree
		
		
		//My tree section is short since it is merged with sets. I will cover sets in depth in their own section.
	}

}
