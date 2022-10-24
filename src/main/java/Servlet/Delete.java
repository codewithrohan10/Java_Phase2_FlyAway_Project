package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Delete() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user="root";
		String password="RohanCS10$";
		String url="jdbc:mysql://localhost:3306/flyaway";
		Connection con=DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps=con.prepareStatement("delete from flights where flightnumber=?");
		ps.setString(1, request.getParameter("flightnos"));
		ps.executeUpdate();
		ps.close();
		request.getRequestDispatcher("1.html").include(request, response);
		
		pw.println("<center><SPAN style='color:green'>Flight Deleted Successfully or entered Flight Number doesn't exist</SPAN></center>");
		
		}
		catch (Exception e) {
			
			pw.print(e);
		}
	}

}
