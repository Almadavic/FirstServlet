package Acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

public class MostraEmpresas implements Acao {

	
	public String executa(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Mostrando empresa");
		
		String paramId = request.getParameter("id");
		 Integer id = Integer.valueOf(paramId);
		 
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
		
	}
	
	
}
