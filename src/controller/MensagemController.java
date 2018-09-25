package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mensagem")
public class MensagemController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/aluno/mensagem.jsp");
		requestDispatcher.forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		if (validacao(req)) {
			req.setAttribute("validacao", "Mensagem enviada com sucesso");	
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/aluno/mensagem.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			req.setAttribute("validacao", "Preenchimento de campos inválido");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/aluno/mensagem.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

	public boolean validacao(HttpServletRequest req) {

		String destino = req.getParameter("destino");
		String mensagem = req.getParameter("mensagem");

		if (destino == null || mensagem == null || destino.equals("") || mensagem.equals(""))
			return false;

		return true;

	}

}
