<%@ page import="java.io.*" %>
<%--<%@ page import="modelBanco.BancoADjdbc" %>--%>

<jsp:useBean id="banco" class="modelBanco.BancoADjdbc" />
<jsp:useBean id="clientedp" class="modelBanco.ClienteDP" />

<%--<jsp:setProperty name="banco" property="*" />--%>
<jsp:setProperty name="clientedp" property="*" />

<%
    if (request.getParameter("bCapturar") == null && request.getParameter("bConsultar") == null && request.getParameter("bConsultarNcta") == null && request.getParameter("bConsultarTipo") == null){
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Apache y CGIs</title>
</head>
<body>
    <h2>Banco IoT</h2>
    <!--<form action='../cgi-bin/ClienteController.py' method='get'>-->
    <!--<form action='../banco/banco' method='get'>-->
    <form action='../bancoJsp/Cliente.jsp' method='get'>
        NO. CUENTA:  <input type='text' name='nocta'><br />
        NOMBRE:      <input type='text' name='nombre'><br />
        TIPO CUENTA: <input type='text' name='tipo'><br />
        SALDO:       <input type='text' name='saldo'><br /><br />
        <input type='submit' name='bCapturar' value='Capturar datos'>
        <input type='submit' name='bConsultar' value='Consultar clientes'>
        <input type='submit' name='bConsultarNcta' value='Consultar No Cuenta'>
        <input type='submit' name='bConsultarTipo' value='Consultar tipo cuenta'>
    </form>
</body>
</html>
<%
    }
    else {
        //BancoADjdbc banco = new BancoADjdbc();

        String datos, respuesta;
        if(request.getParameter("bCapturar") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=Capturar datos...");
            // Obtener los datos URL string
			//datos = obtenerDatos(request);
            datos = clientedp.toString();

			// Capturar los datos en la DB
			//respuesta = banco.capturar(datos);
			respuesta = banco.capturar(clientedp);
            //respuesta = datos;

			// Enviar al Server el resultado de la transaccion
			response.sendRedirect("RespuestaServer.jsp?datos=" + respuesta);
        }
        if(request.getParameter("bConsultar") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=Cconsultar datos...");
            // 1. Consultar datos de la DB
			datos = banco.consultar();

			// 2. Mostrar los datos
			//response.sendRedirect("RespuestaServer.jsp?datos=" + datos);
			respuestaServer(response, datos);
        }
        if(request.getParameter("bConsultarNcta") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=ConsultarNcta datos...");
            // Obtener el tipo de cuenta a consultar
			//String ncta = request.getParameter("nocta");
			String ncta = clientedp.getNocta();

			// Consultar cliente con ese tipo de cuenta
			datos = banco.consultarNcta(ncta);

			// Mostrar los datos
			//response.sendRedirect("RespuestaServer1.jsp?datos=" + datos);
%>
    <jsp:forward page='RespuestaServer1.jsp'>
        <jsp:param name='datos' value='<%=datos%>' />
    </jsp:forward>
<%
        }
        if(request.getParameter("bConsultarTipo") != null) {
            //response.sendRedirect("RespuestaServer.jsp?datos=Consultar Tipo datos...");
            // Obtener el tipo de cuenta a consultar
			//String tcta = request.getParameter("tipo");
			String tcta = clientedp.getTipo();

			// Consultar cliente con ese tipo de cuenta
			datos = banco.consultarTipo(tcta);

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
		String nocta, nombre, tipo, saldo;
		nocta = request.getParameter("nocta");
		nombre = request.getParameter("nombre");
		tipo = request.getParameter("tipo");
		saldo = request.getParameter("saldo");

		String datos = nocta + "_" + nombre + "_" + tipo + "_" + saldo;

		return datos;
	}

    private void respuestaServer(HttpServletResponse response, String datosJson) throws IOException {
        PrintWriter salidaServer = response.getWriter();
        response.setContentType("text/plain");

        salidaServer.println(datosJson);
    }
%>