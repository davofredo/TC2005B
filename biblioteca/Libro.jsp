<%@ page import="java.io.*" %>
<%--<%@ page import="modelLibro.LibroADjdbc" %>--%>

<jsp:useBean id="libro" class="modelLibro.BiblioADjdbc" />
<jsp:useBean id="librodp" class="modelLibro.LibroDP" />

<%--<jsp:setProperty name="libro" property="*" />--%>
<jsp:setProperty name="librodp" property="*" />

<%
    if (request.getParameter("bCapturar") == null && request.getParameter("bConsultar") == null && request.getParameter("bConsultarEditorial") == null && request.getParameter("bConsultarTitulo") == null){
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head><title>WEB Server Tomcat</title></head>
    <body>
        <h1>Bibliteca TEC:</h1><p></p>
        <!--<form action='../biblioteca/libro' method='get'>-->
        <form action='../biblioteca/Libro.jsp' method='get'>
        	TITULO:    <input type='text' name='titulo' value=''><br/>
        	AUTOR:     <input type='text' name='autor' value=''><br/>
        	EDITORIAL: <input type='text' name='editorial' value=''><br/>
        			   <input type='submit' name='bCapturar' value='Capturar Datos'>
        			   <input type='submit' name='bConsultar' value='Consultar Libros'>
        			   <input type='submit' name='bConsultarEditorial' value='Consultar Editorial'>
        			   <input type='submit' name='bConsultarTitulo' value='Consultar Titulo'>
        </form>
    </body>
</html>
<%
    }
    else {
        //LibroADjdbc libro = new LibroADjdbc();

        String datos, respuesta;
        if(request.getParameter("bCapturar") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=Capturar datos...");
            // Obtener los datos URL string
			//datos = obtenerDatos(request);
            datos = librodp.toString();

			// Capturar los datos en la DB
			//respuesta = Libro.capturar(datos);
			respuesta = libro.capturar(librodp);
            //respuesta = datos;

			// Enviar al Server el resultado de la transaccion
			response.sendRedirect("RespuestaServer.jsp?datos=" + respuesta);
        }
        if(request.getParameter("bConsultar") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=Cconsultar datos...");
            // 1. Consultar datos de la DB
			datos = libro.consultarLibros();

			// 2. Mostrar los datos
			//response.sendRedirect("RespuestaServer.jsp?datos=" + datos);
			respuestaServer(response, datos);
        }
        if(request.getParameter("bConsultarEditorial") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=ConsultarNcta datos...");
            // Obtener el editorial de cuenta a consultar
			//String ncta = request.getParameter("titulo");
			String editorial = librodp.getEditorial();

			// Consultar cliente con ese editorial de cuenta
			datos = libro.consultarEditorial(editorial);

			// Mostrar los datos
			//response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
%>
    <jsp:forward page='RespuestaServer1.jsp'>
        <jsp:param name='datos' value='<%=datos%>' />
    </jsp:forward>
<%
        }
        if(request.getParameter("bConsultarTitulo") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=Consultar editorial datos...");
            // Obtener el editorial de cuenta a consultar
			//String tcta = request.getParameter("editorial");
			String titulo = librodp.getTitulo();

			// Consultar cliente con ese editorial de cuenta
			datos = libro.consultarTitulo(titulo);

			// Mostrar los datos
			//response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
%>
    <jsp:forward page='RespuestaServer1.jsp'>
        <jsp:param name='datos' value='<%=datos%>' />
    </jsp:forward>
<%
        }
    }
%>
<%!
    // Metodos
	private String obtenerDatos(HttpServletRequest request){
		String titulo, autor, editorial;
		titulo = request.getParameter("titulo");
		autor = request.getParameter("autor");
		editorial = request.getParameter("editorial");

		String datos = titulo + "_" + autor + "_" + editorial;

		return datos;
	}

    private void respuestaServer(HttpServletResponse response, String datosJson) throws IOException {
        PrintWriter salidaServer = response.getWriter();
        response.setContentType("text/plain");

        salidaServer.println(datosJson);
    }
%>