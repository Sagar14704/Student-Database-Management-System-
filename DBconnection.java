package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	    
	    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
	    private static final String USER = "root";  
	    private static final String PASSWORD = "sagar14704";  
	    
	    public static Connection getConnection() throws SQLException {
	        
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}
