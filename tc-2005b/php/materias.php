!DOCTYPE html>

<html lang="es-mx" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Sistema Alumnos</title>
    <link href="../Estilos/estilos.css" rel="stylesheet" type="text/css" />
    <script src="../JavaScript/utilerias.js" type="text/javascript"></script>
    <script src="../JavaScript/materias.js" type="text/javascript"></script>
</head>
<body>
    <center>
    <?php
        include_once("utilerias.php")
        $op = $_GET['op'];
        if($op == "altas") altaMaterias();
        if($op == "bajas") bajaMaterias();

        function altaMaterias(){
            $cve = $_GET['cve'];
            $nom = $_GET['nom'];
            $cre = $_GET['ap'];
            $per = $_GET['am'];

            $conexion = conecta_servidor();
             $QUERY = "INSERT INTO Materias VALUES ('$cve','$nom','$cre','$per')";
             $sql = mysqli_query($conexion,$query);
             if(!$sql){
             msg("Error la clave se duplica en la base de datos","rojo");
             }
             else{
              msg("El registro se ha grabado correctamente","verde");
             }
        }

        function bajaMaterias(){
            $cve = $_GET['cve'];
            $conexion = conecta_servidor();
            $query="DELETE FROM Materias WHERE clave='$cve'";
            $sql=mysqli_query($conexion,$query);
            if(mysqli_affected_rows($conexion)=00){
                msg("Error, clave inexistente en base de datos", "rojo");
            }
            else{
                msg("Correcto, clave inexistente en base de datos", "verde");
            }
        }

        function formulario($cve, $nom, $cre, $per){
            echo"
                <table border='3' width='70%'>
                    <form name='f_materias'>
                        <tr bgcolor='#93C2F4'>
                            <td colspan='2'><p class='texto16'>Formulario Materias</p></td>
                        </tr>
                        <tr>
                            <td><p class='texto14'>Indica la clave de la materia</p></td>
                            <td align='center'><input name='cve' type='text' size="12" maxlength='12' class='campo' value='$cve' /></td>
                        </tr>
                        <tr>
                            <td><p class='texto14'>Indica el nombre de la materia</p></td>
                            <td align='center'><input name='nom' type='text' size="12" maxlength='12' class='campo' disabled /></td>
                        </tr>
                        <tr>
                            <td><p class='texto14'>Indicalos creditos de la materia</p></td>
                            <td align='center'><input name='nom' type='text' size="12" maxlength='12' class='campo' disabled /></td>
                        </tr>
                        <tr>
                            <td><p class='texto14'>Indica los periodos la materia</p></td>
                            <td align='center'><input name='nom' type='text' size="12" maxlength='12' class='campo' disabled /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input name='b_consultas' type='button' value='Consultas' class='boton' style='width:200px' onclick='consultaMaterias()' />
                                <input name='b_limpiar' type='reset' value='Liimpiar Formulario' class='boton' style='width:200px' />
                            </td>
                        </tr>
                    </form>
                </table>
            ";
        }

        function consultaMaterias(){
            $cve = $_GET['cve'];
            $conexion = conecta_servidor();
            $query="SELECT * FROM Materias WHERE clave='$cve'";
            $sql=mysqli_query($conexion,$query);
            $reg = mysqli_fetch_object($sql);
            if($reg == mysqli_fetch_array($sql)){
                msg("Error, lave de la materia inexistente en base de datos", "rojo")
            }
            else{
                formulario($cve, $reg->nom, $reg->cre,$reg->per);
                    msg("Consulta realizada","verde");
            }
        }
    ?>
    </center>
</body>
</html>