package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admin")
public class Admin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
 
    public Admin()
    {
        super();
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
	PrintWriter pw=response.getWriter();
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	String user="root";
	String password="RohanCS10$";
	String url="jdbc:mysql://localhost:3306/flyaway";
	Connection con=DriverManager.getConnection(url,user,password);
	PreparedStatement ps=con.prepareStatement("select * from admin");
	ResultSet rs=ps.executeQuery();
	if(rs.next()) 
	    {
		if(request.getParameter("username").equals(rs.getString(1))&&request.getParameter("password").equals(rs.getString(2))) 
		  {
			request.getRequestDispatcher("1.html").include(request, response);
		  }
		else 
		  {
			request.getRequestDispatcher("AdminLogin.html").include(request, response);
			pw.println("<h3 align='center'><SPAN style='color:red'>Invalid Credentials</SPAN></h3>");
		  }
	    }
	 } 
	catch (Exception e) 
	{
		pw.print(e);
	}
}		
}


