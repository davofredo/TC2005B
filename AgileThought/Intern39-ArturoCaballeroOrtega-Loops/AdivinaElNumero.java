import java.util.Scanner;

import javax.sound.sampled.AudioFormat.Encoding;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Captura un número entero de 0 y 10");
        int numero = scanner.nextInt();

        // Ejemplo de Math.Random
        double rand1 = Math.random() * (1 - 0);
        int rand2 = (int) (rand1 * 10);
        while (numero != rand2) {
            System.out.println("¡Incorrecto!, ingresa otro número de 0 a 10");
            numero = scanner.nextInt();
        }

        System.out.println("¡Correcto! El número es: " + rand2);
        scanner.close();
    }
}
