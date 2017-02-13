package collectionSandboxProject;

import java.util.ArrayList;

public class listCollectionSandbox {

	public static void main(String[] args) {
		ArrayList<String> sandboxList = new ArrayList<String>();
		
		//Happy Path Add
		sandboxList.add("First");
		sandboxList.add("Second");
		sandboxList.add("Third");
		sandboxList.add("Fourth");
		sandboxList.add("Fifth");
		System.out.println(sandboxList.toString());
		
		sandboxList.add("First");
		System.out.println(sandboxList.toString());
		
		
		//Nasty Path Add		
		try {
			sandboxList.add(null);//RESULT adds null to the list and prints
			System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			sandboxList.add("");// RESULTS adds empty string to array list
			System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			//sandboxLIst.add(12345);
			//System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		
		
		
		//Happy path remove
		sandboxList.remove(1);// Removes second item in array "second"
		System.out.println(sandboxList.toString());
		sandboxList.remove("First");// Removes only the first instance of "First"
		System.out.println(sandboxList.toString());
		
		
		//Nast Path Remove
		try {
			sandboxList.remove(null);//Tries to remove Null RESULT Removes Null 
			System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		try {
			sandboxList.remove(-1);//Treis to remove a negative number RESULT Throws an error
			System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		try {
			sandboxList.remove(500);//Remove a out of range index RESULT Error thrown
			System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		try {
			sandboxList.remove("Tenth");//Remove non existant value RESULT runs, nothing remove.
			System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		
		
		
		// Happy Path set (index and key)
		sandboxList.set(1, "Fidy"); // only works to replace existing index
		System.out.println(sandboxList.toString());
		
		//Nast Path Set
		try {
		sandboxList.set(51, "Fidy 1");// out of range RESULT Error Thrown
		System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		try {
		sandboxList.set(-1, "Fidy 1");// out of range RESULT Error Thrown
		System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		try {
		sandboxList.set(4, null);// null value RESULT works just fine
		System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		try {
		//sandboxList.set(null, "Fidy 1");// null index RESULT won't compile
		System.out.println(sandboxList.toString());
		}catch(Exception e)
		{System.out.println("ERROR: "+e.getMessage());}
		
		
		
		//Happy Path get
		System.out.println(sandboxList.get(2));
		// IN short the get fuctions in the same way as set, can't go out of range, can't do negative or null, Plus you can't do sting. Nothing crazy
	}

}
