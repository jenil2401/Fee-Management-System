import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditStudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String address=request.getParameter("address");
		int contact=Integer.parseInt(request.getParameter("contact"));
		String course=request.getParameter("course");
		String gender=request.getParameter("gender");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int due=Integer.parseInt(request.getParameter("due"));
		int paid=Integer.parseInt(request.getParameter("paid"));
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");

			Statement smt=con.createStatement();

//			String q = "UPDATE student SET (name,email,address,contact,course,gender,fee,due,paid) values(?,?,?,?,?,?,?,?,?) WHERE rollno = " + rollno;

//			PreparedStatement ps = con.prepareStatement(q);  

			PreparedStatement ps = con.prepareStatement("update student set name=?, email=?, address=?, contact=?, course=?, gender=?, fee=?, due=?, paid=? where rollno=?");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, address);
			ps.setInt(4, contact);
			ps.setString(5, course);
			ps.setString(6, gender);
			ps.setInt(7, fee);
			ps.setInt(8, due);
			ps.setInt(9, paid);
			ps.setInt(10, rollno);

			int i=ps.executeUpdate(); 

			if(i > 0){
				response.sendRedirect("ViewStudent");
			}

	   		con.close();	
		}
		catch(Exception ex){
			out.println(ex);
		}
	}
}

