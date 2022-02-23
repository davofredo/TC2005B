package modelBanco;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.StringTokenizer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import com.cedarsoftware.util.io.JsonWriter;

public class BancoADjdbc
{
	private PrintWriter archivoOut;
	private BufferedReader archivoIn;

	private Connection conexion;
	private Statement statement;
	
	private ClienteDP clientedp;

	public  BancoADjdbc(){
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//conexion = DriverManager.getConnection("jdbc:mysql://localhost/Banco?user=root");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/Banco?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			System.out.println("Conexion exitosa a la BD...");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Error 1: " + cnfe);
		}
		catch(InstantiationException ie){
			System.out.println("Error 2: " + ie);
		}
		catch(IllegalAccessException iae){
			System.out.println("Error 3:" + iae);
		}
		catch(SQLException sqle){
			System.out.println("Error 4:" + sqle);
		}
	}

	//public String capturar(String datos)
	public String capturar(ClienteDP clientedp)
	{
		String resultado = "";
		String insertCliente;
		String ncta, nombre, tipo, saldo;
		StringTokenizer st;

		// Prepara el insert a ejecutar

		//insertCliente = "INSERT INTO Cliente VALUES('" + ncta + "','" + nombre + "','" + tipo + "'," + saldo + ")";
		//clientedp = new ClienteDP(datos);
		insertCliente = "INSERT INTO Cliente VALUES(" + clientedp.toStringSQL() + ")";

		try{
			// Abrir el archivo para almacenar los datos
			statement = conexion.createStatement();

			// Guardar o almaccenar los datos
			statement.executeUpdate(insertCliente);

			// Cerrar el archivo
			statement.close();

			resultado = "Datos capturados...";

			System.out.println(insertCliente);
		}
		catch(SQLException sqle){
			resultado = "Error al abrir la BD o ejecutar el INSERT..." + sqle;
			System.out.println("Error: " + sqle);
		}
		
		return resultado;
	}

	public String consultar(){
		String datos = "[";
		ResultSet trCliente;
		String ncta, nombre, tipo, saldo;
		String query;

		query = "SELECT * FROM Cliente";

		try{
			// Abrir el archivo
			statement = conexion.createStatement();

			// Procesar el archivo para obtener los datos
			trCliente = statement.executeQuery(query);

			clientedp = new ClienteDP();

			while(trCliente.next()){
				clientedp.setNocta(trCliente.getString("nocta"));
				clientedp.setNombre(trCliente.getString("nombre"));
				clientedp.setTipo(trCliente.getString(3));
				clientedp.setSaldo(trCliente.getInt(4));

				//datos = datos + clientedp.toString() + "\n";
				//datos = datos + clientedp.toStringHTML();
				//datos = datos + clientedp.toStringJSON() + ",";
				datos = datos + JsonWriter.objectToJson(clientedp) + ",";
			}
			//datos = datos + "]";
			datos = datos.substring(0, datos.length() - 1) + "]";

			// Cerrar el archivo
			statement.close();
		}
		catch(SQLException sqle){
			datos = "Error al abrir la DB";
			System.out.println("Error: " + sqle);
		}

		return datos;
	}

	public String consultarTipo(String tcta){
		String datos = "";
		String ncta, nombre, tipo, saldo;
		boolean encontrado = false;
		ResultSet trCliente;

		String query = "SELECT * FROM Cliente WHERE tipo ='" + tcta + "'";

		try{
			// Abrir el archivo
			statement = conexion.createStatement();

			// Procesar el archivo
			trCliente = statement.executeQuery(query);

			clientedp = new ClienteDP();

			while(trCliente.next()){
				clientedp.setNocta(trCliente.getString("nocta"));
				clientedp.setNombre(trCliente.getString("nombre"));
				clientedp.setTipo(trCliente.getString(3));
				clientedp.setSaldo(trCliente.getInt(4));

				//datos = datos + clientedp.toString() + "\n";
				datos = datos + clientedp.toStringHTML();

				encontrado = true;
			}
			
			// Cerrar el archivo
			statement.close();

			if(!encontrado)
				datos = "No se localizó el tipo " + tcta;

				System.out.println(query);
		}
		catch(SQLException sqle){
			datos = "Error: " + sqle;
			System.out.println("Error: " + sqle);
		}
		return datos;
	}

	public String consultarNcta(String nocta){
		String datos = "";
		String ncta, nombre, tipo, saldo;
		boolean encontrado = false;
		ResultSet trCliente;

		String query = "SELECT * FROM Cliente WHERE nocta ='" + nocta + "'";

		try{
			// Abrir el archivo
			statement = conexion.createStatement();

			// Procesar el archivo
			trCliente = statement.executeQuery(query);

			clientedp = new ClienteDP();

			while(trCliente.next()){
				clientedp.setNocta(trCliente.getString("nocta"));
				clientedp.setNombre(trCliente.getString("nombre"));
				clientedp.setTipo(trCliente.getString(3));
				clientedp.setSaldo(trCliente.getInt(4));

				//datos = datos + clientedp.toString() + "\n";
				datos = datos + clientedp.toStringHTML();

				encontrado = true;
			}
			
			// Cerrar el archivo
			statement.close();

			if(!encontrado)
				datos = "No se localizó el ncta " + nocta;

				System.out.println(query);
		}
		catch(SQLException sqle){
			datos = "Error: " + sqle;
			System.out.println("Error: " + sqle);
		}
		return datos;
	}
}
