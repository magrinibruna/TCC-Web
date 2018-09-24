package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventoDAO;
import interfase.Interfase;
import model.Evento;

public class HomeAlunoController implements Interfase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			List<Evento> listaEvento = new EventoDAO().ConsultaEvento();
			req.setAttribute("listaEvento", listaEvento);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/aluno/home.jsp");
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
