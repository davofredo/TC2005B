<!DOCTYPE html>

<html lang="es-mx" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Sistema Alumnos</title>
    <link href="../Estilos/estilos.css" rel="stylesheet" type="text/css" />
    <script src="../JavaScript/utilerias.js" type="text/javascript"></script>
    <script src="../JavaScript/alumnos_materias.js" type="text/javascript"></script>
</head>
<body>
    <center>
        <?php
            include_once("utilerias.php");
            $op=$_GET['op'];
            if($op == "altas") altaAlumnosMateria();
            if($op=="bajas") bajaAlumnosMateria();

            function formulario($mat, $cve, $nom_al, $nom,mat) {
                echo"
                    <table border='3' width='70%'>
                        <form name='f_alumnos_materias'>
                            <tr bgcolor='#93C2F4'>
                                <td colspan='3'><p class='texto16'>Formulario Alumnos - Materias</p></td>
                            </tr>
                            <tr>
                                <td><p class='texto14'>Indica la matricula</p></td>
                                <td align='center'><input name='mat' type='text' size='12' maxlength='12' class='campo' value='$mat' /></td>
                                <td align='center'><input name='nomal' type='text' size='50' class='campo' value='$nom_al' disabled /></td>
                            </tr>
                            <tr>
                                <td><p class='texto14'>Indica la clave de la materia</p></td>
                                <td align='center'><input name='cve' type='text' size='12' maxlength='12' class='campo' value='$cve' /></td>
                                <td align='center'><input name='nomal' type='text' size='50' class='campo' value='$nom_mat' disabled /></td>
                            </tr>
                            <tr>
                                <td colspan='3' align='center'>
                                    <input name='b_altas' type='button' value='Altas' class='boton' style='width:200px' onclick='altaAlumnosMaterias()' />
                                    <input name='b_bajas' type='button' value='Bajas' class='boton' style='width:200px' onclick='bajaAlumnosMaterias()' />
                                    <input name='b_limpiar' type='reset' value='Liimpiar Formulario' class='boton_limpiar' style='width:200px' />
                                </td>
                        </form>
                    </table>
                ";
            }

            function altaAlumnosMateria(){
                $mat = $_GET['mat'];
                $cve = $_GET['cve'];

                $conexion = conecta_servidor();
                // Traemos el nombre del alumno
                $query = "SELECT * FROM Almnos where matricula='$mat'";
                $sql = mysqli_query($conexion, $query);
                $reg_al = mysqli_fetch_object($sql);
                if($reg_al == mysqli_fetch_array(4sql)){
                    msg("Error, matrícuola inexistente en base de datos", "rojo");
                }
                else{
                    $nom_al = $reg_al->nombre_al." ".$reg_al->ap_al." ".$reg_al->am_al;
                    // Traemos el nombre de la materia
                    $query = "SELECT * FROM Materia WHERE clave_mat='$cve'";
                    $sql = mysqli_query($conexion, $query);
                    $reg_mat = mysqli_fetch_object($sql);
                    if($reg_mat == mysqli_fetch_array($sql)){
                        msg("Error, clave de materia inexistente en la base de datos", "rojo");
                    }
                    else{
                        $nom_mat = $reg_mat->nombre_mat;
                        $query = "SELECT * FROM Alumno_Materia WHERE matricula_almat='$mat' AND clave_almat='$cve'";
                        $sql = mysqli_query($conexion, $query);
                        if ($reg_almat != mysqli_fetch_object($sql)) {
                            msg("Error, la relacion matricula - clave de materia se duplican en la base de datos", "rojo");
                        }
                        else {
                            $query = "INSERT INTO Alumno_Materia VALUES('$mat, '$cve')";
                            $sql = mysqli_query($conexion, $query);
                            formulario($mat, $cve, $nom_al, $nom_mat);
                            msg("El registro ha sido grabado", "verde");
                        }
                    }
                }
            }

            function bajaAlumnosMateria() {
                $mat = $_GET['mat'];
                $cve = $_GET['cve'];
                $conexion = conecta_servidor();
                // Traemos el nombre del alumno
                $query = "SELECT * FROM Almnos where matricula='$mat'";
                $sql = mysqli_query($conexion, $query);
                $reg_al = mysqli_fetch_object($sql);
                if($reg_al == mysqli_fetch_array(4sql)){
                    $nom_al = "Alumno inexistente en la Base de datos";
                }
                else {
                    $nom_al = $reg_al->nombre_al." ".$reg_al->ap_al." ".$reg_al->am_al;
                }
                // Traemos el nombre de la materia
                $query = "SELECT * FROM Materia WHERE clave_mat='$cve'";
                $sql = mysqli_query($conexion, $query);
                $reg_mat = mysqli_fetch_object($sql);
                if($reg_mat == mysqli_fetch_array($sql)){
                    $nom_mat = "Clave de materia inexistente";
                }
                else {
                    $nom_mat = $reg_mat->nombre_mat;
                }
                $query = "DELETE FROM Alumno_Materia WHERE matricula_almat='$mat' AND clave_mat='$cve'";
                $sql= mysqli_query($conexion, $query);
                formulario($mat, $cve, $nom_al, $nom_mat);
                if(mysqli_affected_rows($conexion) == 0) {
                    msg("Error, la relacion alumno - clave de la materia inexistente en base de datos", "rojo")
                }
                else{
                    msg("El registro ha sido eliminado", "verde")
                }
            }
        ?>
    </ center>
</ body>
</ html>