import javax.print.attribute.SupportedValuesAttribute;

public class SentenciaForeach {
    public static void main(String[] args) {
        /*
         * String[] nombres = { "David", "Gerson", "Pablo", "Marco", "Raul", "Alberto",
         * "Arturo", "Adrian" };
         * 
         * for (String nombre : nombres) {
         * System.out.println("nombre = " + nombre);
         * }
         */

        int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 49, 50 };
        /**
         * Es impar
         * Es par
         */
        for (int numero : numeros) {
            // if (numero % 2 == 0)
            System.out
                    .println(numero % 2 == 0 ? "El numero " + numero + " es par" : "El numero " + numero + " es impar");
            // else
            // System.out.println("El numero " + numero + " es impar");
        }
    }
}
