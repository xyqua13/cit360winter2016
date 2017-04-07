package finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;
public class addPackageHandler implements Handler{

	@Override
	public HashMap<String, Object> handleIt(HashMap<String, Object> data) {
		//Got a little carried away with the try catches in this section... oops.
		//this calls the server with an id that is passed in through the query paramaters
		
		StringBuilder result = new StringBuilder();
		//sets the URL for the connection
		URL urlItem = null;
		try {
			urlItem = new URL("http://localhost:8080/finalProject_BackEnd/finalProject_Servelet?uid="+data.get("uid")+"&cid="+data.get("carrier"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		 
		// creates a HTTP URL Connection
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) urlItem.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		//sets the connection type
		try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		
		//Creates Buffer Reader to receive request  
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String line;
		//reads response into a single string
		try {
			while ((line = reader.readLine()) != null) {//saves the return to a result string
			   result.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {//closes the reader
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String uid=(String) data.get("uid");
		data.clear();
		data.put("uid",uid);
		try{
			data = (HashMap)JSONUtilities.parse(result.toString());
		}catch (JSONException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
		data.putAll(data);
		return data;
	} 

}
