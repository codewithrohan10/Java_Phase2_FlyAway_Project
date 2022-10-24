package Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import Database.Customer;


@WebFilter("/Validation")
public class Validation extends HttpFilter implements Filter {
       
   
    public Validation() {
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String cardno=request.getParameter("cardno");
		if(cardno==null||!cardno.matches("[0-9]{12}")||!request.getParameter("cvv").matches("[0-9]{3}")){
			PrintWriter pw=response.getWriter();
			request.getRequestDispatcher("payment.html").include(request, response);
			pw.println("<center><SPAN style='color:red'>Invalid Credentials</SPAN></center>");
		}
		else {
			Customer c=new Customer();
			c.setCardname(request.getParameter("name1"));
			c.setCardno(Long.parseLong(request.getParameter("cardno")));
			request.setAttribute("customer", c);
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
