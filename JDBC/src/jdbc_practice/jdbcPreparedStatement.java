package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcPreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");   //method1
		
		//connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","root");  //method2
		
		
		//Create Query
		String q1 = "select * from books where id=?";
		
		
		//Create Statements
		PreparedStatement pmt = con.prepareStatement(q1);     //new class(preparedStatement) for calling object(pmt)
		System.out.println("Enter book to search");
		Scanner sc = new Scanner(System.in);   //Scanner class for inputs
		int n0 = sc.nextInt();
		pmt.setInt(1, n0);   //Here we set the value for substitue of data   //object
		
		
		
		//Execute query
		ResultSet rs = pmt.executeQuery();
		
		
		//Iterate results
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("title")+" "+rs.getString("author"));
		}
		rs.close();
	}

}
