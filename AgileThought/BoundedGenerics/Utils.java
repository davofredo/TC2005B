import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static List logs = new ArrayList();

    public static <U> void registrar(U u) {
        logs.add(u);
        System.out.println("Se agregó un nuevo registro: " + u.getClass().getName());
    }

    public static void imprimirRegistros() {
        for (Object log : logs) {
            System.out.println(log);
        }
    }
}