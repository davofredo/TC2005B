import java.io.File;

import javax.swing.JOptionPane;

public class AbrirRegistro {

    public static void registro() {
        File carpeta = new File("./calculos");
        // TODO: No se valida si la carpeta existe
        String[] carpetas = carpeta.list();
        StringBuilder listaCarpetas = new StringBuilder("Ingrese el número de la carpeta a visitar\n");
        int num = 1;
        for (String car : carpetas) {
            listaCarpetas.append(num + " - " + car + "\n");
            num++;
        }

        // TODO: NumberFormatException no manejado
        // TODO: Posible null no manejado
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(listaCarpetas));
        opcion = opcion - 1;
        // TODO: ArrayIndexOutOfBoundsException no manejado
        File carpetaEscogida = new File(carpetas[opcion]);
        // System.out.println(carpetas.length);
        registro(carpetaEscogida);
    }

    private static void registro(File carpetaEscogida) {
        File carpeta = new File("./calculos/" + carpetaEscogida);
        String[] archivos = carpeta.list();
        StringBuilder listaArchivos = new StringBuilder("Ingrese el número del archivo a visitar, separando por ,\n");
        int num = 1;
        for (String car : archivos) {
            listaArchivos.append(num + " - " + car + "\n");
            num++;
        }
        String listaOpciones = JOptionPane.showInputDialog(listaArchivos);
        String[] lista = listaOpciones.split(",");

        for (String string : lista) {
            int valor = Integer.parseInt(string);
            Thread h1 = new Thread(new AbrirArchivos(archivos, carpeta, valor - 1));
            h1.start();
        }
        // Thread h1 = new Thread(new AbrirArchivos(carpeta, lista, archivos));
        // h1.start();
    }
}
