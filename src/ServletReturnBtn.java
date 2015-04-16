/**
 * Name:			Derek O Brein
 * K-Num:			K00105572
 * Description:		Functionality for return button on query return page
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/return")
public class ServletReturnBtn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletReturnBtn() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//Redirection 
	    String site = new String("query.html");
	    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site); 
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
