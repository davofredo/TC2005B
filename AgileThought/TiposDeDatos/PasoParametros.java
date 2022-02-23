import javax.print.attribute.SupportedValuesAttribute;

public class PasoParametros {
    public static void main(String[] args) {
        boolean esValido = false;
        testMethodValor(esValido);
        System.out.println("esValido = " + esValido);

        boolean[] sonValidos = { false, true };
        System.out.println("Inicia metodo main");
        System.out.println("sonValidos[0] = " + sonValidos[0]);
        System.out.println("sonValidos[1] = " + sonValidos[1]);
        
        testMethodReferencia(sonValidos);
        System.out.println("sonValidos[0] = " + sonValidos[0]);
        System.out.println("sonValidos[1] = " + sonValidos[1]);
        System.out.println("Finaliza metodo main");
    }
    
    public static void testMethodValor(boolean esValido) {
        esValido = !esValido;
        System.out.println("esValido = " + esValido);
    }
    
    public static void testMethodReferencia(boolean[] sonValidos) {
        sonValidos[0] = true;
        System.out.println("sonValidos[0] = " + sonValidos[0]);
        System.out.println("sonValidos[1] = " + sonValidos[1]);
        System.out.println("Finaliza testMethodReferencia");
    }
}
