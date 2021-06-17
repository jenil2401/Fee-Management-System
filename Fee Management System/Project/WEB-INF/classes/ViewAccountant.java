import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.http.HttpSession;  

public class ViewAccountant extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Accountant Details </title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		out.println("<h1>Accountants</h1>");
		out.println("<br>");
	    out.println("<table class='table table-bordered table-striped'>");
	    out.println("<tr>");
	    out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Password</th>");
		out.println("<th>Address</th>");
		out.println("<th>Contact</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");

		int id;
		String name;
		String pass;
		String email;
		String add;
		String contact;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");  

			Statement smt=con.createStatement();

			ResultSet rs=smt.executeQuery("SELECT * FROM Accountant");

			boolean flag = false;
			while(rs.next())
			{
				flag = true;

				id = rs.getInt("Acc_ID");
				name = rs.getString("Acc_Name");
				pass = rs.getString("Acc_Password");
				email = rs.getString("Acc_Email");
				add = rs.getString("Acc_Address");
				contact = rs.getString("Acc_Contact");

				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+email+"</td>");
				out.println("<td>"+pass+"</td>");
				out.println("<td>"+add+"</td>");
				out.println("<td>"+contact+"</td>");
				out.println("<td><a href='EditAccountantForm?id="+id+"&name="+name+"&email="+email+"&pass="+pass+"&add="+add+"&contact="+contact+"'>Edit</a></td>");
				out.println("<td><a href='DeleteAccountant?id="+id+"'>Delete</a></td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("</div>");
			req.getRequestDispatcher("footer.html").include(req, resp);
			out.println("</body>");
			out.println("</html>");

		}
		catch (Exception ex){
			out.println(ex);
		}
	}
}  