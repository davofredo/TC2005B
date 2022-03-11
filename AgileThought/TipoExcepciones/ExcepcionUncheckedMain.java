import javax.swing.JOptionPane;

public class ExcepcionUncheckedMain {
    public static void main(String[] args) {
        /*String valor = JOptionPane.showInputDialog("ingrese un número");

        int numero = 0;

        try {
            numero = Integer.parseInt(valor);
            System.out.println("numero: " + numero);
        } catch (NumberFormatException e) {
            System.err.println("El valor ingresado es invalido");
        }*/

        String[] nombres = {"Adrian", "Juan"};
        System.out.println("nombre[2]", nombres[2]);
    }
}
