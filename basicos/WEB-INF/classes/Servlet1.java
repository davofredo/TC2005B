// HttpServlet, HttpServletRequest, HttpServletResponse: javax.servlet.http.*
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class Servlet1 extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter salidaServer = response.getWriter();
		response.setContentType("text/html");

		salidaServer.println("<html>");
		salidaServer.println("<head>");
		salidaServer.println("<title>WEB Server Tomcat</title>");
		salidaServer.println("<body>");
		salidaServer.println("<h1>Java Servlet</h1><p>");
		salidaServer.println("<hr>");
		salidaServer.println("<h2>Primer Servlet</h3><p>");
		salidaServer.println("<hr>");
		salidaServer.println("<h3>Java Servlet Programming</h3><p>");
		salidaServer.println("</body>");
		salidaServer.println("</head>");
		salidaServer.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}