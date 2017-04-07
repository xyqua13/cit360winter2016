package finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;


import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONParser;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;
import org.quickconnectfamily.json.JSONUtilities.encoding;

public class loadSaveHandler implements Handler{

	@Override
	public HashMap<String, Object> handleIt(HashMap<String, Object> data) {
		HashMap<String, Object> theObj = new HashMap<String, Object>();
		String stringedId = (String) data.get("uid");
		File savedFile = new File("packageApp_"+stringedId+".json");
		HashMap hold = new HashMap();
		ArrayList aMap = new ArrayList();
		 try{
			   FileInputStream inputStream = new FileInputStream(savedFile);// creates a new file input
			   JSONInputStream jsonIn = new JSONInputStream(inputStream);//creates json input stream
			   hold = (HashMap) jsonIn.readObject(); //reads file to string, string can then be used create object
			   jsonIn.close();
			   
		 	}
		   catch (Exception e) {
		    e.printStackTrace();
		   }
		 
		 
		 //would loop through response if fully functional
		 String packageName="package";
		 theObj.put("uid", hold.get("uid"));
		 for(int i = 0; i<hold.size(); i++){
			 packageName ="package"+i;
			 if(hold.get(packageName)!=null){
				 HashMap aMapping =  (HashMap) hold.get(packageName);
				 singlePackage aPackage = new singlePackage();
				   aPackage.setId(((Long) aMapping.get("id")).intValue());
				   Date aDate = new Date(0);
				   aPackage.setArrivalDateTime(aDate);
				   aPackage.setCarrier((String) aMapping.get("carrier"));
				   aPackage.setDetails((String) aMapping.get("details"));
				   theObj.put(packageName,aPackage);
			 }
		 }
		   return theObj; //returns the entire package from the file.
	} 

}
