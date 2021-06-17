//package com.aakash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

//import com.aakash.beans.Student;
//import com.aakash.dao.StudentDao;
//@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	int rollno=Integer.parseInt(req.getParameter("rollno"));
	//Student st=StudentDao.getStudentByRollNo(rollno);
	
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
	
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","");  
		PreparedStatement ps=con.prepareStatement("select * from student where rollno=?");
		ps.setInt(1,rollno);
		ResultSet rs=ps.executeQuery();
		
		boolean flag = false; 
		while(rs.next()) { 
		flag=true;
         	// Retrieve by column name 
         	int srollno  = rs.getInt("rollno"); 
			String sname = rs.getString("name");
			String semail = rs.getString("email");
         	String saddress = rs.getString("address"); 
			String scontact = rs.getString("contact"); 
			String scourse = rs.getString("course");
			String sgender = rs.getString("gender"); 
			int sfee=rs.getInt("fee");
			int sdue=rs.getInt("due");
			int spaid=rs.getInt("paid");
         	

		//out.print("<div class=\"yes\">");	
		out.println("<h1>Search Student</h1>");
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><td>Student ID:</td><td>"+srollno+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Name:</td><td>"+sname+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Email:</td><td>"+semail+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Address:</td><td>"+saddress+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Contact:</td><td>"+scontact+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Course:</td><td>"+scourse+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Gender:</td><td>"+sgender+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Fee:</td><td>"+sfee+"</td></tr>");
		out.print("<tr><td>Paid:</td><td>"+spaid+"</td></tr>");
		//out.print("<br>");
		out.print("<tr><td>Due:</td><td>"+sdue+"</td></tr>");
		//out.print("<br>");
		out.print("</table>");
		//out.print("</div>");
		rs.close();
		}
		
		if(flag==false)
		{
			out.print("<div class=\"no\">");
			out.print("<h1>No Record found for Student ID "+rollno+"</h1>");
			out.print("</div>");
		}
		con.close();
		
	}catch (Exception e2) {System.out.println(e2);}  
	//out.close(); 

	/*out.println("<h1>Search Student</h1>");
	if (st!=null) {
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><td>Rollno:</td><td>"+st.getRollno()+"</td></tr>");
		out.print("<tr><td>Name:</td><td>"+st.getName()+"</td></tr>");
		out.print("<tr><td>Email:</td><td>"+st.getEmail()+"</td></tr>");
		out.print("<tr><td>Sex:</td><td>"+st.getGender()+"</td></tr>");
		out.print("<tr><td>Course:</td><td>"+st.getCourse()+"</td></tr>");
		out.print("<tr><td>Fee:</td><td>"+st.getFee()+"</td></tr>");
		out.print("</table>");
	
	}
	else {
		
		out.println("<p>No Record found for rollno "+rollno+"</p>");
	}*/
	
out.println("</div>");
req.getRequestDispatcher("footer.html").include(req, resp);
out.println("</body>");
out.println("</html>");
  }
}
