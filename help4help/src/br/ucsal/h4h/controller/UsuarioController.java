package br.ucsal.h4h.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ucsal.h4h.dao.UsuarioDAO;
import br.ucsal.h4h.model.Usuario;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {
	
     
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("usuarioForm.jsp").forward(request, response);
		} else {
			UsuarioDAO dao = new UsuarioDAO();
			request.setAttribute("listaUsuario", dao.listar());
			request.getRequestDispatcher("usuarioList.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");	
		
		Usuario u = new Usuario( );
		u.setLogin(login);
		u.setSenha(senha);
		u.setEmail(email);
		UsuarioDAO dao = new UsuarioDAO();
		dao.inserir(u);
		
			
		request.setAttribute("listaUsuario", dao.listar());
		request.getRequestDispatcher("usuarioList.jsp").forward(request, response);
	}

}
