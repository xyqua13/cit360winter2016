package collectionSandboxProject;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class mapCollectionSandbox {
	public static void main(String[] args){
		//creates a new hash map. A hash map is like a key value pair
		Map<String, Integer> sandboxMap = new HashMap<String, Integer>();
		
		//Happy Path put (string, int)
		sandboxMap.put("First", 10); 
		sandboxMap.put("Second", 20);
		sandboxMap.put("Third", 30);
		System.out.println(sandboxMap.toString());
		
		//Nasty Path Put
		sandboxMap.put("First", 5); // works fine, replaces old first value with 5
		System.out.println(sandboxMap.toString());
		sandboxMap.put("", 10);
		System.out.println(sandboxMap.toString());
		try {
			//sandboxMap.put("Fourth", "Word UP"); Can't even compile string in int position
			//System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			sandboxMap.put("Fifth", null); //RESULT: Null set as value
			System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			sandboxMap.put(null, -999); //RESULT: Null set as key
			System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			//sandboxMap.put("Seventh", 9999999999999999999999999999); //RESULT: won't compile with large numbers
			//System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		
		
		
		
		//Happy Path Get
		System.out.println(sandboxMap.get("First"));
		
		//Nast Path Get
		try {
			System.out.println(sandboxMap.get(null));//RESULT: Grabs value with null
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			System.out.println(sandboxMap.get(""));//RESULT: Grabs value with empty string.
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		
		
		
		
		//Happy Remove Path
		sandboxMap.remove("Second");
		sandboxMap.remove("Thrid",30); //Result: Only removes if value equal value
		sandboxMap.remove("First",6);  // Result does not remove the mapping with first.
		System.out.println(sandboxMap.toString());
		
		//Nasty Remove
		try {
			sandboxMap.remove(null); //Result removes key with NULL Value
			System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			sandboxMap.remove("First",null); // RESULT Nothing removed no value of Null with that key
			System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		try {
			sandboxMap.remove(""); //Result removes key with empty string
			System.out.println(sandboxMap.toString());
		}catch(Exception e)
		{System.out.println(e.getMessage());}
		
		
		
		
		//Happy Contains Keys/Values
		System.out.println(sandboxMap.containsKey("First")); // Result returns true
		System.out.println(sandboxMap.containsValue(30)); // Result Returns true
		System.out.println(sandboxMap.containsKey("abc")); // RESULT returns false because no key
		System.out.println(sandboxMap.containsValue(78)); //RESULT Returns false because no value
	}
}
