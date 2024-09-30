package service;


	

	import db.DBconnection;
	import model.student;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	public class studentservice {

	

	    
	    public void addStudent(student student) throws SQLException {
	        Connection conn = DBconnection.getConnection();
	        String query = "INSERT INTO students (name, age, course, fees_balance, marks) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, student.getName());
	        ps.setInt(2, student.getAge());
	        ps.setString(3, student.getCourse());
	        ps.setDouble(4, student.getFeesBalance());
	        ps.setDouble(5, student.getMarks());
	        ps.executeUpdate();
	        ps.close();
	        conn.close();
	    }

	    
	    public List<student> getAllStudents() throws SQLException {
	        Connection conn = DBconnection.getConnection();
	        String query = "SELECT * FROM students";
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        List<student> students = new ArrayList<>();
	        while (rs.next()) {
	            student student = new student();
	            student.setStudentId(rs.getInt("student_id"));
	            student.setName(rs.getString("name"));
	            student.setAge(rs.getInt("age"));
	            student.setCourse(rs.getString("course"));
	            student.setFeesBalance(rs.getDouble("fees_balance"));
	            student.setMarks(rs.getDouble("marks"));
	            students.add(student);
	        }
	        rs.close();
	        stmt.close();
	        conn.close();
	        return students;
	    }

	    
	    public void updateFees(int studentId, double newBalance) throws SQLException {
	        Connection conn = DBconnection.getConnection();
	        String query = "UPDATE students SET fees_balance = ? WHERE student_id = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setDouble(1, newBalance);
	        ps.setInt(2, studentId);
	        ps.executeUpdate();
	        ps.close();
	        conn.close();
	    }

	    
	    public void deleteStudent(int studentId) throws SQLException {
	        Connection conn = DBconnection.getConnection();
	        String query = "DELETE FROM students WHERE student_id = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setInt(1, studentId);
	        ps.executeUpdate();
	        ps.close();
	        conn.close();
	    }
	}


