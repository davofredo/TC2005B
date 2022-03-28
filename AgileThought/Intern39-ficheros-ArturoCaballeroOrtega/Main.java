import java.io.File;
import java.io.IOException;

public class Main {
    /**
     * Ingresar nombre archivo
     * Validar si existe el archivo, si existe, preguntar si deseamos eliminar, no existe
     * Ingresar nombre de la carpeta
     * Elegir entre las opciones de extension de archivos: txt, json, properties, yaml
     * Implementar las mejores prácticas
     */

    public static void main(String[] args) throws IOException {

        String nombreCarpeta = System.console().readLine("Ingrese el nombre de la carpeta en que quiere guardar: ");
        File nuevaCarpeta = new File("./" + nombreCarpeta);

        if (!nuevaCarpeta.exists()) {
            boolean carpetaCreada = nuevaCarpeta.mkdir();
            System.out.println("carpetaCreada = " + carpetaCreada);
        }

            String nombreArchivo = System.console().readLine("Ingrese un nombre de archivo con la extensión .(txt/json/properties, yaml): ");
            File crearArchivo = new File(nuevaCarpeta, nombreArchivo);
            if(crearArchivo.exists()){
                String deseaCrear = System.console().readLine("Desea crear archivos Y/N: ");
                if (deseaCrear.toUpperCase().equals("Y")) {
                    crearArchivo.createNewFile();
                    System.out.println("Archivo creado = " + crearArchivo);
                }
            }
            else {
                crearArchivo.createNewFile();
                System.out.println("Archivo creado = " + crearArchivo);
            }

        /*File directorio = new File("./");

        String[] archivos = directorio.list();

        for (String archivo : archivos) {
            System.out.println("archivo = " + archivo);
        }*/
    }
}