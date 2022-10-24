package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Flights;
import Database.FlightsDB;


@WebServlet("/FlightsServ")
public class FlightsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FlightsServ() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Flights> flightlist=FlightsDB.getFlightsList();
			request.setAttribute("flightlist", flightlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("show-flights.jsp");
		dispatcher.forward(request, response);

	}


}
