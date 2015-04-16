/**
 * 	Name: 			Derek O Brien
 * 	K-Num: 			K00105572
 * 	Project: 		EAD Assignment
 * 	Description:	Class to create connection with the database
 */

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;


public class DBConnection {

	private Connection conn;
	
	//Default Constructor
	public DBConnection()
	{
		String URL = "jdbc:mysql://127.0.0.1:3306/";
		String DB = "ead_gamesfleadh";
		String DRIVER = "com.mysql.jdbc.Driver";
		String USERNAME = "admin";
		String PASSWORD = "password";
		
		try {	
			Class.forName(DRIVER).newInstance();
	        conn = (Connection) DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
	        System.out.println("Connection Made");
		}
        catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	//2 Arg Constructor
	public DBConnection(String username, String password){
		String URL = "jdbc:mysql://127.0.0.1:3306/";
		String DB = "ead_gamesfleadh";
		String DRIVER = "com.mysql.jdbc.Driver";
		String USERNAME = username;
		String PASSWORD = password;
		
		try {
			Class.forName(DRIVER).newInstance();
	        conn = (Connection) DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
	        System.out.println("Connection Made");
		}
        catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	public void closeConnection()
	{
        try {
            conn.close();
         }
         catch (Exception e) {
             e.printStackTrace();
         }
	}
	
}
