/**
 * 	Name: 			Derek O Brien
 * 	K-Num: 			K00105572
 * 	Project: 		EAD Assignment
 * 	Description:	Servlet to provide functionality to connect to database and pull information back to display on screen
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query")
public class ServletQueryDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection conn = null;
	private Statement stmt;
	private ResultSet result1;
	private String search;

    public ServletQueryDB() {
        super();
    }
    
    public void init() throws ServletException{
    	//Make Connection With DataBase
    	DBConnection DbCon = new DBConnection();    	
    	conn = DbCon.getConnection();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Value entered in Search bar
		this.search = request.getParameter("searchbox");

		try{
		stmt = conn.createStatement();
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<title>Query Return</title>"
				+ "<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">"
				+ "</head>"
				+ "<body>"
				+ "<section class=\"container\">"
				+ "<section class=\"content\">");
		
		//Create Return Button
		out.print("<form action=\"return\" method=\"GET\" class=\"form\">"
				+ "<input type=\"submit\" value=\"Return\" >"
				+ "</form>");
	 
	    //Display Single Register Table Only
		if (search.equals("Single") || search.equals("single")){
			result1 = stmt.executeQuery("SELECT * FROM SingleRegister ORDER BY 'email' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Single Entry<h4></caption>"
					+ "<tr>"
					+ "<th>First name </th>"
					+ "<th> Last Name </th>"
					+ "<th> Email </th>"
					+ "</tr>");
			
			while (result1.next() != false){
				out.print("<tr>" 
						+"<td>" + result1.getString("firstname") + "</td>"
						+"<td>" + result1.getString("lastname") + "</td> " 
						+"<td>" + result1.getString("email") + "</td>"
						+ "</tr>");
			}
			out.print("</table>");
		}
		
		//Display Group Register Table Only
		if (search.equals("Group") || search.equals("group")){
			result1 = stmt.executeQuery("SELECT * FROM GroupRegister ORDER BY 'groupemail' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Group Entry<h4></caption>"
					+ "<tr>"
					+ "<th>Group Name</th>"
					+ "<th>Number</th>"
					+ "<th>Supervisor</th>"
					+ "<th>Email</th>"
					+ "</tr>");
			
			while (result1.next() != false){
				out.print("<tr>"
						+ "<td>" +result1.getString("groupname") + "</td>"
						+ "<td>" + result1.getString("number") + "</td>"
						+ "<td> " + result1.getString("supervisor") + "</td>"
						+ "<td> " + result1.getString("groupemail") + "</td>"
						+ "</tr>");
			}
			out.print("</table>");
		}
		
		//Display Compete Register Table Only
		if (search.equals("Compete") || search.equals("compete")){
			result1 = stmt.executeQuery("SELECT * FROM compete ORDER BY 'competition' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Compete Entry<h4></caption> "
					+ "<tr>"
					+ "<th>Competition Code</th>"
					+ "<th>Team Name</th>"
					+ "<th>Mentor Name</th>"
					+ "<th>College</th>"
					+ "<th>Team Member 1</th>"
					+ "<th>Team Member 2</th>"
					+ "<th>Team Member 3</th>"
					+ "<th>Email</th>"
					+ "</tr>");		
			
				while (result1.next() != false){
					out.print("<tr>"
							+ "<td>" + result1.getString("competition") + "</td>"
							+ "<td>" + result1.getString("teamname") + "</td>"
							+ "<td>" + result1.getString("mentor") + "</td>"
							+ "<td>" + result1.getString("college") + "</td>"
							+ "<td>" + result1.getString("memberone") + "</td>"
							+ "<td>" + result1.getString("membertwo") + "</td>"
							+ "<td>" + result1.getString("memberthree") + "</td>"
							+ "<td>" + result1.getString("teamemail") + "</td>"
							+ "</tr>");
				}
			out.print("</table>");
		}

		//Display Robocode entries
		if (search.equals("robocode") || search.equals("Robocode")){
			result1 = stmt.executeQuery("SELECT * FROM compete WHERE competition = 1 ORDER BY 'teamemail' DESC");
			out.print("<table border=\"1\">"
					+ "<caption> <h4>Game Studio Ireland Entry<h4></caption>"
					+ "<tr>"
					+ "<th>Competition Code</th>"
					+ "<th>Team Name</th>"
					+ "<th>Mentor Name</th>"
					+ "<th>College</th>"
					+ "<th>Team Member 1</th>"
					+"<th>Team Member 2</th>"
					+ "<th>Team Member 3</th>"
					+ "<th>Email</th>"
					+ "</tr>");
			
				while (result1.next() != false){
					out.print("<tr>"
							+ "<td>" + result1.getString("competition") + "</td>"
							+ "<td>" + result1.getString("teamname") + "</td>"
							+ "<td>" + result1.getString("mentor") + "</td>"
							+ "<td>" + result1.getString("college") + "</td>"
							+ "<td>" + result1.getString("memberone") + "</td>"
							+ "<td>" + result1.getString("membertwo") + "</td>"
							+ "<td>" + result1.getString("memberthree") + "</td>"
							+ "<td>" + result1.getString("teamemail") + "</td>"
							+ "</tr>");
				}				
			out.print("</table>");
		}
		//Display Direct X entries
		if (search.equals("directx") || search.equals("DirectX")){
			result1 = stmt.executeQuery("SELECT * FROM compete WHERE competition = 2 ORDER BY 'teamemail' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Game Studio Ireland Entry<h4></caption>"
					+ "<tr>"
					+ "<th>Competition Code</th>"
					+ "<th>Team Name</th>"
					+ "<th>Mentor Name</th>"
					+ "<th>College</th>"
					+ "<th>Team Member 1</th>"
					+"<th>Team Member 2</th>"
					+ "<th>Team Member 3</th>"
					+ "<th>Email</th>"
					+ "</tr>");
			
				while (result1.next() != false){
					out.print("<tr>"
							+ "<td>" + result1.getString("competition") + "</td>"
							+ "<td>" + result1.getString("teamname") + "</td>"
							+ "<td>" + result1.getString("mentor") + "</td>"
							+ "<td>" + result1.getString("college") + "</td>"
							+ "<td>" + result1.getString("memberone") + "</td>"
							+ "<td>" + result1.getString("membertwo") + "</td>"
							+ "<td>" + result1.getString("memberthree") + "</td>"
							+ "<td>" + result1.getString("teamemail") + "</td>"
							+ "</tr>");
				}				
			out.print("</table>");
		}
		//Display GameStudioIreland entries
		if (search.equals("game studio ireland") || search.equals("Game Studio Ireland")){
			result1 = stmt.executeQuery("SELECT * FROM compete WHERE competition = 3 ORDER BY 'teamemail' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Game Studio Ireland Entry<h4></caption>"
					+ "<tr>"
					+ "<th>Competition Code</th>"
					+ "<th>Team Name</th>"
					+ "<th>Mentor Name</th>"
					+ "<th>College</th>"
					+ "<th>Team Member 1</th>"
					+"<th>Team Member 2</th>"
					+ "<th>Team Member 3</th>"
					+ "<th>Email</th>"
					+ "</tr>");
			
				while (result1.next() != false){
					out.print("<tr>"
							+ "<td>" + result1.getString("competition") + "</td>"
							+ "<td>" + result1.getString("teamname") + "</td>"
							+ "<td>" + result1.getString("mentor") + "</td>"
							+ "<td>" + result1.getString("college") + "</td>"
							+ "<td>" + result1.getString("memberone") + "</td>"
							+ "<td>" + result1.getString("membertwo") + "</td>"
							+ "<td>" + result1.getString("memberthree") + "</td>"
							+ "<td>" + result1.getString("teamemail") + "</td>"
							+ "</tr>");
				}				
			out.print("</table>");
		}
	/*
	 * Display All Tables 
	 */
		if (search.equals("")){

			result1 = stmt.executeQuery("SELECT * FROM SingleRegister ORDER BY 'email' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Single Entry<h4></caption>"
					+ "<tr>"
					+ "<th>First name </th>"
					+ "<th> Last Name </th>"
					+ "<th> Email </th>"
					+ "</tr>");
			
			while (result1.next() != false){
				out.print("<tr>" 
						+"<td>" + result1.getString("firstname") + "</td>"
						+"<td>" + result1.getString("lastname") + "</td> " 
						+"<td>" + result1.getString("email") + "</td>"
						+ "</tr>");
			}
			out.print("</table>");
	/*
	* Group Table
	*/			
			result1 = stmt.executeQuery("SELECT * FROM GroupRegister ORDER BY 'groupemail' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Group Entry<h4></caption>"
					+ "<tr>"
					+ "<th>Group Name</th>"
					+ "<th>Number</th>"
					+ "<th>Supervisor</th>"
					+ "<th>Email</th>"
					+ "</tr>");
			
			while (result1.next() != false){
				out.print("<tr>"
						+ "<td>" +result1.getString("groupname") + "</td>"
						+ "<td>" + result1.getString("number") + "</td>"
						+ "<td> " + result1.getString("supervisor") + "</td>"
						+ "<td> " + result1.getString("groupemail") + "</td>"
						+ "</tr>");
			}
			out.print("</table>");
	/*
	*Compete Table
	*
	*/
			result1 = stmt.executeQuery("SELECT * FROM compete ORDER BY 'competition' DESC");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Compete Entry<h4></caption> "
					+ "<tr>"
					+ "<th>Competition Code</th>"
					+ "<th>Team Name</th>"
					+ "<th>Mentor Name</th>"
					+ "<th>College</th>"
					+ "<th>Team Member 1</th>"
					+ "<th>Team Member 2</th>"
					+ "<th>Team Member 3</th>"
					+ "<th>Email</th>"
					+ "</tr>");		
			
				while (result1.next() != false){
					out.print("<tr>"
							+ "<td>" + result1.getString("competition") + "</td>"
							+ "<td>" + result1.getString("teamname") + "</td>"
							+ "<td>" + result1.getString("mentor") + "</td>"
							+ "<td>" + result1.getString("college") + "</td>"
							+ "<td>" + result1.getString("memberone") + "</td>"
							+ "<td>" + result1.getString("membertwo") + "</td>"
							+ "<td>" + result1.getString("memberthree") + "</td>"
							+ "<td>" + result1.getString("teamemail") + "</td>"
							+ "</tr>");
				}
			out.print("</table>");
			
		/*
		 *Competitions Table
		 */
			result1 = stmt.executeQuery("SELECT * FROM competitions");
			out.print("<table border=\"1\" >"
					+ "<caption> <h4>Competitions<h4></caption>"
					+ "<tr>"
					+ "<th>Competitions Code</th>"
					+ "<th>Competitions Name</th>"
					+ "</tr>");
			
				while (result1.next() != false){
					out.print("<tr>"
							+ "<td>" + result1.getString("competition") + "</td>" 
							+ "<td>" + result1.getString("competitionName") + "</td>"
							+ "</tr>");
				}
			out.print("</table>");
			
			out.print("</section></section></body></html>");
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

}
