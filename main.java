package main;


	

	import model.student;
	import service.studentservice;
	import service.feeremainder;

	import java.sql.SQLException;
	import java.util.List;
	import java.util.Scanner;
	public class main {

	
	    public static void main(String[] args) {
	        studentservice studentService = new studentservice();
	        feeremainder feeReminderService = new feeremainder();
	        Scanner scanner = new Scanner(System.in);
	        
	        while (true) {
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. Update Fees");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Send Fee Reminders");
	            System.out.println("6. Exit");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume newline
	            
	            try {
	                switch (choice) {
	                    case 1:
	                        student student = new student();
	                        System.out.println("Enter Name: ");
	                        student.setName(scanner.nextLine());
	                        System.out.println("Enter Age: ");
	                        student.setAge(scanner.nextInt());
	                        scanner.nextLine();
	                        System.out.println("Enter Course: ");
	                        student.setCourse(scanner.nextLine());
	                        System.out.println("Enter Fees Balance: ");
	                        student.setFeesBalance(scanner.nextDouble());
	                        System.out.println("Enter Marks: ");
	                        student.setMarks(scanner.nextDouble());
	                        studentService.addStudent(student);
	                        System.out.println("Student added successfully!");
	                        break;
	                    case 2:
	                        List<student> students = studentService.getAllStudents();
	                        for (student s : students) {
	                            System.out.println(s.getStudentId() + ": " + s.getName() + " - Fees Balance: " + s.getFeesBalance());
	                        }
	                        break;
	                    case 3:
	                        System.out.println("Enter Student ID: ");
	                        int id = scanner.nextInt();
	                        System.out.println("Enter New Fees Balance: ");
	                        double balance = scanner.nextDouble();
	                        studentService.updateFees(id, balance);
	                        System.out.println("Fees updated successfully!");
	                        break;
	                    case 4:
	                        System.out.println("Enter Student ID to delete: ");
	                        int deleteId = scanner.nextInt();
	                        studentService.deleteStudent(deleteId);
	                        System.out.println("Student deleted successfully!");
	                        break;
	                    case 5:
	                        feeReminderService.sendFeeReminders();
	                        break;
	                    case 6:
	                        System.exit(0);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


