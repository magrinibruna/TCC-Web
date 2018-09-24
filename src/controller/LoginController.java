package controller;

import java.io.IOException;

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
		Interfase home = login(req);
		home.execute(req, resp);
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
