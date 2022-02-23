import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class ServletLibro extends HttpServlet
{
	// Atributos
	private BiblioADjdbc libro = new BiblioADjdbc();

	// Metodos
	private String obtenerDatos(HttpServletRequest request){
		String titulo, autor, editorial;
		titulo = request.getParameter("titulo");
		autor = request.getParameter("autor");
		editorial = request.getParameter("editorial");

		String datos = titulo + "_" + autor + "_" + editorial;

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
			respuesta = libro.capturar(datos);

			// Enviar al Server el resultado de la transaccion
			response.sendRedirect("RespuestaServer.jsp?datos=" + respuesta);
		}
		if (transaccion.equals("Consultar libros")) {
			// 1. Consultar datos de la DB
			datos = libro.consultarLibros();

			// 2. Mostrar los datos
			//response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
			respuestaServer(response, datos);
		}
		if (transaccion.equals("Consultar editorial")) {
			// Obtener el editorial de cuenta a consultar
			String editorial = request.getParameter("editorial");

			// Consultar cliente con ese editorial de cuenta
			datos = libro.consultarEditorial(editorial);

			// Mostrar los datos
			response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
		}
		if (transaccion.equals("Consultar titulo")) {
			// Obtener el editorial de cuenta a consultar
			String titulo = request.getParameter("titulo");

			// Consultar cliente con ese editorial de cuenta
			datos = libro.consultarTitulo(titulo);

			// Mostrar los datos
			response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}