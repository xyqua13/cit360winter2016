package applicationControllerPattern;

import java.util.HashMap;

public class apController {
	public static void main(String[] args){
		ApplicationController controller = new ApplicationController();
		
		HashMap<String,Object> words= new HashMap<String,Object>();
		words.put("Number",500);
		funHandler funStuff = new funHandler();
		boringHandler boringStuff = new boringHandler();
		
		//Happy Maps
		controller.mapCommand("Test", funStuff);
		controller.mapCommand("boring", boringStuff);
		
		//Nasty map command
		controller.mapCommand(null, funStuff);// Map Command to null RESULT, mapped fine.
		controller.mapCommand("", boringStuff);//Map to empty string RESULT worked fine.
		
		//Happy Handle Request
		controller.handleRequest("Test", null);
		controller.handleRequest("boring", words);
		
		
		//Nasty Path
		controller.handleRequest(null, null);//call null command RESULT It worked.
		controller.handleRequest("", words); //call empty string RESULT worked fine.
		
	}
}
