import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        /*
         * //Collection<String> nombres = new PriorityQueue<>();
         * List<String> nombres = new ArrayList<>();
         * nombres.add("Ardian");
         * nombres.add("Juan");
         * nombres.add("Alejandro");
         * 
         * System.out.println("nombres = " + nombres);
         * 
         * Collection.sort(nombres);
         * String min = Collection.min(nombres);
         * 
         * System.out.println("nombre = ", nombres);
         * System.out.println("min = ", min);
         */

        //String[] nombres = { "Adrian", "Juan", "Alejandro", "Pepe" };
        List<Integer> edades = new ArrayList<>();
        int edadesCorrectas = 0;

        String inputNombres = JOptionPane.showInputDialog("Ingrese nombres separados por coma");
        String[] nombres = inputNombres.split(",");

        for (String nombre : nombres) {
            try {
                while (true) {
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " + nombre));
                    edades.add(edad);
                    break;
                }
            } catch (Exception e) {
                System.err.println("La edad de " + nombre + "es invalida");
            }
        }

        Integer min = Collections.min(edades);
        Integer max = Collections.max(edades);
        Integer promedio = 0;

        for (Integer e : edades) {
            promedio += e;
        }

        promedio /= edades.size();

        System.out.println("La edad minima del grupo es: " + min);
        System.out.println("La edad maxima del grupo es: " + max);
        System.out.println("El promedio de edad es de: " + promedio);
    }
}
