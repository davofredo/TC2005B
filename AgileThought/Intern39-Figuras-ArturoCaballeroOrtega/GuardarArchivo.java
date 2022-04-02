import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import constants.TipoFigurasEnum;
import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Equilatero;
import figuras.Isosceles;
import figuras.Rectangulo;
import interfaces.IMedidas;

public class GuardarArchivo implements Runnable {
    private TipoFigurasEnum figura;
    private IMedidas medidas;

    public GuardarArchivo(TipoFigurasEnum figura, IMedidas medidas) {
        this.figura = figura;
        this.medidas = medidas;
    }

    public static void guardar(TipoFigurasEnum figura, IMedidas medidas) {
        StringBuilder sb = new StringBuilder();
        String nombreArchivo = JOptionPane.showInputDialog("Los valores se guardaran en un archivo\n Ingrese el nombre del archivo");
        if (nombreArchivo.isEmpty())
        guardar(figura, medidas);
        else {
            sb.append(nombreArchivo + ".txt");
            LocalDate date = LocalDate.now();
            File nuevaCarpeta = new File("./calculos/" + date.toString());

            if (!nuevaCarpeta.exists()) {
                boolean carpetaCreada = nuevaCarpeta.mkdirs();
                System.out.println("carpetaCreada = " + carpetaCreada);
                crearArchvio(nuevaCarpeta, sb.toString(), figura, medidas);
            } else {
                crearArchvio(nuevaCarpeta, sb.toString(), figura, medidas);
            }
        }
    }

    private static void crearArchvio(File nuevaCarpeta, String nombreArchivo, TipoFigurasEnum figura,
            IMedidas medidas) {
        File crearArchivo = new File(nuevaCarpeta, nombreArchivo);
        try {
            if (crearArchivo.exists()) {
                String deseaCrear = JOptionPane.showInputDialog("Desea remplazar el archivo archivos Y/N: ");
                if (deseaCrear.toUpperCase().equals("Y")) {
                    crearArchivo.createNewFile();
                    guardarInformacion(crearArchivo, figura, medidas);
                    System.out.println("Archivo creado = " + crearArchivo);
                } else {
                    guardar(figura, medidas);
                }
            } else {
                crearArchivo.createNewFile();
                guardarInformacion(crearArchivo, figura, medidas);
                System.out.println("Archivo creado = " + crearArchivo);
            }
        } catch (NullPointerException e) {
            guardar(figura, medidas);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo");
        }
    }

    private static void guardarInformacion(File crearArchivo, TipoFigurasEnum figura, IMedidas medidas) {
        try {
            FileWriter escribir = new FileWriter(crearArchivo);
            if (figura.getNombre().equalsIgnoreCase("CIRCULO")) {
                String datos = ((Circulo) medidas).toString();
                escribir.write(datos);
                escribir.close();
            } else if (figura.getNombre().equalsIgnoreCase("CUADRADO")) {
                String datos = ((Cuadrado) medidas).toString();
                escribir.write(datos);
                escribir.close();
            } else if (figura.getNombre().equalsIgnoreCase("RECTANGULO")) {
                String datos = ((Rectangulo) medidas).toString();
                escribir.write(datos);
                escribir.close();
            } else if (figura.getNombre().equalsIgnoreCase("TRIANGULO EQUILATERO")) {
                String datos = ((Equilatero) medidas).toString();
                escribir.write(datos);
                escribir.close();
            } else if (figura.getNombre().equalsIgnoreCase("TRIANGULO ISOSCELES")) {
                String datos = ((Isosceles) medidas).toString();
                escribir.write(datos);
                escribir.close();
            }
            JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo");
        }
    }

    @Override
    public void run() {
        guardar(this.figura, this.medidas);
    }
}
