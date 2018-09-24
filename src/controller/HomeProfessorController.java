package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfase.Interfase;

public class HomeProfessorController implements Interfase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
		
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/professor/home.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
