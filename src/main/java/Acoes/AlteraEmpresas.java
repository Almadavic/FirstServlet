package Acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

public class AlteraEmpresas implements Acao {

	
	public String executa(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	

		String paramNomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		System.out.println("Altera empresa "+id);
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);

		} catch (ParseException e) {
			throw new ServletException(e.getMessage());
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(paramNomeEmpresa);
		empresa.setData(dataAbertura);

		return "redirect:Entrada?acao=ListaEmpresas";
	}
	
	
}
