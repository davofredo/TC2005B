<?php
	function conecta_servidor(){
		$conexion = mysqli_connect("localhost","root","","tc2005b_ene2021");
		return $conexion;
	}
	function msg($mensaje, $color){
		echo "<table border='3' width='60%'>";
		if($color=="rojo") echo "<tr bgcolor='red' align='center' >";
		if($color=="amarillo") echo "<tr bgcolor='yellow' align='center' >";
		if($color=="verde") echo "<tr bgcolor='green' align='center' >";
		echo"
			<td><font color='white' size='6'><b>$mensaje</b></font></td>
				</tr>
				<tr align='center'>
					<td><font color='blue' size='6'><b>Para continuar selecciona los botones del menú</b></font></td>
				</tr>
			</table>
		";
	}
?>