import java.util.Scanner;

public class ScannerYRandom {
    public static void main(String[] args) {
        // Ejemplo Scanenr
        Scanner scanner = new Scanner(System.in);
        System.out.println("Captura un texto");
        String entrada1 = scanner.nextLine();
        System.out.println("Captura un numero entero");
        int entrada2 = scanner.nextInt();
        System.out.println("Primera entrada: " + entrada1);
        System.out.println("Segunda entrada: " + entrada2);
        scanner.close();

        // Ejemplo de Math.Random
        double rand1 = Math.random();
        int rand2 = (int) (rand1 * 10 + 1);
        System.out.println("rand1: " + rand1);
        System.out.println("rand2: " + rand2);

    }
}