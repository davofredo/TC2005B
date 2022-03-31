import java.util.Scanner;

public class EmpleadoServicesImpl {

    public void registrarEmpleado() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del empleado:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el puesto del empleado:");
        String puesto = sc.nextLine();

        Persona p = new Empleado(nombre, puesto);
        registrar(p);
    }

    public <U extends Persona> void registrar(U u) {
        Utils.registrar(u);
    }
}