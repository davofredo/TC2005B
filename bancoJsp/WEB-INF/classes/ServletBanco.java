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

	private void respuestaServer(HttpServletResponse response, String datosJson) throws IOException{
		PrintWriter salidaServer = response.getWriter();
		response.setContentType("text/plain");

		salidaServer.println(datosJson);
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
			response.sendRedirect("RespuestaServer.jsp?datos=" + respuesta);
		}
		if (transaccion.equals("Consultar clientes")) {
			// 1. Consultar datos de la DB
			datos = banco.consultar();

			// 2. Mostrar los datos
			//response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
			respuestaServer(response, datos);
		}
		if (transaccion.equals("Consultar tipo cuenta")) {
			// Obtener el tipo de cuenta a consultar
			String tcta = request.getParameter("tipo");

			// Consultar cliente con ese tipo de cuenta
			datos = banco.consultarTipo(tcta);

			// Mostrar los datos
			response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
		}
		if (transaccion.equals("Consultar No Cuenta")) {
			// Obtener el tipo de cuenta a consultar
			String ncta = request.getParameter("nocta");

			// Consultar cliente con ese tipo de cuenta
			datos = banco.consultarNcta(ncta);

			// Mostrar los datos
			response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}