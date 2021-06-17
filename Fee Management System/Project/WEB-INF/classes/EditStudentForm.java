import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditStudentForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Form</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>Edit Student Form</h1>");
		out.print("<form action='EditStudent' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Student ID:</td><td><input type='text' name='rollno' value='"+rollno+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+name+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+email+"'/></td></tr>");
		out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+gender+"'/></td></tr>");
        out.print("<tr><td>Course:</td><td>");
        out.print("<select name='course' value='"+course+"'>");
        out.print("<option>Java</option>");
        out.print("<option>.Net</option>");
        out.print("<option>PHP</option>");
        out.print("<option>Android</option>");
        out.print("<option>Bootstrap</option>");
        out.print("<option>Oracle Database</option>");
        out.print("<option>Python</option>");
        out.print("<option>AWS</option>");
        out.print("<option>Machine Learning</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td>Fee:</td><td><input type='text' name='fee' value='"+fee+"'/></td></tr>");
        out.print("<tr><td>Paid:</td><td><input type='text' name='paid' value='"+paid+"'/></td></tr>");
        out.print("<tr><td>Due:</td><td><input type='text' name='due' value='"+due+"'/></td></tr>");
        out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px; height:100px;'>"+address+"</textarea></td></tr>");
	    out.print("<tr><td>Contact No:</td><td><input type='text' name='contact' value='"+contact+"'/></td></tr>");
        out.print("<tr><td colspan='2' align='center'><input type='submit' class='btn btn-default' value='Update Student'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
				
	}

}
