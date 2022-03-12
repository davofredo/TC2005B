import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static Cliente cliente = null;
    private static AdministradorProducto administradorProductos = new AdministradorProducto(getConfiguracion());
    private static Map<String, String> mapaClientes = new HashMap<>();

    public static void menu() {
        String arg;
        boolean estado = true;

        while (estado) {
            arg = System.console().readLine("> ");
            switch (arg) {
                case "ayuda":
                    printAyuda();
                    break;
                case "agregar_cuenta_habiente":
                    cliente = agregaCuentaHabiente();
                    break;
                case "agregar_productos":
                    pideProductos(cliente);
                    break;
                case "registrar_movimientos":
                    registraMovimientos();
                    break;
                case "imprimir_estados_de_cuenta":
                    imprimeEstadosCuenta();
                    break;
                case "baja_productos":
                    bajaProductos();
                    break;
                case "baja_cuenta_habientes":
                    bajaCuentaHabientes();
                    break;
                case "modificar_configuracion":
                    modificaConfiguracion();
                    break;
                case "modificar_propiedades_de_productos":
                    // modificaPropiedadesProducto();
                    break;
                case "exit":
                    estado = false;
                    break;
                default:
                    printAyuda();
                    break;
            }
        }
    }

    public static void printAyuda() {
        System.out.println("ayuda                              - " +
                "Ver comandos con su descripcion\n" +
                "agregar_cuenta_habiente            - " +
                "Agrega Cuenta habientes, se necesitara nombre, numero de clientes y ingreso mensual\n" +
                "agregar_productos                  - te permite agregar jun producto a la vez\n" +
                "registrar_movimientos              - permite registrar retiro, cargo, corte, SOLO puede hacer un novimiento a la vez\n"
                +
                "imprimir_estados_de_cuenta         - imprime cualquier producto financiero\n" +
                "baja_productos                     - Da de baja productos asociados a una cuenta-habiente\n" +
                "baja_cuenta_habientes              - Da de baja cuenta-habiente\n" +
                "modificar_configuracion            - Permite modificar la linea de credito maximo por ingreso mensula/"
                +
                "                                                         porcentaja de impuesto retenido por intereses generados\n"
                +
                "modificar_propiedades_de_productos - Modifica la cominsionRetiro de la Cuenta de Cheques, modificar el interesAlCorte"
                +
                "                                     de la Cuenta Cheques, modificar la lineaCredito  de la Targjeta de Credito\n"
                +
                "exit                               - Salir del programa");
    }

    public static Cliente agregaCuentaHabiente() {
        String nombre = System.console().readLine("Ingrese el nombre del cliente > ");
        String numCliente = System.console().readLine("Ingrese el numero del cliente > ");
        mapaClientes.put(numCliente, nombre);
        double ingresoMensual = Double.parseDouble(System.console().readLine("Ingrese el ingreso mensual > "));
        Cliente cliente = new Cliente(nombre, numCliente, ingresoMensual);
        System.out.println("Cuenta creada exitosamente");
        return cliente;
    }

    public static void agregaProductos(Cliente cliente) {
        String tipoProducto = System.console().readLine("Ingrese el tipo de producto > ");
        if (tipoProducto.equals("cheques")) {
            administradorProductos.agregarProducto(cliente, creaCheques());
        } else if (tipoProducto.equals("inversion")) {
            administradorProductos.agregarProducto(cliente, creaInversion());
        } else if (tipoProducto.equals("tarjeta_credito")) {
            administradorProductos.agregarProducto(cliente, creaCredito());
        }
    }

    public static void registraMovimientos() {
        String numCliente = new String(System.console().readLine("Ingrese el numero de cuenta\n> "));

        String tipoMovimiento = new String(System.console().readLine("Ingrese el tipo de movimiento\n> "));
        switch (tipoMovimiento) {
            case "retiro":
                retiro(numCliente);
                break;
            case "cargo":
                cargo(numCliente);
                break;
            case "corte":
                corte(numCliente);
                break;
            default:
                break;
        }
    }

    public static Configuracion getConfiguracion() {
        Configuracion conf = new Configuracion();
        return conf;
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

    public static void retiro(String noCuenta) {
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        String selec = new String(
                System.console().readLine("Ingrese el nombre del producto a realizar el retiro:\n> "));
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("cheques")) {
                if (producto instanceof CuentaCheques) {
                    producto.reducirFondos(100);
                    // System.out.println(producto.getClass() + " : " + producto.getSaldo());
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    producto.reducirFondos(10);
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("tarjeta_credito")) {
                if (producto instanceof TarjetaCredito) {
                    producto.reducirFondos(200);
                    System.out.println(producto.getSaldo());
                }
            }
        }
    }

    public static void cargo(String noCuenta) {
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        String selec = new String(
                System.console().readLine("Ingrese el nombre del producto a realizar el retiro:\n> "));
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("cheques")) {
                if (producto instanceof CuentaCheques) {
                    producto.agregarFondos(100);
                    // System.out.println(producto.getClass() + " : " + producto.getSaldo());
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    producto.agregarFondos(10);
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("tarjeta_credito")) {
                if (producto instanceof TarjetaCredito) {
                    producto.reducirFondos(200);
                    System.out.println(producto.getSaldo());
                }
            }
        }
    }

    public static void corte(String noCuenta) {
        // TODO : hacer el corte
    }

    public static void imprimeEstadosCuenta() {
        String noCuenta = new String(System.console().readLine("Ingrese el numero de cuenta:\n> "));
        String selec = new String(
                System.console().readLine("Ingrese el nombre del producto a realizar el retiro:\n> "));
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("cheques")) {
                if (producto instanceof CuentaCheques) {
                    System.out.println(mapaClientes.get(noCuenta));
                    producto.imprimirEstadoCuenta();
                }
            } else if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    System.out.println(mapaClientes.get(noCuenta));
                    producto.imprimirEstadoCuenta();
                }
            } else if (selec.equals("tarjeta_credito")) {
                if (producto instanceof TarjetaCredito) {
                    System.out.println(mapaClientes.get(noCuenta));
                    producto.imprimirEstadoCuenta();
                }
            }
        }
    }

    public static void bajaProductos() {
        String noCuenta = new String(System.console().readLine("Ingrese el numero de cuenta:\n> "));
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        if (administradorProductos.puedeCancelar(noCuenta))
            System.out.println("Sepuede continuar con la operacion");

        String selec = new String(System.console().readLine("Ingrese el nombre del producto a dar de baja:\n> "));
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("cheques")) {
                if (producto instanceof CuentaCheques) {
                    administradorProductos.cancelar(noCuenta, producto);
                }
            } else if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    administradorProductos.cancelar(noCuenta, producto);
                }
            } else if (selec.equals("tarjeta_credito")) {
                if (producto instanceof TarjetaCredito) {
                    administradorProductos.cancelar(noCuenta, producto);
                }
            }
        }
    }

    public static void bajaCuentaHabientes() {
        String noCuenta = new String(System.console().readLine("Ingrese el numero de cuenta:\n> "));
        if (administradorProductos.puedeCancelar(noCuenta))
            System.out.println("Se puede continuar con la operacion");
        administradorProductos.cancelar(noCuenta);
        mapaClientes.remove(noCuenta);
    }

    public static void modificaConfiguracion() {
        System.out.println("Una vez hecho el cambio este se vera afectado para todas las cuentas");
        String confACambiar = System.console().readLine("Ingrese que quiere cambiar\n> ");
        switch (confACambiar) {
            case "creditoMaximo":
                modificarLineaDeCredito();
                break;
            case "impuestoRetenido":
                modificarImpuesto();
                break;
            default:    
                break;
        }
    }

    public static void modificarLineaDeCredito() {
        double nuevaLineaCredito = Double.parseDouble(System.console().readLine("Ingrese la nueva linea de credito\n> "));
        administradorProductos.modificarLineasDeCredito(nuevaLineaCredito);
    }

    public static void modificarImpuesto() {
        double nuevoImpuestoPorInteresGenerado = Double.parseDouble(System.console().readLine("Ingrese el nuevo porcentaja de impuesto por interes generado\n> "));
        administradorProductos.modificarLineasDeCredito(nuevoImpuestoPorInteresGenerado);
    }
}
