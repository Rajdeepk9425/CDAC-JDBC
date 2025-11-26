package JDBC_Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Management_System_By_Functions {

    static Connection con;
    static Scanner sc;

    // READ (SELECT by ID)
    static void readStudent() throws SQLException {
        String q = "select * from students where id=? ";
        PreparedStatement pmt = con.prepareStatement(q);
        System.out.println("Enter the id");
        int id = sc.nextInt();
        pmt.setInt(1, id);
        ResultSet rs = pmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("course"));
        }
        rs.close();
        pmt.close();
    }

    // CREATE (INSERT)
    static void createStudent() throws SQLException {
        String q = "insert into students (name, course) values (?, ?)";
        PreparedStatement pmt = con.prepareStatement(q);
        System.out.println("Enter the name");
        String name = sc.next();
        pmt.setString(1, name);
        System.out.println("Enter your course");
        String course = sc.next();
        pmt.setString(2, course);
        int rows = pmt.executeUpdate();
        System.out.println("Number of rows affected: " + rows);
        pmt.close();
    }

    // UPDATE
    static void updateStudent() throws SQLException {
        String q = "update students set name=?, course=? where id=?";
        PreparedStatement pmt = con.prepareStatement(q);

        System.out.println("Enter the id");
        int id = sc.nextInt();
        System.out.println("Enter the new name");
        String name = sc.next();
        System.out.println("Enter the new course");
        String course = sc.next();

        pmt.setString(1, name);
        pmt.setString(2, course);
        pmt.setInt(3, id);

        int rows = pmt.executeUpdate();
        System.out.println("Number of rows affected: " + rows);
        pmt.close();
    }

    // DELETE
    static void deleteStudent() throws SQLException {
        String q = "delete from students where id=?";
        PreparedStatement pmt = con.prepareStatement(q);
        System.out.println("Enter the id you want to delete");
        int id = sc.nextInt();
        pmt.setInt(1, id);
        int rows = pmt.executeUpdate();
        System.out.println("Number of rows affected: " + rows);
        pmt.close();
    }

    // SHOW ALL
    static void showAllStudents() throws SQLException {
        String q = "select * from students";
        PreparedStatement pmt = con.prepareStatement(q);
        ResultSet rs = pmt.executeQuery();
        System.out.println("ID | Name | Course");
        System.out.println("-------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("course"));
        }
        rs.close();
        pmt.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Get connection
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignments", "root", "root");
        System.out.println("Connected successfully");

        sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose the option:");
            System.out.println("1. Read Student by ID");
            System.out.println("2. Create Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Show All Students");
            System.out.println("6. Exit");
            System.out.println("Choose The Above Options");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    readStudent();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    showAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    con.close();
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}