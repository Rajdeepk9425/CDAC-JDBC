package JDBC_Assignments;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Callable_Statements {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Get connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Assignments", "root", "root");
        System.out.println("Connected successfully");

        // Prepare call
        CallableStatement cmt = con.prepareCall("{ call getMaxsalary(?, ?) }");

        // Input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id: ");
        int id = sc.nextInt();

        // Set input parameter
        cmt.setInt(1, id);

        // Register output parameter BEFORE execution
        cmt.registerOutParameter(2, Types.INTEGER);

        // Execute
        cmt.execute();

        // Retrieve output
        int maxid = cmt.getInt(2);
        System.out.println("Max sal = " + maxsal);

        // Close resources
        cmt.close();
        con.close();
        sc.close();
    }
}