package br.com.fernando.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fernando.DB.Categoria;
import br.com.fernando.DB.CategoriaDAO;
import br.com.fernando.DB.Cliente;
import br.com.fernando.DB.ClienteDAO;

@WebServlet("/Cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClienteServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("delete") != null){
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(request.getParameter("delete")));
			
			ClienteDAO dao = new ClienteDAO();
			dao.delete(cliente);
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("update") != null){
			int id = Integer.parseInt(request.getParameter("update"));
			String nome = request.getParameter("txtNome");
			String sobrenome = request.getParameter("txtSobrenome");
			int cbCatId = Integer.parseInt(request.getParameter("cbCat"));
			
			CategoriaDAO daoCat = new CategoriaDAO();
			
			Cliente cliente = new Cliente();
			cliente.setId(id);
			cliente.setNome(nome);
			cliente.setSobrenome(sobrenome);
			cliente.setCat(daoCat.getById(cbCatId));
			
			ClienteDAO dao = new ClienteDAO();
			dao.update(cliente);
			response.sendRedirect("index.jsp");
			
		} else {
			String nome = request.getParameter("txtNome");
			String sobrenome = request.getParameter("txtSobrenome");
			int cbCatId = Integer.parseInt(request.getParameter("cbCat"));
			
			CategoriaDAO daoCat = new CategoriaDAO();

			
			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setSobrenome(sobrenome);
			cliente.setCat(daoCat.getById(cbCatId));
			
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			response.sendRedirect("index.jsp");
		}
	}
}
