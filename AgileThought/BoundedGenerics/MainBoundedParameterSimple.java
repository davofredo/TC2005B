import java.util.ArrayList;
import java.util.List;

public class MainBoundedParameterSimple {

    public static List numeros = new ArrayList<>();

    public static void main(String[] args) {
        agregarNumero(10);
        agregarNumero(12);
        agregarNumero(30);

        for (Object o : numeros) {
            System.out.println(o);
        }
    }

    public static <U extends Number> void agregarNumero(U u) {
        numeros.add(u);
    }
}
