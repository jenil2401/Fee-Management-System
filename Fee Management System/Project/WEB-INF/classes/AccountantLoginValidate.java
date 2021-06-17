import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.http.HttpSession;  

public class AccountantLoginValidate extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Section</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
	    req.getRequestDispatcher("navaccountant.html").include(req, resp);
	    out.println("<div class='container'>");
	    
	    String email=req.getParameter("email");
	    String password=req.getParameter("password");
	    
	    try{

	    	Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");  

			Statement smt=con.createStatement();

			ResultSet rs=smt.executeQuery("SELECT Acc_Password, Acc_Email FROM Accountant");

			while(rs.next()){

				String email1 = rs.getString(2);
				String password1 = rs.getString(1);

				if(email.equals(email1) && password.equals(password1)){
					HttpSession session=req.getSession();
					session.setAttribute("accountant","true");
					req.getRequestDispatcher("accountanthome.html").include(req, resp);
				}
				else{
					out.println("<h1>Accountant Login</h1>");
					out.println("<p>Sorry,Username or password error</p>");
					req.getRequestDispatcher("AccountantLogin.html").include(req, resp);
				}

			}

			out.println("</div>");
	    	req.getRequestDispatcher("footer.html").include(req, resp);
    		out.println("</body>");
			out.println("</html>");

	    }
	    catch(Exception ex){
	    	out.println(ex);
	    }
	}
}
