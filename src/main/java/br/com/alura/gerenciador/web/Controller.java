package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");

		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}

		tarefa = "br.com.alura.gerenciador.web." + tarefa;

		try {
			// Retorna a classe da tarefa
			Class<?> tipo = Class.forName(tarefa);
			// instancia a classe da tarefa e faz cast para tarefa
			Tarefa instancia = (Tarefa) tipo.newInstance();
			// Chama o método executa dentro de tarefa Tarefa=Interface
			String pagina = instancia.executa(req, resp);

			// Faz o dispatcher
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}
