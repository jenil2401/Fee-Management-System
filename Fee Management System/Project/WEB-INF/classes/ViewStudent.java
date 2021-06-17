import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Student Added</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		out.print("<h1>Students</h1>");
	    out.println("<br>");
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr>");
		out.print("<th>Student ID</th>");
		out.print("<th>Name</th>");
		out.print("<th>Email</th>");
		out.print("<th>Gender</th>");
		out.print("<th>Course</th>");
		out.print("<th>Fees</th>");
		out.print("<th>Fees Paid</th>");
		out.print("<th>Fees Due</th>");
		out.print("<th>Address</th>");
		out.print("<th>Contact</th>");
		out.print("<th>Edit</th>");
		out.print("<th>Delete</th>");
		out.print("</tr>");
		
		int rollno;
		String name;
	 	String email;
		String address;
		int contact;
		String course;
		String gender;
		int fee;
		int due;
		int paid;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");  

			Statement smt=con.createStatement();

			ResultSet ps=smt.executeQuery("SELECT * FROM Student");

			boolean flag = false;
			while(ps.next())
			{
				flag = true;
				
				rollno = ps.getInt("rollno");
				name = ps.getString("name");
				email = ps.getString("email");
				address = ps.getString("address");
				contact = ps.getInt("contact");
				course = ps.getString("course");
				gender = ps.getString("gender");
				fee = ps.getInt("fee");
				due = ps.getInt("due");
				paid = ps.getInt("paid");

	
				out.println("<tr>");
				out.println("<td>"+rollno+"</td>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+email+"</td>");
				out.println("<td>"+gender+"</td>");
				out.println("<td>"+course+"</td>");
				out.println("<td>"+fee+"</td>");
				out.println("<td>"+paid+"</td>");
				out.println("<td>"+due+"</td>");
				out.println("<td>"+address+"</td>");
				out.println("<td>"+contact+"</td>");
				out.println("<td><a href='EditStudentForm?rollno="+rollno+"&name="+name+"&email="+email+"&address="+address+"&contact="+contact+"&course="+course+"&gender="+gender+"&fee="+fee+"&due="+due+"&paid="+paid+"'>Edit</a></td>");
				out.println("<td><a href='DeleteStudent?rollno="+rollno+"'>Delete</a></td>");
				out.println("</tr>");
			}
				out.println("</table>");
				out.println("</div>");
				request.getRequestDispatcher("footer.html").include(request, response);
				out.println("</body>");
				out.println("</html>");
	    }
	catch (Exception ex){
			out.println(ex);
		}
	}
}  
