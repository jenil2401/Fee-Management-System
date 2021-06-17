import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudentSave extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
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
			
			PreparedStatement ps=con.prepareStatement("insert into student (rollno,name,email,address,contact,course,gender,fee,due,paid) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, rollno);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setInt(5, contact);
			ps.setString(6, course);
			ps.setString(7, gender);
			ps.setInt(8, fee);
			ps.setInt(9, due);
			ps.setInt(10, paid);
			
			int i = ps.executeUpdate();
			
			if(i>0){
			out.println("<h1>Add Student Form</h1>");
			out.println("Student is added successfully!");
			request.getRequestDispatcher("AddStudentForm.html").include(request, response);
			out.println("</div>");
			request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</body>");
			out.println("</html>");
			}
		}
		catch(Exception ex){
			out.println(ex);
		}
	}
}
