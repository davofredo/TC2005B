import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static Cliente cliente = null;
    private static Configuracion conf = new Configuracion();
    private static AdministradorProducto administradorProductos = new AdministradorProducto(conf);
    private static Map<String, String> mapaClientes = new HashMap<>();
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

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
                    listaClientes.add(cliente);
                    break;
                case "agregar_productos":
                    Productos.agregaProductos(listaClientes, administradorProductos);
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
                    modificaPropiedadesProducto();
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
        System.out.println("ayuda                               - Ver comandos con su descripcion\n" +
                            "agregar_cuenta_habiente            - Agrega Cuenta habientes, se necesitara nombre, numero de clientes y ingreso mensual\n" + 
                            "agregar_productos                  - te permite agregar un producto a la vez\n" +
                            "registrar_movimientos              - permite registrar retiro, cargo, corte, SOLO puede hacer un novimiento a la vez\n" +
                            "imprimir_estados_de_cuenta         - imprime cualquier producto financiero\n" +
                            "baja_productos                     - Da de baja productos asociados a una cuenta-habiente\n" +
                            "baja_cuenta_habientes              - Da de baja cuenta-habiente\n" +
                            "modificar_configuracion            - Permite modificar la linea de credito maximo por ingreso mensula/porcentaja de impuesto retenido por intereses generados\n" +
                            "modificar_propiedades_de_productos - Modifica la cominsionRetiro de la Cuenta de Cheques, modificar el interesAlCorte de la Cuenta Cheques, modificar la lineaCredito  de la Targjeta de Credito\n" +
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

    public static void imprimeEstadosCuenta() {
        String noCuenta = new String(System.console().readLine("Ingrese el numero de cuenta:\n> "));
        String selec = new String(
                System.console().readLine("Ingrese el nombre del producto:\n> "));
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

    // TODO
    public static void bajaProductos() {
        String noCuenta = new String(System.console().readLine("Ingrese el numero de cuenta:\n> "));
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        if (administradorProductos.puedeCancelar(noCuenta))
            System.out.println("Se puede continuar con la operacion");

        String selec = new String(System.console().readLine("Ingrese el nombre del producto a dar de baja:\n> "));
        if (selec.equals("cheques")) {
            for (ProductoFinanciero producto : misProductos) {
                if (producto instanceof CuentaCheques) {
                    administradorProductos.cancelar(noCuenta, producto);
                }
            }
        } else if (selec.equals("inversion")) {
            for (ProductoFinanciero producto : misProductos) {
                if (producto instanceof CuentaInversion) {
                administradorProductos.cancelar(noCuenta, producto);
                }
        }
        } else if (selec.equals("tarjeta_credito")) {
            for (ProductoFinanciero producto : misProductos) {
                if (producto instanceof TarjetaCredito) {
                    administradorProductos.cancelar(noCuenta, producto);
                }
            }
        }
    }

    public static void bajaCuentaHabientes() {
        String noCuenta = new String(System.console().readLine("Ingrese el numero de cuenta:\n> "));
        if (administradorProductos.puedeCancelar(noCuenta)){
            System.out.println("Se puede continuar con la operacion");
            administradorProductos.cancelar(noCuenta);
            mapaClientes.remove(noCuenta);
        }
        else {
            System.out.println("Tiene saldo pendiente");
        }
    }

    public static void modificaConfiguracion() {
        String confACambiar = new String(System.console().readLine("Ingrese la caonfiguracion a cambiar\n> "));
        switch (confACambiar) {
            case "creditoMaximo":
                double nuevaLineaCredito = Double.parseDouble(System.console().readLine("Ingrese la nueva linea de credito\n> "));
                conf.setMaxLineaCreditoPorIngresoMensual(nuevaLineaCredito);
                break;
            case "impuestoRetenido":
                double nuevoImpuestoRetenido = Double.parseDouble(System.console().readLine("Ingrese el nuevo porcentaja de impuesto por interes generado\n> "));
                conf.setImpuestoPorInteresGenerado(nuevoImpuestoRetenido);
                break;
            default:
                break;
        }
        
    }

    public static void modificaPropiedadesProducto() {
        String cuenta = System.console().readLine("Ingrese la cuenta que quiere cambiar\n> ");
        String confACambiar = System.console().readLine("Ingrese que quiere cambiar\n> ");
        switch (confACambiar) {
            case "linea_de_credito":
                modificarLineaDeCredito(cuenta);
                break;
            case "interes_al_corte":
                modificarInteresesAlCorte(cuenta);
                break;
            case "comision_retiro":
                comisionAlRetiro(cuenta);
            default:    
                break;
        }
    }

    public static void retiro(String noCuenta) {
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        String selec = new String(
                System.console().readLine("Ingrese el nombre del producto a realizar el retiro:\n> "));
        double cantidad = Double.parseDouble(
                System.console().readLine("Ingrese la cantidad a retirar:\n> "));
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("cheques")) {
                if (producto instanceof CuentaCheques) {
                    producto.reducirFondos(cantidad);
                    // System.out.println(producto.getClass() + " : " + producto.getSaldo());
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    producto.reducirFondos(cantidad);
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("tarjeta_credito")) {
                if (producto instanceof TarjetaCredito) {
                    producto.reducirFondos(cantidad);
                    System.out.println(producto.getSaldo());
                }
            }
        }
    }

    public static void cargo(String noCuenta) {
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        String selec = new String(
                System.console().readLine("Ingrese el nombre del producto a realizar el cargo:\n> "));
                double cantidad = Double.parseDouble(
                System.console().readLine("Ingrese la cantidad a cargar:\n> "));
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("cheques")) {
                if (producto instanceof CuentaCheques) {
                    producto.agregarFondos(cantidad);
                    // System.out.println(producto.getClass() + " : " + producto.getSaldo());
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    producto.agregarFondos(cantidad);
                    System.out.println(producto.getSaldo());
                }
            } else if (selec.equals("tarjeta_credito")) {
                if (producto instanceof TarjetaCredito) {
                    producto.reducirFondos(cantidad);
                    System.out.println(producto.getSaldo());
                }
            }
        }
    }

    public static void corte(String noCuenta) {
        List<ProductoFinanciero> misProductos = administradorProductos.getProductos(noCuenta);
        String selec = new String(
            System.console().readLine("Ingrese el nombre del producto a realizar el corte:\n> "));
        for (ProductoFinanciero producto : misProductos) {
            if (selec.equals("inversion")) {
                if (producto instanceof CuentaInversion) {
                    ((CuentaInversion)producto).aplicarCorte();
                    producto.imprimirEstadoCuenta();
                }
            }
        }
    }

    public static void modificarLineaDeCredito(String cuenta) {
        double nuevaLineaCredito = Double.parseDouble(System.console().readLine("Ingrese la nueva linea de credito\n> "));
        administradorProductos.modificarLineasDeCredito(cuenta, nuevaLineaCredito);
    }

    public static void modificarInteresesAlCorte(String cuenta) {
        double nuevoImpuestoPorInteresGenerado = Double.parseDouble(System.console().readLine("Ingrese el nuevo porcentaja de impuesto por interes generado\n> "));
        administradorProductos.modificarLineasDeCredito(cuenta, nuevoImpuestoPorInteresGenerado);
    }

    private static void comisionAlRetiro(String cuenta) {
        double nuevoComisionAlRetiro = Double.parseDouble(System.console().readLine("Ingrese el nuevo porcentaja de comision por retiro\n> "));
        administradorProductos.modificarComisionAlRetiro(cuenta, nuevoComisionAlRetiro);
    }
}
