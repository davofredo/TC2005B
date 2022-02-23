<!DOCTYPE html>
<html lang="es-mx" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <title>Sistema Alumnos</title>
        <link href="estilos/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <center>
        <?php
            include_once("utilerias.php");
            $op=$_GET['op'];
            if($op == "altas") bajaAlumnos();
            if($op=="bajas") bajaAlumnos();
            if($op=="consultas")consultaAlumnos();
            if($op=="cambios")cambioAlumnos();

            function altaAlumnos(){
            	$mat = $_GET['mat'];
            	$nom = $_GET['nom'];
            	$ap = $_GET['ap'];
            	$am = $_GET['am'];
            	$car = $_GET['car'];
            	$prom = $_GET['prom'];

            	$conexion = conecta_servidor();
                $QUERY = "INSERT INTO Alumnos VALUES ('$mat','$nom','$ap','$am','$car',$prom)";
                $sql = mysqli_query($conexion,$query);
                if(!$sql){
                msg("Error la matricula se duplica en la base de datos","rojo");
                }
                else{
                 msg("El registro se ha grabado correctamente","verde");
                }
            }
            
            function bajas_alumnos(){
                $mat=$_GET['mat'];
                $conexion = conecta_servidor();
                $query="DELETE FROM Alumno WHERE matricula_al='$mat'";
                $sql=mysqli_query($conexion,$query);
                if(mysqli_affected_rows($conexion)=00){
                    msg("Error, matricula inexistente en base de datos", "rojo");
                }
                else{
                    msg("Correcto, matricula inexistente en base de datos", "verde");
                }
            }
            
            function formulario($mat, $nom, $ap, $am, $car, $prom){
                echo "
                    <table border='3' width='70%'>
					    <tr bgcolor='#93C2F4'>
					    	<td colspan='2'> <p class='texto16'>Consultas de alumnos </p> </td>
					    </tr>
					    <tr>
					    	<td><p class='texto14'>Indica la matrícula</p></td>
					    	<td align='center'><input name='mat' type='text' size='9' class='campo' value='$mat'></td>
					    </tr>
					    <tr>
					    	<td><p class='texto14'>Indica el(los) nombre(s)</p></td>
					    	<td align='center'><input name='nom' type='text' size='30' class='campo' value='$nom'></td>
					    </tr>
					    <tr>
					    	<td><p class='texto14'>Indica el Apellido Paterno </p></td>
					    	<td align='center'><input name='ap' type='text' size='30' class='campo' value='$ap'></td>
					    </tr>
					    <tr>
					    	<td><p class='texto14'>Indica el Apellido Materno </p></td>
					    	<td align='center'><input name='am' type='text' size='30' class='campo' value='$am'></td>
					    </tr>
					    <tr>
					    	<td><p class='texto14'>Indica la carrera </p></td>
					    	<td align='center'><input name='car' type='text' size='5' class='campo' value='$car'></td>
					    </tr>
					    <tr>
					    	<td><p class='texto14'>Indica el promedio </p></td>
					    	<td align='center'><input name='prom' type='number' size='5' class='campo' value='$prom'></td>
					    </tr>
				    </table>
			    ";
            }
            
            function consulta_alumnos(){
                $mat= $_GET['mat'];
                $conexion = conecta_servidor();
                $query = "SELECT * FROM Alumnos WHERE matricula='$mat'";
                $sql = mysqli_query($conexion, $query);
                $reg = mysqli_fetch_object($sql);
                if($reg == mysqli_fetch_array($sql))
                    msg("Error, matricula inexistente en base de datos","rojo");
                }
                else{
                    formulario($mat, $reg->nombre_al, $reg->ap_al,$reg->am_al,$reg->carrera_al,$reg->promedio_al);
                    msg("Consulta realizada","verde");
                }
            }

            function cambio_alumno(){
                $mat=$_GET['mat'];
                $car=$_GET['car'];
                $prom=$_GET['prom'];
                $conexion=conecta_servidor();
                $query = "UPDATE alumnos SET carrera='$car', promedio='$prom' WHERE matricula='$mat'";
                $sql = mysqli_query($conexion, $query);
                if(mysqli_affected_rows($conexion) == 0){
                    msg("Error matricula inexistente en la base de datos", "rojo");
                }
                else{
                    msg("El cambio ha sido realizado", "verde");
                }
            }
        ?>
        </ center>
    </ body>
</ html>