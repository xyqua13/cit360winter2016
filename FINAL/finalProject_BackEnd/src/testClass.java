  import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class testClass {
	public static void main(String[] args){
		StringBuilder result = new StringBuilder();
		//url for get connection
		URL urlItem = null;
		try {
			urlItem = new URL("http://localhost:8080/finalProject_BackEnd/finalProject_Servelet?uid=99998&cid=123");
			System.out.println("done");
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
		//Sets the method for the server connection
		System.out.println("doingGet");
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
		try {
			while ((line = reader.readLine()) != null) {
			   result.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());
	}
}
