package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import Modelo.Banco;
import Modelo.Empresa;

@WebServlet("/empresas")
public class ListaEmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String valor = request.getHeader("Accept");
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		
		if(valor.endsWith("xml")) {
		XStream xstream = new XStream();
		String xml = xstream.toXML(empresas);

		response.setContentType("application/xml");
		response.getWriter().print(xml);
		
		} else if(valor.endsWith("json")) {
			
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		} else {
			
			response.getWriter().print("noContent");
			
		}

	}

}
