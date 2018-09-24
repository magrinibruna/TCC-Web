package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfase.Interfase;

public class NotaProfessorController implements Interfase {

	private RequestDispatcher requestDispatcher;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		requestDispatcher = req.getRequestDispatcher("WEB-INF/view/professor/nota.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("chegou");
		// System.out.println(req.getParameter("notas"));

		BufferedReader reader;
		try {
			reader = req.getReader();

			String aux = null;

			StringBuilder sbBuilder = new StringBuilder();
			while ((aux = reader.readLine()) != null) {
				sbBuilder.append(aux);
			}

			System.out.println(sbBuilder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
