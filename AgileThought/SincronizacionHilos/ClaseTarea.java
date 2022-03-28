public class ClaseTarea implements Runnable {

    private String oracion1;
    private String oracion2;

    public ClaseTarea(String oracion1, String oracion2) {
        this.oracion1 = oracion1;
        this.oracion2 = oracion2;
    }

    @Override
    public void run() {
        Recurso.imprimirMensaje(oracion1, oracion2);
    }
}
