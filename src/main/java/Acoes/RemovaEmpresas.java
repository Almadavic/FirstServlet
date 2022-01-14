package Acoes;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;

public class RemovaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Removendo empresa");

		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

          return "redirect:Entrada?acao=ListaEmpresas";
	}

}
