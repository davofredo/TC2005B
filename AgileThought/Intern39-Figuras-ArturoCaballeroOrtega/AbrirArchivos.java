import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AbrirArchivos implements Runnable {
    private String[] listaArchivos;
    private File carpeta;
    private int identificador;

    public AbrirArchivos(String[] listaArchivos, File carpeta, int identificador) {
        this.listaArchivos = listaArchivos;
        this.carpeta = carpeta;
        this.identificador = identificador;
    }

    public AbrirArchivos(File carpeta, String[] lista, String[] listaArchivos) {
        this.carpeta = carpeta;
        this.listaArchivos = listaArchivos;
    }

    public void abrir(int id) {
        try {
            System.out.println(this.listaArchivos[id]);
            File archivos = new File(this.carpeta + "/" + this.listaArchivos[id]);
            FileReader file = new FileReader(archivos);
            BufferedReader br = new BufferedReader(file);
            String linea = br.readLine();
            // TODO: No es seguro cerrar las conexiones dentro del bloque try. Las siguientes alternativas serian mejores:
            //   A. Usar try with resources
            //   B. Declarar br fuera del try y llamar a close desde un bloque finally
            br.close();
            file.close();
            JOptionPane.showMessageDialog(null, linea);
        } catch (IOException e) {
            // TODO: El usuario va a estar esperando retroalimentacion desde un JOptionPane, no desde la consola
            System.err.println("Error al abrir el archivo");
        }
    }

    @Override
    public void run() {
        // for (String i : this.lista) {
        // abrir(Integer.parseInt(i)-1);
        // }
        abrir(this.identificador);
    }

}
