package jsonSandbox;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONParser;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

public class jsonSandboxCode {
	public static void main(String[] args) throws JSONException, ParseException, java.text.ParseException, IOException{

		//Person object created from a class. The object can then be stringified
		person anInstance = new person("Steve", 7,new Date(1067899));
	   try {
		   System.out.println("JSON Stringify: ");
		   String jsonString = JSONUtilities.stringify(anInstance);//stringifies the object
		   System.out.println(jsonString);// prints the string
		   
		   //String jsonString = JSONUtilities.stringify(badInstance); if object is not serilizable it will not f
		   badPeople badInstance = new badPeople(null, 7,new Date(0));
		   jsonString = JSONUtilities.stringify(badInstance);// pass null to consturctor. Makes JSON just fine and the variable isn't written out.
		   System.out.println(jsonString);
	   }
	   catch (JSONException e) {
	   e.printStackTrace();
	   }
			   
			   
	   //URL url = new URL("http://localhost:8080/servletSandbox/theServlet");
	   //HttpURLConnection connection =(HttpURLConnection) url.openConnection();
	   //connection.setDoOutput(true);  

			   
	   // takes a raw string and creates an object from it.
	   System.out.println(" ");
	   try {
		   String jsonString = "{\"theString\":\"Hello there.\",\"theInt\":\"7\",\"theDate\":\"Wed Dec 31 17:17:47 MST 1969\"}";
		   
		   SimpleDateFormat aFormatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
		  
		   HashMap aMap = (HashMap)JSONUtilities.parse(jsonString);//parses the string into a hashmap
		   // passes the elements of the hash map into variables
		   String aString = (String) aMap.get("theString");
		   int anInt = Integer.parseInt((String)aMap.get("theInt"));
		   Date thisDate = new Date(1067899);
		   //passes the variables from teh string into the constuctor of the object.
		   person anotherInstance = new person(aString, anInt,thisDate );
		   anotherInstance.print();
		   
		   String jsonString2 = "{\"theInt\":88,\"theDate\":\"1969-12-31 17:00:00.0\"}";
		   HashMap bMap = (HashMap)JSONUtilities.parse(jsonString2);
		   String bString = (String) bMap.get("theString");
		  // int bInt = Integer.parseInt((String) bMap.get("theInt"));
		   //person anotherInstance2 = new person(bString, bInt,thisDate );
		   //anotherInstance2.print();
		  }
		  catch (JSONException e) {
		   e.printStackTrace();
		  }
	  
	   
	   
	   
	   
	   
	   
	   // Prints the object straight to a file. 
	   //RESULT prints out the string from the file
	   System.out.println(" ");
	   File aFile = new File("test.json");//creates a file
	   try {
	    FileOutputStream aFileStream = new FileOutputStream(aFile); //opens the file.
	    JSONOutputStream jsonOut = new JSONOutputStream(aFileStream); // creates the jsonout object
	    Serializable aSerializableObject;
		jsonOut.writeObject(anInstance);//writes the object
	    jsonOut.close();
	    System.out.println("File Output Finished.");
	   }
	   catch (Exception e) {
	    e.printStackTrace();
	   }
	   
	   // reads a json string in from a file and creates an object
	   try{
		   FileInputStream inputStream = new FileInputStream(aFile);// creates a new file input
		   JSONInputStream jsonIn = new JSONInputStream(inputStream);//creates jsoninputstream
		   Serializable aSerializableObject;
		   String hold = new String();// hold string
		   hold = jsonIn.readObject().toString(); //reads file to string, string can then be used create object
		   jsonIn.close();
		   System.out.println("\n"+hold);// prints out string.
		   System.out.println("Close input");
	   }
	   catch (Exception e) {
	    e.printStackTrace();
	   }
	   
	   
	   
	   
	// Trys to read in from an html document
	 //RESULT Error thown. Won't read past the first character of <
	   File bFile = new File("test.html");
	   System.out.println("done");
	   try{
		   FileInputStream inputStream = new FileInputStream(bFile);// try to read non json file
		   JSONInputStream jsonIn = new JSONInputStream(inputStream);//creates jsoninputstream
		   Serializable aSerializableObject;
		   String hold = new String();// hold string
		   hold = jsonIn.readObject().toString(); //reads file to string, string can then be used create object
		   jsonIn.close();
		   //System.out.println("\n"+hold);// prints out string.
		   //System.out.println("Close input");
	   }
	   catch (Exception e) {
	    e.printStackTrace();
	   }
	   
	   
	   
	   // reads a json string in from multi line file, reads past last item
	   //RESULT Error unexpected end of file! you can't read past the length of the objects in file, errors thrown
	   
	   File cFile = new File("test2.json");
	   System.out.println("done");
	   try{
		   FileInputStream inputStream = new FileInputStream(cFile);// try to read non json file
		   JSONInputStream jsonIn = new JSONInputStream(inputStream);//creates jsoninputstream
		   Serializable aSerializableObject;
		   String hold = new String();// hold string
		   hold = jsonIn.readObject().toString(); //reads file to string, string can then be used create object
		   hold += jsonIn.readObject().toString();
		   hold += jsonIn.readObject().toString();
		   jsonIn.close();
		   System.out.println("\n"+hold);// prints out string.
		   System.out.println("Close input");
	   }
	   catch (Exception e) {
	    e.printStackTrace();
	   }
	   
	}
}

