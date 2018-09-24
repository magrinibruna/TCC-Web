package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HorarioDAO;
import model.Horario;

@WebServlet(urlPatterns="/horario")
public class HorarioController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Horario horario = new HorarioDAO().BuscarHorarioTurma(1);
		req.setAttribute("url", horario.getCaminhoHorario());
		System.out.println("caminho: " + horario.getCaminhoHorario());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/aluno/horario.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
}
