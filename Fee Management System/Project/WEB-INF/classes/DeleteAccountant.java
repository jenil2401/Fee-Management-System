import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.http.HttpSession;  

public class DeleteAccountant extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");  

			Statement smt=con.createStatement();

			String query = "DELETE FROM Accountant WHERE Acc_ID = " + id + "";

			int delete = smt.executeUpdate(query);

			if(delete > 0){
				resp.sendRedirect("ViewAccountant");
			}
		}
		catch (Exception ex){
			out.println(ex);
		}
	}
}
