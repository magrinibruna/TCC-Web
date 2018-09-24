package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.HomeController;
import controller.NotaAlunoController;
import controller.NotaProfessorController;
import interfase.Interfase;

@WebFilter("/nota")
public class Nota implements Filter {

	public Nota() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		Interfase nota = getNivelHierarquico(req, resp);
		nota.execute(req, resp);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public Interfase getNivelHierarquico(HttpServletRequest req, HttpServletResponse resp) {

		String nivelHierarquico = (String) req.getSession().getAttribute("nivelHierarquico");

		String usuario = (String) req.getSession().getAttribute("usuarioLogado");

		if (usuario == null) {
			return new HomeController();
		} else {
			if (nivelHierarquico.equals("aluno")) {
				return new NotaAlunoController();
			} else {
				return new NotaProfessorController();
			}
		}
	}
	

}
