//package modelLibro;

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

public class BiblioADjdbc
{
    private PrintWriter archivoOut;
	private BufferedReader archivoIn;

	private Connection conexion;
	private Statement statement;
	
	private LibroDP librodp;

	public  BiblioADjdbc(){
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//conexion = DriverManager.getConnection("jdbc:mysql://localhost/Banco?user=root");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/Biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
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
    
    public String capturar(String datos)
    //public String capturar(LibroDP librodp)
    {
        String respuesta = "";
        String strInsert, titulo, autor, editorial;
        StringTokenizer st;
        
        //strInsert = "INSERT INTO Libro VALUES('FISICA','RESNICK','CECSA')";
        //strInsert = "INSERT INTO Libro VALUES('"+tit+"','"+aut+"','"+edit+"')";
        strInsert = "INSERT INTO Libro VALUES("+librodp.toStringSQL()+")";
        
        try
        {
            // 1. Abrir el archivo de datos
            statement = conexion.createStatement();
        	
            // 2. Capturar los datos en el archivo
            statement.executeUpdate(strInsert);
            
            // 3. Cerrar archivo
            statement.close();
            
            respuesta = "Captura correcta... ";
            
            System.out.println(strInsert);
        }
        catch(SQLException sqle)
        {
            respuesta = "Error en captura: "+sqle;
            System.out.println("Error: "+sqle);
        }
        
        return respuesta;
    }
    
    public String consultarLibros()
    {
        String datos="[";
        ResultSet tr;
        String titulo, autor, editorial;
        String query = "SELECT * FROM Libro";
        
        
        try
        {
            // 1. Abrir el archivo para leer los datos
            statement = conexion.createStatement();
        	
        	// Ejecutar Query
        	tr = statement.executeQuery(query);
        	
            librodp = new LibroDP();
            
            while(tr.next())
            {
            	librodp.setTitulo(tr.getString("titulo"));
            	librodp.setAutor(tr.getString(2));
            	librodp.setEditorial(tr.getString("editorial"));
            	
            	//datos = datos + librodp.toString() + "\n";
                datos = datos + JsonWriter.objectToJson(librodp) + ",";
            }
            datos = datos.substring(0, datos.length() - 1) + "]";
            
            // 3. Cerrar el archivo
            statement.close();
            
        }
        catch(SQLException ioe)
        {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }
        
        return datos;
    }
    
    public String consultarEditorial(String editorial)
    {
        String datos = "";
        boolean encontrado = false;
        ResultSet tr;
        
        String query = "SELECT * FROM Libro WHERE editorial='"+editorial+"'";
        
        try
        {
            // 1. Abrir el archivo para leer los datos
            statement = conexion.createStatement();
            
            // Ejecutar Query
            tr = statement.executeQuery(query);
            
            librodp = new LibroDP();

            // 2. Procesar los datos
            while(tr.next())
            {
                librodp.setTitulo(tr.getString("titulo"));
                librodp.setAutor(tr.getString(2));
                librodp.setEditorial(tr.getString("editorial"));
                
                datos = datos + librodp.toStringHTML();
                
                encontrado = true;
            }
            
            // 3. Cerrar el archivo
            //archivoIn.close();
            statement.close();
            
            if(!encontrado)
                datos = "NOT_FOUND";
            
            System.out.println(query);
        }
        catch(SQLException ioe)
        {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }
        return datos;
    }
    
    public String consultarTitulo(String titulo)
    {
        String datos="";
        boolean encontrado=false;
        ResultSet tr;
        
        String query = "SELECT * FROM Libro WHERE titulo='"+titulo+"'";
        
        
        try
        {
            // 1. Abrir el archivo para leer los datos
            statement = conexion.createStatement();
            
            // Ejecutar Query
            tr = statement.executeQuery(query);
            
            librodp = new LibroDP();
            // 2. Procesar los datos
            while(tr.next())
            {
                librodp.setTitulo(tr.getString("titulo"));
                librodp.setAutor(tr.getString(2));
                librodp.setEditorial(tr.getString("editorial"));
                
                datos = datos + librodp.toStringHTML();
                
                encontrado = true;
            }
            
            // 3. Cerrar el archivo
            statement.close();
            
            if(!encontrado)
                datos = "NOT_FOUND";
            
            System.out.println(query);
        }
        catch(SQLException ioe)
        {
            datos = "Error en consultar: "+ioe;
            System.out.println("Error: "+ioe);
        }
        return datos;
    }
}
