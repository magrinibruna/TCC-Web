package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SugestaoDAO;
import model.Sugestao;

@WebServlet(urlPatterns="/sugestao")
public class SugestaoController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher =  req.getRequestDispatcher("WEB-INF/view/aluno/sugestao.jsp");
	
		String nh = (String) req.getSession().getAttribute("nivelHierarquico");
		
		if(nh == null || !nh.equals("aluno")) {
			req.getRequestDispatcher("WEB-INF/view/login/login.jsp");
		}
		
		requestDispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String usuario = (String) req.getSession().getAttribute("usuarioLogado");
		
		String mensagem = req.getParameter("mensagem");
		
		Sugestao objSugestao = new Sugestao(25923, mensagem);
	
		new SugestaoDAO().CadastrarSugestao(objSugestao);
		
		
	
	}

}
