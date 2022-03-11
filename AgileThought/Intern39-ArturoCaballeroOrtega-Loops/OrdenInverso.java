public class OrdenInverso {
    public static void main(String[] args) {
        String[] argumentos = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        inverso(argumentos);
    }

    public static void inverso(String[] argumentos) {
        for (int i = argumentos.length-1; i >= 0; i--) {
            System.out.println(argumentos[i]);
        }
    }
}
