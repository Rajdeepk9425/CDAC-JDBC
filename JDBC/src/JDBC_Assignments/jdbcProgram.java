package JDBC_Assignments;

import  java.sql.*;
import java.util.Scanner;

public class jdbcProgram {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignments","root","root") ;
		System.out.println("got connection");
		
		

		  Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nChoose an operation:");
	            System.out.println("1. Insert student");
	            System.out.println("2. Display all students");
	            System.out.println("3. Update student");
	            System.out.println("4. Delete student");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch (choice) {
                case 1:
                    // Insert
                    System.out.println("Enter student id:");
                    int insertId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter student name:");
                    String insertName = scanner.nextLine();

                    System.out.println("Enter student course:");
                    String insertCourse = scanner.nextLine();

                    String insertQuery = "INSERT INTO studentlist (id, name, course) VALUES (?, ?, ?)";
                    PreparedStatement insertStmt = con.prepareStatement(insertQuery);
                    insertStmt.setInt(1, insertId);
                    insertStmt.setString(2, insertName);
                    insertStmt.setString(3, insertCourse);

                    int rowsInserted = insertStmt.executeUpdate();
                    System.out.println(rowsInserted + " row(s) inserted.");
                    insertStmt.close();
                    break;
                    
	        case 2:
                // Select all
                String selectQuery = "SELECT * FROM studentlist";
                Statement selectStmt = con.createStatement();
                ResultSet rs = selectStmt.executeQuery(selectQuery);

                System.out.println("ID\tName\tAddress");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                                       rs.getString("name") + "\t" +
                                       rs.getString("course"));
                }
	        case 3:
                // Update
                System.out.println("Enter student id to update:");
                int updateId = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter new name:");
                String newName = scanner.nextLine();

                System.out.println("Enter new address:");
                String newCourse = scanner.nextLine();

                String updateQuery = "UPDATE studentlist SET name = ?, address = ? WHERE id = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                updateStmt.setString(1, newName);
                updateStmt.setString(2, newCourse);
                updateStmt.setInt(3, updateId);

                int rowsUpdated = updateStmt.executeUpdate();
                System.out.println(rowsUpdated + " row(s) updated.");
                updateStmt.close();
                break;

            case 4:
                // Delete
                System.out.println("Enter student id to delete:");
                int deleteId = scanner.nextInt();
                scanner.nextLine();

                String deleteQuery = "DELETE FROM studentlist WHERE id = ?";
                PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
                deleteStmt.setInt(1, deleteId);

                int rowsDeleted = deleteStmt.executeUpdate();
                System.out.println(rowsDeleted + " row(s) deleted.");
                deleteStmt.close();
                break;
            case 5:
                // Exit+---
                System.out.println("Exiting...");
                scanner.close();
                con.close();
                return;

            default:
                System.out.println("Invalid choice, try again.");
        }
    }
}
}