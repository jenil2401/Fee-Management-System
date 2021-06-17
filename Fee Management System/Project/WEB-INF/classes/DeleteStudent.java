import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.http.HttpSession;  

public class DeleteStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		
		try{
			
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");  
		PreparedStatement ps=con.prepareStatement("delete from student where rollno=?");
		ps.setInt(1,rollno);
		
		int status=ps.executeUpdate();
		
		   if(status > 0){
				response.sendRedirect("ViewStudent");
	       }
	    }
		catch (Exception ex){
			out.println(ex);
		}
    }
}