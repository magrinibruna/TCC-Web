package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/deslogar")
public class DeslogarController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.getSession().invalidate();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/login/login.jsp");
		requestDispatcher.forward(req, resp);
	}

}
