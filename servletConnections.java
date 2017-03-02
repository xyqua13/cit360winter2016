package servletCode;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

import org.omg.CORBA.NameValuePair;

import sun.net.www.http.HttpClient;

public class servletConnections {
   public static String getHTML(String urlInput, String type) throws Exception {
      StringBuilder result = new StringBuilder();
      
      //url for get connection
      URL urlItem = new URL(urlInput);
  	 
      // creates a HTTP URL Connection
      HttpURLConnection connection = (HttpURLConnection) urlItem.openConnection();
      
      // if the function is a get
      if(type == "get"){
	      //Sets the method for the server connection
    	  System.out.println("doingGet");
    	  
    	  //sets the conneciton type
	      connection.setRequestMethod("GET");
	    
	      //Creates Buffer Reader to recieve request  
	      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      String line;
	      //reads response into a single string
	      while ((line = reader.readLine()) != null) {
	         result.append(line);
	      }
	      reader.close();//closes response string
	      return result.toString();//prints the result string
      }
      else{
    	  System.out.println("doingPost");
    	  
    	  //sets server call type to post Everything else works similar to get. Extra paramaters can be sent.
    	  connection.setRequestMethod( "POST" );
    	  connection.setUseCaches( false );

    	  BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      String line;
	      while ((line = reader.readLine()) != null) {
	         result.append(line);
	      }
	      reader.close();
	      return result.toString();
      }
   }

  
   public static void main(String[] args) throws Exception
   {
	   // Calls the getHTML Function for both a get and a post
	   System.out.println(getHTML("http://localhost:8080/serveletSandbox/serveletClass?cid=test&more=blah","get"));
	   System.out.println(getHTML("http://localhost:8080/serveletSandbox/serveletClass?cid=tests2","post"));
   }
}
