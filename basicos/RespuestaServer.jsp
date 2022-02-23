<%
    String imagen = request.getParameter("titulo");
%>

<html>
<head>
    <title>WEB Server Tomcat</title>
</head>
<body>
    <h1>Imagen Libro:</h1><p>
        <hr>
        <image align='center' alt='IMAGEN' src='../basicos/images/<%= imagen %>.jpg'>
</body>
</html>
