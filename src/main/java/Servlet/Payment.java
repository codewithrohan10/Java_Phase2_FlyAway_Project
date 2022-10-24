package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.Customer;


@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Payment() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c=new Customer();
		HttpSession session=request.getSession();
		c.setFlightno(Integer.parseInt(request.getParameter("flight")));
		c.setName(request.getParameter("name"));
		c.setPhone(Long.parseLong(request.getParameter("phone")));
		session.setAttribute("customer", c);
		response.sendRedirect("payment.html");
	}

}
