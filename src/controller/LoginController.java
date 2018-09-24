package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import interfase.Interfase;
import model.Login;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (validacao(req)) {
			Interfase home = login(req);
			home.execute(req, resp);
		} else {
			RequestDispatcher requestDispatcher =  req.getRequestDispatcher("WEB-INF/view/login/login.jsp");
			req.setAttribute("validacao", "Preenchimento de campos inválido");
			requestDispatcher.forward(req, resp);
		}
	}

	public boolean validacao(HttpServletRequest req) {
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		if (usuario.equals("") || usuario == null || senha.equals("") || senha == null)
			return false;

		return true;
	}

	public Interfase login(HttpServletRequest req) {
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		Login login = new LoginDAO().Logar(usuario);

		if (login.getUsuarioLogin().equals(usuario) && login.getSenhaLogin().equals(senha)) {

			// aluno
			if (login.getNhLogin() == 3) {
				req.getSession().setAttribute("usuarioLogado", usuario);
				req.getSession().setAttribute("nivelHierarquico", "aluno");
				return new HomeAlunoController();
				// professor
			} else if (login.getNhLogin() == 2) {
				req.getSession().setAttribute("usuarioLogado", usuario);
				req.getSession().setAttribute("nivelHierarquico", "professor");
				return new HomeProfessorController();
			}
		}

		return new HomeController();
	}

}
