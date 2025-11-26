package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","root");
		
		//create Statement
		Statement smt = con.createStatement();
		String q1 = "Select * from books";
		
		ResultSet rs = smt.executeQuery(q1);
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("title")+" "+rs.getString("author"));
		}
		rs.close();	
	}

}
