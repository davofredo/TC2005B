import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import constants.TipoFigurasEnum;
import interfaces.IMedidas;

public class GuardarArchivo {
    public static void guardar(TipoFigurasEnum figura, IMedidas medidas) {
        JOptionPane.showMessageDialog(null, String.format("Exito con el calculo de la figura %s", figura));
        String nombreArchivo = JOptionPane
                .showInputDialog("Los valores se guardaran en un archivo\n Ingrese el nombre del archivo");

        LocalDate date = LocalDate.now();
        File nuevaCarpeta = new File("/calculos/" + date.toString());
        
        if (!nuevaCarpeta.exists()) {
            boolean carpetaCreada = nuevaCarpeta.mkdirs();
            System.out.println("carpetaCreada = " + carpetaCreada);
            guardarArchvio(nuevaCarpeta, nombreArchivo, figura, medidas);
        } else {
            guardarArchvio(nuevaCarpeta, nombreArchivo, figura, medidas);
        }
    }

    public static void guardarArchvio(File nuevaCarpeta, String nombreArchivo, TipoFigurasEnum figura,
            IMedidas medidas) {
        File crearArchivo = new File(nuevaCarpeta, nombreArchivo);
        try {
            if (crearArchivo.exists()) {
                String deseaCrear = JOptionPane.showInputDialog("Desea remplazar el archivo archivos Y/N: ");
                if (deseaCrear.toUpperCase().equals("Y")) {
                    crearArchivo.createNewFile();
                    System.out.println("Archivo creado = " + crearArchivo);
                }
            } else {
                crearArchivo.createNewFile();
                System.out.println("Archivo creado = " + crearArchivo);
            }
        } catch (NullPointerException e) {
            guardar(figura, medidas);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo");
        }
    }
}
