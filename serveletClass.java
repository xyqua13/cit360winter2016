package servletCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wsdl.util.IOUtils;

@WebServlet("/serveletClass")
public class serveletClass extends HttpServlet {//creates the servelet class and extends the HTTPServlet
	private static final long serialVersionUID = 1L;
	private String qString;// creats a string to hold query parameters of the url
    public serveletClass() {
        //super();
    }
    //listens for any get calls to the server
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		//reads query strin paramaters into a string
		qString = request.getQueryString();
		if(qString == null){qString = "";}//checks for query strings
		String stringSearch = new String();
		stringSearch = "&";//breaks apart all query strings
		if(qString.contains(stringSearch)){//if on all query string paramaters
			String[] parts = qString.split("&");
			Map<String,String> query = new HashMap();
			
			for(int i = 0; i < parts.length;i++)
			{String[] hold = parts[i].split("="); query.put(hold[0],hold[1]);}
			
			if(query.get("cid")!=null){
				//String words = "CID "
				response.getWriter().append("CID = " + query.get("cid"));
			}
			
			if(query.get("more")!=null){
				response.getWriter().append("\nMore = " + query.get("more"));
			}
			
			else{//No query string paramaters
				response.getWriter().append("NO Query String");
				}
			}
		}catch(Exception e){System.out.println(e.getMessage());}
	}
	
	//listens for any post calls to the server Functions similar to the get 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			InputStream body = request.getInputStream();
			StringWriter writer = new StringWriter();
			String theString = writer.toString();
			request.getParameter("Authorization"); 
			
			
			response.getWriter().append(request.toString());
			if(request.getParameter("Authorization") != null){response.getWriter().append("Authorization");}
			response.getWriter().append(body.toString());
		}catch(Exception e){System.out.println(e.getMessage());}
	}

}
