import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class AddAccountantSave extends HttpServlet{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title> Accountant Added</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head>");
	out.println("<body>");
	req.getRequestDispatcher("navadmin.html").include(req, resp);
	out.println("<div class='container'>");

	int id = Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	String contact=req.getParameter("contact");

	try{

		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");
		
		PreparedStatement myStmt = con.prepareStatement("INSERT INTO Accountant (Acc_ID, Acc_Name, Acc_Password, Acc_Email, Acc_Address, Acc_Contact) VALUES (?, ?, ?, ?, ?, ?)");  

		myStmt.setInt(1, id);
		myStmt.setString(2, name);
		myStmt.setString(3, password);
		myStmt.setString(4, email);
		myStmt.setString(5, address);
		myStmt.setString(6, contact);

		int i=myStmt.executeUpdate();  

		if(i>0){
			out.println("<h1>Add Accountant Form</h1>");
			out.println("<p>Accountant is added successfully!!</p>");
			req.getRequestDispatcher("AccountantForm.html").include(req, resp);
			out.println("</div>");
			req.getRequestDispatcher("footer.html").include(req, resp);
			out.println("</body>");
			out.println("</html>");
		}

	}
	catch(Exception ex){
		out.println(ex);
	}
}	
}