import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONParser;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;
import org.quickconnectfamily.json.JSONUtilities.encoding;

public class servletRunnable implements Runnable{

	public servletRunnable(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
		String qString;// creates a string to hold query parameters of the url
		final long serialVersionUID = 1L;
		try{
			String resultString="";
			Map<String,String> query = new HashMap();
			String[] parts = null;
			boolean run = true;
			//Hibernate connection
			package_database_connection newPackage = new package_database_connection();
			qString = request.getQueryString();
			if(qString == null){qString = "";}//checks for query strings
			
			String stringSearch = new String();
			
			stringSearch = "&";//breaks apart all query strings breaks apart all query strings
			if(qString.contains(stringSearch)){//if on all query string paramaters
					parts = qString.split("&");
					for(int i = 0; i < parts.length;i++)
					{String[] hold = parts[i].split("="); query.put(hold[0],hold[1]);}
				}else if(qString!=""){
					String[] hold = qString.split("=");
					query.put("uid", hold[1]);
				}else{
					run=false;
				}
				if(1==1){
					//saves all strings
					//sets up the factory, session. 
					Configuration configuration = new Configuration();
					configuration.configure();
					SessionFactory sessionFactory = configuration.buildSessionFactory();
					Session session = sessionFactory.openSession();
					session.beginTransaction();

					if(query.size()==1){//getUserPackages
						Query data = session.createQuery("select count(*) from newPackage where id="+query.get("uid")+"");
						resultString = data.toString();
					}else if(query.size()==2){//getSinglePackage
						
					}else if (query.size()==3){//checkSinglePackage
						
					}else{//error out

					}
					//commits the transaciton
					session.getTransaction().commit();
					//closes the session
					session.close();
					//closes the factory
					sessionFactory.close();
					
					//newPackage = data;
					
						
				HashMap<String, Object> theObj = new HashMap<String, Object>();
				//returnes only this for test
				theObj.put("uid", 1234);
				String jsonString = JSONUtilities.stringify(theObj);
				//response.getWriter().append(jsonString);
				}else{
					response.getWriter().append("Call Falied");
				}
			}catch(IOException e){
					System.out.println(e.getMessage());
					response.getWriter().append(e.getMessage());
				}
			//response.getWriter().append("SERVER: ").append("RETURN");
		}
		public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	public void run() {
	}

}
