import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class ServletLibro extends HttpServlet
{
	private void respuestaServer(HttpServletResponse response, String imagen) throws IOException {
		PrintWriter enviarServer = response.getWriter();
		response.setContentType("text/html");

		enviarServer.println("<html>");
		enviarServer.println("<head>");
		enviarServer.println("<title>WEB Server Tomcat</title>");
		enviarServer.println("</head>");
		enviarServer.println("<body>");
		enviarServer.println("<h1>Imagen Libro:</h1><p>");
		enviarServer.println("<hr>");
		enviarServer.println("<image align='center' alt='IMAGEN' src='../basicos/"+imagen+"/COSMOS.jpg'>");
		enviarServer.println("</body>");
		enviarServer.println("</html>");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// Obtener titulo del libro
		String imagen = request.getParameter("titulo");

		// Enviar al Servlet el código HTML con la imagen del libro correspondiente
		//respuestaServer(response, imagen);
		response.sendRedirect("RespuestaServer.jsp?titulo="+imagen);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}