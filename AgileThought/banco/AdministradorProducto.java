import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorProducto {
    private Configuracion conf;
    private Map<String, List<ProductoFinanciero>> mapaProductos = new HashMap<>();

    public AdministradorProducto(Configuracion conf) {
        this.conf = conf;
    }

    public void agregarProducto(Cliente cliente, ProductoFinanciero producto) {
        List<ProductoFinanciero> productos = mapaProductos.get(cliente.getNumCliente());
        if (productos == null) {
            productos = new ArrayList<>();
            mapaProductos.put(cliente.getNumCliente(), productos);
        }
        if (producto instanceof TarjetaCredito) {
            double ingresoMensual = cliente.getIngresoMensual();
            double lineaCredito = ((TarjetaCredito) producto).getLineaCredito();
            if (lineaCredito > ingresoMensual * conf.getMaxLineaCreditoPorIngresoMensual()) {
                System.out.println("Linea de credito excesiva para este cliente");
                return;
            }
        }

        if (producto instanceof CuentaInversion) {
            boolean tieneAmbasCuentas = false;
            if (producto instanceof CuentaCheques) {
                tieneAmbasCuentas = true;
            }

            if (!tieneAmbasCuentas) {
                System.out.println("Alta de producto rechazado. \nDebe tener cuenta de inversion y de cheques");
                return;
            }
        }

        System.out.println("Alta de producto aceptado");
        productos.add(producto);
    }

    public List<ProductoFinanciero> getProductos(String numCliente) {
        List<ProductoFinanciero> productos = mapaProductos.get(numCliente);
        if (productos == null)
            System.out.println("El cliente no tiene productos asignados");
        return productos;
    }

    public boolean puedeCancelar(Cliente cliente) {
        List<ProductoFinanciero> productos = getProductos(cliente.getNumCliente());
        boolean resultado = true;
        for (ProductoFinanciero pf : productos) {
            if (pf.getSaldo() != 0.0) {
                resultado = false;
                pf.imprimirEstadoCuenta();
            }
        }
        return resultado;
    }

}
