package JDBC_Assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Management_System {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//get connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignments","root","root");
		System.out.println("Connected successfully");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an option: ");
		System.out.println("1. View by Student id");
		System.out.println("2. Add new Student");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Students");
		System.out.println("5. Display All Students");
		
//		create query
//		String q1  = "select *  from students where id=?";
//		String q2 = "insert into students ( name , course) values (?, ?)";
//		String q3 = "Update students set  name=? , course=? where id=? ";
//		String q4 = "Delete from students where id=? ";
		
		int choice = sc.nextInt();
		
		// create statement
				//1//"Query  q1: READ "
//				PreparedStatement pmt= con.prepareStatement(q1);
//				System.out.println("Enter the id");
//				Scanner sc = new Scanner(System.in);
//				int n0 = sc.nextInt();
//				pmt.setInt(1,n0);
		
		switch(choice) {
		case 1: 
			String q1  = "select *  from students where id=?";
			PreparedStatement pmt= con.prepareStatement(q1);
			System.out.println("Enter the id");
			int n0 = sc.nextInt();
			pmt.setInt(1,n0);
			ResultSet s = pmt.executeQuery();
			while(s.next()) {
			System.out.println(s.getInt("id")+" "+s.getString("name")+" "+s.getString("course"));
			}
		s.close();
			break;
			
			//2//"Query q2 = "INSERT"
//			PreparedStatement pmt= con.prepareStatement(q2);
////			System.out.println("Enter the id");
//			Scanner sc = new Scanner(System.in);
////			int n0 = sc.nextInt();
//			System.out.println("Enter the name");
////			pmt.setInt(1,n0);
//			String n1 = sc.next();
//			pmt.setString(1,n1 );             //"WE USE THIS (1,N0) AS PER THE QUERY IF WE HAVE (NAME,COURSE) THEN (1,2) AND IF WE HAVE (ID) ALSO THEN IT GOES TO (3)")
//			System.out.println("Enter your course");
//			String n2=sc.next();
//			pmt.setString(2,n2);

		
		case 2: 
			String q2 = "insert into students ( name , course) values (?, ?)";
			PreparedStatement pmt1= con.prepareStatement(q2);
			System.out.println("Enter the name");
			String n1 = sc.next();
			pmt1.setString(1,n1 );             //"WE USE THIS (1,N0) AS PER THE QUERY IF WE HAVE (NAME,COURSE) THEN (1,2) AND IF WE HAVE (ID) ALSO THEN IT GOES TO (3)")
			System.out.println("Enter your course");
			String n2=sc.next();
			pmt1.setString(2,n2);
			int s1 = pmt1.executeUpdate();
			System.out.println("number of rows affected"+s1);
			break;
			
//			//3//"Query q3 ="UPDATE"
//			PreparedStatement pmt= con.prepareStatement(q3);
//			
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.println("Enter the id");
//			int n0 = sc.nextInt();
//			pmt.setInt(3,n0);
//			
//			System.out.println("Enter the name");
//			String n1 = sc.next();
//			pmt.setString(1,n1 ); 
//			
//			System.out.println("Enter your course");
//			String n2=sc.next();
//			pmt.setString(2,n2);
				
		
		
		case 3:
			String q3 = "Update students set  name=? , course=? where id=? ";
			PreparedStatement pmt2= con.prepareStatement(q3);
			
			System.out.println("Enter the id");
			int n3 = sc.nextInt();
			pmt2.setInt(3,n3);
			
			System.out.println("Enter the name");
			String n4 = sc.next();
			pmt2.setString(1,n4); 
			
			System.out.println("Enter your course");
			String n5=sc.next();
			pmt2.setString(2,n5);
			int s2 = pmt2.executeUpdate();
			System.out.println("number of rows affected"+s2);
			break;
			
//			4//"Query q4 = "DELETE"
//			PreparedStatement pmt= con.prepareStatement(q4);
//			System.out.println("Enter the id you want to delete");
//			Scanner sc = new Scanner(System.in);
//			int n0 = sc.nextInt();
//			pmt.setInt(1,n0);
//	
		

		case 4:
			String q4 = "Delete from students where id=? ";
			PreparedStatement pmt3= con.prepareStatement(q4);
			System.out.println("Enter the id you want to delete");
			int n6 = sc.nextInt();
			pmt3.setInt(1,n6);
			int s3 = pmt3.executeUpdate();
			System.out.println("number of rows affected"+s3);
			break;

		case 5:
			String q5 = "select * from students";
			PreparedStatement pmt4= con.prepareStatement(q5);
			ResultSet s4 = pmt4.executeQuery();
			while(s4.next()) {
			System.out.println(s4.getInt("id")+" "+s4.getString("name")+" "+s4.getString("course"));
			}
		s4.close();
	}
	
	//Query perform
//		int s = pmt.executeUpdate();
	
	
//	while(rs.next()) {
//		System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("course"));
//		}
//	rs.close();
		
//		System.out.println("number of rows affected"+s);
		
	}
}
