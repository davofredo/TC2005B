public class MiClaseTarea extends Thread {

    private String nombre;

    public MiClaseTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        //Recurso.getRecurso();
    }
}