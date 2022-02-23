import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.StringTokenizer;

public class BancoAD
{
	private PrintWriter archivoOut;
	private BufferedReader archivoIn;

	public String capturar(String datos)
	{
		String resultado = "";

		try{
			// Abrir el archivo para almacenar los datos
			archivoOut = new PrintWriter(new FileWriter("Clientes.txt", true));

			// Guardar o almaccenar los datos
			archivoOut.println(datos);

			// Cerrar el archivo
			archivoOut.close();

			resultado = "Datos capturados...";
		}
		catch(IOException ioe){
			resultado = "Error con el archivo";
			System.out.println("Error: " + ioe);
		}
		
		return resultado;
	}

	public String consultar(){
		String datos = "";
		String cliente;

		try{
			// Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Clientes.txt"));

			// Procesar el archivo para obtener los datos
			while(archivoIn.ready()){
				cliente = archivoIn.readLine();
				
				System.out.println(cliente);
				
				datos += cliente + "\n";
			}

			// Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe){
			datos = "Error al abrir el archivo";
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe){
			datos = "Error al cerrar el archivo";
			System.out.println("Error: " + ioe);
		}
		return datos;
	}

	public String consultarTipo(String tcta){
		String datos = "";
		String cliente;
		StringTokenizer stCliente;
		String ncta, nombre, tipo, saldo;
		boolean encontrado = false;

		try{
			// Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Clientes.txt"));

			// Procesar el archivo
			while(archivoIn.ready()){
				cliente = archivoIn.readLine();

				stCliente = new StringTokenizer(cliente, "_");
				ncta = stCliente.nextToken();
				nombre = stCliente.nextToken();
				tipo = stCliente.nextToken();
				saldo = stCliente.nextToken();

				if(tcta.equals(tipo)){
					datos += cliente + "\n";
					encontrado = true;
				}
			}
			
			// Cerrar el archivo
			archivoIn.close();
			if(!encontrado)
				datos = "No se localizó el tipo " + tcta;
		}
		catch(FileNotFoundException fnfe){
			datos = "Error al abrir el archivo";
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe){
			datos = "Error al cerrar el archivo";
			System.out.println("Error: " + ioe);
		}
		return datos;
	}

	public String consultarNcta(String ncta){
		String datos = "";
		String cliente;
		StringTokenizer stCliente;
		String cuenta, nombre, tipo, saldo;
		boolean encontrado = false;

		try{
			// Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Clientes.txt"));

			// Procesar el archivo
			while(archivoIn.ready()){
				cliente = archivoIn.readLine();

				stCliente = new StringTokenizer(cliente, "_");
				cuenta = stCliente.nextToken();
				nombre = stCliente.nextToken();
				tipo = stCliente.nextToken();
				saldo = stCliente.nextToken();

				if(cuenta.equals(ncta)){
					datos += cliente + "\n";
					encontrado = true;
				}
			}
			
			// Cerrar el archivo
			archivoIn.close();
			if(!encontrado)
				datos = "No se localizó el tipo " + ncta;
		}
		catch(FileNotFoundException fnfe){
			datos = "Error al abrir el archivo";
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe){
			datos = "Error al cerrar el archivo";
			System.out.println("Error: " + ioe);
		}
		return datos;
	}
}