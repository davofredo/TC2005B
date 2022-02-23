//package modelLibro;

import java.util.*;
import java.util.StringTokenizer;

public class LibroDP
{
	private String titulo, autor, editorial;
	
	// Constructores
	public LibroDP()
	{
		this.titulo    = "";
		this.autor     = "";
		this.editorial = "";
	}
	
	public LibroDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		
		this.titulo    = st.nextToken();
		this.autor     = st.nextToken();
		this.editorial = st.nextToken();
	}
	
	// Accesors (geter)
	public String getTitulo()
	{
		return this.titulo;
	}
	
	public String getAutor()
	{
		return this.autor;
	}
	
	public String getEditorial()
	{
		return this.editorial;
	}
	
	
	// Mutators (seter)
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	
	public void setEditorial(String editorial)
	{
		this.editorial = editorial;
	}
	
	
	public String toString()
	{
		return this.titulo+"_"+this.autor+"_"+this.editorial;
	}
	
	public String toStringSQL()
	{
		return "'"+this.titulo+"','"+this.autor+"','"+this.editorial+"'";
	}

	public String toStringHTML(){
		return "<tr><td>" + titulo + "</ td><td>" + autor + "</ td><td>" + editorial + "</ td></ tr>";
	}

	public String toStringJSON(){
		return "{\"titulo\":\"" + titulo + "\",\"autor\":\"" + autor + "\",\"editorial\":\"" + editorial + "\"}";
	}
}
