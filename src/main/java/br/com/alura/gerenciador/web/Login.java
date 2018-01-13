package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario == null) {
			return "/WEB-INF/paginas/loginInvalido.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			req.setAttribute("usuario", usuario);
			return "/WEB-INF/paginas/loginValido.jsp";
		}

	}
}
