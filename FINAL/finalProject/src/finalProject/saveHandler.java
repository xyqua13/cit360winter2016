package finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;


public class saveHandler implements Handler{

	@Override
	public HashMap<String, Object> handleIt(HashMap<String, Object> data) {
		HashMap<String, Object> theObj = new HashMap<String, Object>();
		for(int i=0;i<data.size();i++){}
		String stringedId;
		stringedId=data.get("uid").toString();
		File savedFile = new File("packageApp_"+stringedId+".json");
		   try {
		    FileOutputStream aFileStream = new FileOutputStream(savedFile); //opens the file.
		    JSONOutputStream jsonOut = new JSONOutputStream(aFileStream); // creates the json out object
		    Serializable aSerializableObject;
			jsonOut.writeObject(data);//writes the object
		    jsonOut.close();
		   }
		
		
		
	   catch (Exception e) {
		   e.printStackTrace();
	   }
		return theObj;
	}
 
}
