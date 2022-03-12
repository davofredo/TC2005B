import java.util.ArrayList;

public class Productos {
    public static void agregaProductos(ArrayList<Cliente> listaClientes, AdministradorProducto administradorProductos) {
        String noCliente = System.console().readLine("Ingrese el no de cliente > ");
        String tipoProducto = System.console().readLine("Ingrese el tipo de producto > ");
        for (Cliente cliente : listaClientes) {
            if(cliente.getNumCliente().equals(noCliente)){
                switch (tipoProducto) {
                    case "cheques":
                        administradorProductos.agregarProducto(cliente, creaCheques());
                        break;
                    case "inversion":
                        administradorProductos.agregarProducto(cliente, creaInversion());
                        break;
                    case "tarjeta_credito":
                        administradorProductos.agregarProducto(cliente, creaCredito());
                        break;
                    default:
                    imprimeAyuda();
                        break;
                }
            }
        }
    }

    public static CuentaCheques creaCheques() {
        double balanceInicial = Double.parseDouble(System.console().readLine("Ingrese el balance inicial\n> "));
        double cominsionRetiro = Double.parseDouble(System.console().readLine("Ingrese la comision de retiro\n> "));
        CuentaCheques cheques = new CuentaCheques(balanceInicial, cominsionRetiro);
        return cheques;
    }

    public static CuentaInversion creaInversion() {
        double balanceInicial = Double.parseDouble(System.console().readLine("Ingrese el balance inicial\n> "));
        double interesAlCorte = Double.parseDouble(System.console().readLine("Ingrese el interes al corte\n> "));
        CuentaInversion inversion = new CuentaInversion(balanceInicial, interesAlCorte);
        return inversion;
    }

    public static TarjetaCredito creaCredito() {
        double lineaCredito = Double.parseDouble(System.console().readLine("Ingrese la linea de credito\n> "));
        TarjetaCredito tarjetaCredito = new TarjetaCredito(lineaCredito);
        return tarjetaCredito;
    }

    public static void imprimeAyuda() {
        System.out.println("cheques         - permite crear cuenta cheques\n" +
                           "inversion       - permite crear cuenta de inversion\n"+
                           "tarjeta_credito - permite crear tarjeta de credito");
    }
}
