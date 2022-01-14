package Acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

public class NovaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		try {
			empresa.setData(sdf.parse(dataAbertura));
		} catch (ParseException e) {
			throw new ServletException(e.getMessage());
		}
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		return "redirect:Entrada?acao=ListaEmpresas";

	}
}
