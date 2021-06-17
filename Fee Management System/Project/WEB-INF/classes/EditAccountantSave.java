import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.http.HttpSession; 

public class EditAccountantSave extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String contact=req.getParameter("contact");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");

			Statement smt=con.createStatement();

//			String query = "update Accountant set Acc_Name = " + name + ", Acc_Password = " + password + ", Acc_Email = " + email + ", Acc_Address = " + address + ", Acc_Contact = " + contact + " where Acc_ID = " + id + "";  

//			int update=smt.executeUpdate(query);
//			if(update > 0){
//				resp.sendRedirect("ViewAccountant");
//			}

//			String q = "UPDATE Accountant SET (Acc_ID, Acc_Name, Acc_Password, Acc_Email, Acc_Address, Acc_Contact) VALUES (?, ?, ?, ?, ?, ?) WHERE Acc_ID = " + id + "";

//			PreparedStatement myStmt = con.prepareStatement(q);  

//			myStmt.setInt(1, id);
//			myStmt.setString(2, name);
//			myStmt.setString(3, password);
//			myStmt.setString(4, email);
//			myStmt.setString(5, address);
//			myStmt.setString(6, contact);

//			int i=myStmt.executeUpdate(); 

//			if(i > 0){
//				resp.sendRedirect("ViewAccountant");
//			}

			PreparedStatement ps = con.prepareStatement("update accountant set Acc_Name=?, Acc_Password=?, Acc_Email=?, Acc_Address=?, Acc_Contact=? where Acc_ID=?");

			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, contact);
			ps.setInt(6, id);

			int i=ps.executeUpdate(); 

			if(i > 0){
				resp.sendRedirect("ViewAccountant");
			}

	   		con.close();	
		}
		catch(Exception ex){
			out.println(ex);
		}
	}
}
