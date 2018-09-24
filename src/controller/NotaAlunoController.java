package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProcNotaDAO;
import interfase.Interfase;
import model.ProcNota;

public class NotaAlunoController implements Interfase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {

			List<ProcNota> listaNota = new ProcNotaDAO().ConsultarNotaAvalaicao(25923, 1);
			req.setAttribute("listaNota", listaNota);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/view/aluno/nota.jsp");
			dispatcher.forward(req, resp);

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

}
