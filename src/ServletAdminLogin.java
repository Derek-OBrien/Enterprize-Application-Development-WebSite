/**
 * 	Name: 			Derek O Brien
 * 	K-Num: 			K00105572
 * 	Project: 		EAD Assignment
 * 	Description:	Create Connection with database when admin inputs login details on adminlogin.html
 */

import java.io.IOException;
//import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogIn")
public class ServletAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
    public ServletAdminLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//Get Username and password entered
		this.username = request.getParameter("username");
		this.password = request.getParameter("password");
		
		//If details Correct
		if(username.equals("admin") && password.equals("password")){
			
			//Make Connection Using UserName & Password 
			DBConnection DbCon = new DBConnection(username, password);    
			DbCon.getConnection();
	    	
	    	// Direct to query.html if login successful 
		    String site = new String("query.html");
		    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site); 	
		}
		
		else{//if details not correct reload login page
		    String site = new String("adminlogin.html");
		    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
