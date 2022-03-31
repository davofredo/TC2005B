public class Main {
    public static void main(String[] args) {
        FigurasServicesImpl figurasServices = new FigurasServicesImpl();
        EmpleadoServicesImpl empleadoServices = new EmpleadoServicesImpl();

        figurasServices.realizarOperaciones();
        empleadoServices.registrarEmpleado();

        Utils.imprimirRegistros();
    }
}