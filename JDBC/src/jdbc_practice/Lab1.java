package jdbc_practice;

import java.util.*;
import java.sql.*;

public class Lab1 {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement smt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb","root","root");
			
			String SQL = "insert into library_db values()";
			
			smt = con.createStatement();
			
			int x = st.executeUpdate(SQL);
			
			if(x==1) {
				System.out.println("inserted successfully");
			}else {
				System.out.println("sorry, not inserted");
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
				try {
					if(smt!=null)
						smt.close();
					
					if(con!=null)
						con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		}
		
}
