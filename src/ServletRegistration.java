/**
 * Name:			Derek O Brein
 * K-Num:			K00105572
 * Description:		Servlet to complete registration action
 * 					Gets data from web form and posts to database
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;


@WebServlet("/registration")
public class ServletRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Single register table
	private String firstname, lastname, email;
	//Group register table
	private String groupname, number, supervisor, groupemail;
	//Compete register table
	private String teamname, competition, memtorname, collegename, memberone, membertwo, memberthree, teamemail;
	
	private Connection conn = null;
	private PreparedStatement prepStat;
	
    public ServletRegistration(){
        super();
    }
        
    public void init() throws ServletException{
    	//Make Connection With DataBase
    	DBConnection DbCon = new DBConnection();    	
    	conn = DbCon.getConnection();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		//Send to data base here
		String ticketType =  request.getParameter("typeofticket");
		String query;
		
		this.firstname = request.getParameter("firstname");
		this.lastname = request.getParameter("lastname");
		this.email = request.getParameter("email");
		
		this.groupname = request.getParameter("groupname");
		this.number = request.getParameter("number");
		this.supervisor = request.getParameter("supervisor");
		this.groupemail = request.getParameter("groupemail");	

		
		this.teamname = request.getParameter("teamname");
		this.competition = request.getParameter("competition");
		this.collegename = request.getParameter("collegename");
		this.memtorname = request.getParameter("mentorname");
		this.memberone = request.getParameter("memberone");
		this.membertwo = request.getParameter("membertwo");
		this.memberthree = request.getParameter("memberthree");
		this.teamemail = request.getParameter("teamemail");
		
		try{
			//Insert into Single Register
			if ( ticketType.equals("1")){
				query = "INSERT INTO SingleRegister VALUES (?,?,?)";
				prepStat = (PreparedStatement) conn.prepareStatement(query);
				prepStat.setString(1, this.firstname);
				prepStat.setString(2, this.lastname);
				prepStat.setString(3, this.email);
				prepStat.executeUpdate();
			}
			
			//Insert into Group Register
			else if (ticketType.equals("2")){
				query = "INSERT INTO GroupRegister VALUES (?,?,?,?)";
				prepStat = (PreparedStatement) conn.prepareStatement(query);
				prepStat.setString(1, this.groupname);
				prepStat.setString(2, this.number);
				prepStat.setString(3, this.supervisor);
				prepStat.setString(4, this.groupemail);
				prepStat.executeUpdate();
			}
			
			else if (ticketType.equals("3")){
				query = "INSERT INTO Compete VALUES (?,?,?,?,?,?,?,?)";
				prepStat = (PreparedStatement) conn.prepareStatement(query);
				prepStat.setString(1, this.competition);
				prepStat.setString(2, this.teamname);
				prepStat.setString(3, this.memtorname);
				prepStat.setString(4, this.collegename);
				prepStat.setString(5, this.memberone);
				prepStat.setString(6, this.membertwo);
				prepStat.setString(7, this.memberthree);
				prepStat.setString(8, this.teamemail);
				prepStat.executeUpdate();
			}

		}//End Try
				
		catch (Exception e){
			System.err.println(e);
		}
		
		// Direct after submitting form details
	    String site = new String("registrationRedirect.html");
	    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site); 		
	}
}

