package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProcNotaDAO;
import interfase.Interfase;
import model.ProcNota;

public class NotaProfessorController implements Interfase {

	private RequestDispatcher requestDispatcher;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {

			requestDispatcher = req.getRequestDispatcher("WEB-INF/view/professor/nota.jsp");
		
			String trimestre = "3";
			String avaliacao = "1";
			
			List<ProcNota> lista = new ArrayList<ProcNota>();
			
			lista = new ProcNotaDAO().ConsultarNotaProfessorAvaliacao(1, trimestre, avaliacao);
			
			req.setAttribute("notasAlunos", lista);
			
			requestDispatcher.forward(req, resp);
			
		
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

}

// PEGAR JSON
//
// BufferedReader reader;
// try {
// reader = req.getReader();
//
// String aux = null;
//
// StringBuilder sbBuilder = new StringBuilder();
// while ((aux = reader.readLine()) != null) {
// sbBuilder.append(aux);
// }
//
// System.out.println(sbBuilder);