public class Empleado extends Persona {

    private String puesto;

    public Empleado(String nombre, String puesto) {
        super(nombre);
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "puesto='" + puesto + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}