import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class ServletBanco extends HttpServlet
{
	// Atributos
	private BancoADjdbc banco = new BancoADjdbc();

	// Metodos
	private String obtenerDatos(HttpServletRequest request){
		String nocta, nombre, tipo, saldo;
		nocta = request.getParameter("nocta");
		nombre = request.getParameter("nombre");
		tipo = request.getParameter("tipo");
		saldo = request.getParameter("saldo");

		String datos = nocta + "_" + nombre + "_" + tipo + "_" + saldo;

		return datos;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String transaccion, datos, respuesta;

		// Obtener transaccion
		transaccion = request.getParameter("boton");

		// Checar y ejecutar la transaccion correspondiente
		if (transaccion.equals("Capturar datos")) {
			// Obtener los datos URL string
			datos = obtenerDatos(request);

			// Capturar los datos en la DB
			respuesta = banco.capturar(datos);

			// Enviar al Server el resultado de la transaccion
			response.sendRedirect("RespuestaServer1.jsp?datos="+datos);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}