import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getPackageRunnable {
	private String id;
	public getPackageRunnable (String in){id = in;}
	public String run() throws IOException{
		StringBuilder result = new StringBuilder();
		//url for get connection
		URL urlItem = new URL("http://localhost:8080/finalProject_BackEnd/finalProject_Servelet?id="+id);
		// creates a HTTP URL Connection
		HttpURLConnection connection = (HttpURLConnection) urlItem.openConnection();
		//Sets the method for the server connection
		System.out.println("doingGet");
		//sets the connection type
		connection.setRequestMethod("GET");
		//Creates Buffer Reader to receive request  
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		//reads response into a single string
		while ((line = reader.readLine()) != null) {
		   result.append(line);
		}
		reader.close();//closes response string
		return result.toString();//prints the result string
	}
}
