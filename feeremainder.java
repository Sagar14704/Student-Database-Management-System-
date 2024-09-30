package service;


	

	import db.DBconnection;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class feeremainder {

	

	    public void sendFeeReminders() throws SQLException {
	        Connection conn = DBconnection.getConnection();
	        String query = "SELECT name, fees_balance FROM students WHERE fees_balance > 0";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	            String name = rs.getString("name");
	            double balance = rs.getDouble("fees_balance");
	            System.out.println("Reminder: Student " + name + " has an outstanding balance of " + balance);
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    }
	}
