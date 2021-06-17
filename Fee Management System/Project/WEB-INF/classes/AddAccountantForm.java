import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddAccountantForm extends HttpServlet{
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Add Accountant</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");

	out.println("</head>");
	out.println("<body>");
	req.getRequestDispatcher("navadmin.html").include(req, resp);
	out.println("<div class='container'>");
	HttpSession session=req.getSession(false);
	if (session==null||session.getAttribute("admin")==null) {
		out.println("<h1>Not Admin</h1>");
		req.getRequestDispatcher("AdminLoginForm.html").include(req, resp);
		
	}
	else {
		out.println("<h1>Add Accountant Form</h1>");
		req.getRequestDispatcher("AccountantForm.html").include(req, resp);
	}
	out.println("</div>");
	req.getRequestDispatcher("footer.html").include(req, resp);
	out.println("</body>");
	out.println("</html>");
}
}
