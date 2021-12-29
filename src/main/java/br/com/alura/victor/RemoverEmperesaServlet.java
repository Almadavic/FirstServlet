package br.com.alura.victor;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/removeEmpresa")
public class RemoverEmperesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String paramId = request.getParameter("id");
	 int id = Integer.parseInt(paramId);
	 
	 System.out.println(id);
	 
	 Banco banco = new Banco();
	 banco.removeEmpresa(id);
	 
	 response.sendRedirect("listaEmpresas");
		
	}
	
	

}
