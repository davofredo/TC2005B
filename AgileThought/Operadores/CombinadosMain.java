public class CombinadosMain {
    public static void main(String[] args) {
        int suma = 1 + 6 + 9 + 56;
        suma += 30; // suma = suma + 30;
        System.out.println("Resultado de la suma = " + suma);

        int resta = 9 - 6 - 1;
        resta -= 1;
        System.out.println("Resultado de la resta = " + resta);

        int multiplicacion = 9 * 4;
        multiplicacion *= 2;
        System.out.println("Resultado de la multiplicacion = " + multiplicacion);

        double division = 9.0 / 4;
        division /= 5;
        System.out.println("Resultado de la division = " + division);

        int modulo = 6 % 3;
        modulo %= 2;
        System.out.println("Resultado del modulo = " + modulo);

    }
}
