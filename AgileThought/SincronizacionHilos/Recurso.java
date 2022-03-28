public class Recurso {
    public synchronized static void imprimirMensaje(String oracion1, String oracion2) {
        System.out.print(oracion1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
        System.out.println(oracion2);
    }
}
