//package com.aakash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentForm extends HttpServlet{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Search Student</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head>");
	out.println("<body>");
	req.getRequestDispatcher("navaccountant.html").include(req, resp);
	out.println("<div class='container'>");
	req.getRequestDispatcher("SearchStudentForm.html").include(req, resp);
	out.println("</div>");
	req.getRequestDispatcher("footer.html").include(req, resp);
	out.println("</body>");
	out.println("</html>");
}
}
