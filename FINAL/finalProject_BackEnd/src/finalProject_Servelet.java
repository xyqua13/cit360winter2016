

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.quickconnectfamily.json.JSONException;

@WebServlet("/finalProject_Servelet")
public class finalProject_Servelet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		servletRunnable packageRunnable;
		try {
			packageRunnable = new servletRunnable(request,response);
			executor.execute(packageRunnable);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
