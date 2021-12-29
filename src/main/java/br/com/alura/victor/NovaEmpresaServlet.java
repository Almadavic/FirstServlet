package br.com.alura.victor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		try {
		empresa.setData(sdf.parse(dataAbertura));
		}catch(ParseException e) {
			throw new ServletException(e.getMessage());
		} finally {
		Banco banco = new Banco();
		banco.adiciona(empresa);

		
		response.sendRedirect("listaEmpresas");
		
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		//request.setAttribute("empresa", empresa.getNome());
		//rd.forward(request, response);

		}
		
	}

}
