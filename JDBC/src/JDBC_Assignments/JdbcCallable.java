package JDBC_Assignments;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class JdbcCallable {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignments", "root", "root");
        System.out.println("Connected to database");

        Scanner s = new Scanner(System.in);
        // Example 1: Procedure with OUT parameter
        CallableStatement cmt = con.prepareCall("{ call getEmpName(?, ?) }");
        System.out.println("Enter the dept no:");
        int dno = s.nextInt();

        cmt.setInt(1, dno);
        cmt.registerOutParameter(2, Types.VARCHAR);

        cmt.execute();
        String ename = cmt.getString(2);
        System.out.println(ename + " is getting max salary");
        

        // Example 2: Procedure returning ResultSet.
        CallableStatement cmt2 = con.prepareCall("{ call getEmpdetails(?) }");
        System.out.println("Enter the emp no:");
        int eno = s.nextInt();
        cmt2.setInt(1, eno);

        ResultSet rs = cmt2.executeQuery();

        while (rs.next()) {
            // Use column names for clarity
            int empNo = rs.getInt("EMPNO");
            String empName = rs.getString("ENAME");
            float salary = rs.getFloat("SALARY");

            System.out.println(empNo + " " + empName + " " + salary);
        }

        rs.close();
        cmt.close();
        con.close();
        s.close();
    }
}