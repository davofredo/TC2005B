import java.util.Scanner;

public class FigurasServicesImpl {

    public void realizarOperaciones() {
        Scanner sc = new Scanner(System.in);
        Figura f = null;

        System.out.println("Ingrese la opción de la figura\n1 - Circulo \n2 - Cuadrado \n3 - Rectangulo");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                f = new Circulo(3.4);
                break;

            case 2:
                f = new Cuadrado(4.7);
                break;

            case 3:
                f = new Rectangulo(5.9, 2.3);
                break;
        }

        registrar(f);
    }

    public <U extends Figura> void registrar(U u) {
        Utils.registrar(u);
    }
}