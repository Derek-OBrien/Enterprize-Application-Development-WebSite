/**
 * 	Name: 			Derek O Brien
 * 	K-Num: 			K00105572
 * 	Project: 		EAD Assignment
 * 	Description:	Create tables in database to store information taking from registration form
 */

import java.sql.Connection;
import java.sql.Statement;

public class DBCreateTable {
	
    public static void main(String[] args) {
    	
    	DBConnection DbCon = new DBConnection();
    	Connection conn = DbCon.getConnection();
        
        try {           
           Statement stmt = conn.createStatement();
		   //Create Single Register Table
           stmt.execute("CREATE TABLE IF NOT EXISTS SingleRegister("
           		+ "firstname CHAR(40) NOT NULL,"
           		+ "lastname CHAR(40) NOT NULL, "
           		+ "email VARCHAR(50),"
		    	+ "CONSTRAINT genRegPK PRIMARY KEY (email))");
           
		   //Create Group Register Table
		   stmt.execute("CREATE TABLE IF NOT EXISTS GroupRegister("
		   		+ "groupname CHAR(40) NOT NULL,"
		   		+ "number INTEGER NOT NULL,"
		   		+ "supervisor VARCHAR(50) NOT NULL,"
		   		+ "groupemail VARCHAR(50),"
		   		+ "CONSTRAINT schRegPK PRIMARY KEY (groupemail))");
		   
		   //Create Competitions Table
		   stmt.execute("CREATE TABLE IF NOT EXISTS Competitions("
		   		+ "competition VARCHAR(50), "
		   		+ "competitionName VARCHAR(50) NOT NULL,"
		    	+ "CONSTRAINT compPK PRIMARY KEY (competition))");
		   
		   //Create Compete Register Table
		   stmt.execute("CREATE TABLE IF NOT EXISTS Compete("
		   		+ "competition VARCHAR(50) NOT NULL, "
		   		+ "teamname VARCHAR(50) NOT NULL, "
		   		+ "mentor CHAR(40) NOT NULL, "
		    	+ "college VARCHAR(50) NOT NULL, "
		    	+ "memberone CHAR(50), "
		    	+ "membertwo CHAR(50), "
		    	+ "memberthree CHAR(50), "
		    	+ "teamemail VARCHAR(50), "
		    	+ "CONSTRAINT compRegPK PRIMARY KEY (teamemail),"
		    	+ "CONSTRAINT compRegFK FOREIGN KEY (competition) " 
		    	+ "REFERENCES Competitions(competition))");
		    
		   //Add Data to Competition Tables
       		stmt.execute("INSERT INTO Competitions VALUES('1', 'RoboCode')");	              
       		stmt.execute("INSERT INTO Competitions VALUES('2', 'DirectX')");	              
       		stmt.execute("INSERT INTO Competitions VALUES('3', 'Game Studio Ireland')");
           
       		//Close Connection
       		DbCon.closeConnection();
           
        } catch (Exception e) {
           e.printStackTrace();
        }

     }

}


