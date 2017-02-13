package collectionSandboxProject;

import java.util.HashSet;

public class setCollectionSandbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet setSandbox = new HashSet();
		HashSet setTwo = new HashSet();
		HashSet setThree = new HashSet();
		
		//Happy Add NOTE: strings and numbers are both working here. No data type on this one.
		setSandbox.add("First");
		setSandbox.add("Second");
		setSandbox.add("Thrid");
		setSandbox.add("Fourth");
		setSandbox.add("Fifth");
		setSandbox.add(1);
		setSandbox.add(2);
		setSandbox.add(3);
		setSandbox.add(4);
		setSandbox.add(5);
		System.out.println(setSandbox.toString());
		
		
		try {
			setSandbox.add(null);// add null to set RESULT Added null to set.
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			setSandbox.add("\n\tTEsT");// add funky characters RESULT funkyness was added no error
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		setSandbox.remove("\n\tTEsT");
		try {
			setSandbox.add("First");// add duplicate to set RESULT its a set you cant add duplicates you idiot, what did you expect to happen.
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			setSandbox.add("");// add empty String to set RESULT Added empty string to set.
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		


		//Happy Remove
		
		setSandbox.remove("Fifth");
		setSandbox.remove(5);
		System.out.println(setSandbox.toString());
		
		
		//Nast Path Removes
		try {
			setSandbox.remove(null);// remove null from set RESULT "null" issue removing... 
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			setSandbox.remove("blah blah blah");// remove non existant value from set RESULT No issue and nothing changed.
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		try {
			setSandbox.remove("");// remove empty string RESULT OH MY GOSH THE EMPTY STRING VANISHED!!! WOW!
			System.out.println(setSandbox.toString());
			}catch(Exception e)
			{System.out.println("ERROR: "+e.getMessage());}
		
		
		// Blah blah blah, everything before this is the same old stuff. This is the important part. What makes sets so powerful in database and such 
		
		//lets add some data to set 2 and 3
		setTwo.add("D");
		setTwo.add("E");
		setTwo.add("F");
		setTwo.add("4");
		setTwo.add("5");
		setTwo.add("6");
		setTwo.add("C");
		setTwo.add("3");
		
		setThree.add("A");
		setThree.add("B");
		setThree.add("C");
		setThree.add("1");
		setThree.add("2");
		setThree.add("3");
		setThree.add("D");
		setThree.add("4");
		
		setThree.retainAll(setTwo); // This preformes an inner join. It will only retain the items that are the same in both sets. 
		System.out.println(setThree.toString()); 
		
		setTwo.add("D");
		setTwo.add("E");
		setTwo.add("F");
		setTwo.add("4");
		setTwo.add("5");
		setTwo.add("6");
		setTwo.add("C");
		setTwo.add("3");
		
		setThree.add("A");
		setThree.add("B");
		setThree.add("C");
		setThree.add("1");
		setThree.add("2");
		setThree.add("3");
		setThree.add("D");
		setThree.add("4");
		
		setThree.addAll(setTwo); // This would perform a full outer join, making the sets one set containing one copy of each value
		System.out.println(setThree.toString());
		
		setTwo.add("D");
		setTwo.add("E");
		setTwo.add("F");
		setTwo.add("4");
		setTwo.add("5");
		setTwo.add("6");
		setTwo.add("C");
		setTwo.add("3");
		
		setThree.add("A");
		setThree.add("B");
		setThree.add("C");
		setThree.add("1");
		setThree.add("2");
		setThree.add("3");
		setThree.add("D");
		setThree.add("4");
		
		HashSet setFour = new HashSet();
		setFour.add(setThree);
		System.out.println(setFour.toString());
		//= setThree.retainAll(setTwo);
		setThree.addAll(setTwo);
		setThree.removeAll(setFour); // left/right exchange This removes all matching values from the set (the matching valuse stay with settwo) allows you to seprate the data.
		System.out.println(setThree.toString());
		
	}

}
