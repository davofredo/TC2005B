import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.at.intership.Cliente;

public class AdministrarProducto {

    private Configuracion conf;
    //private List<ProductoFinanciero> productos = new ArrayList<>();
    private Map<String, List<ProductoFinanciero>> mapProductos = new HashMap<>();

    public AdministrarProducto(Configuracion conf) {
        this.conf = conf;
    }

    public void agregarProducto(ProductoFinanciero producto) {
        List<ProductoFinanciero> productos = mapProductos.get(cliente.getNumCliente());
        if(productos == null) {
            productos = new ArrayList<>();
            mapProductos.put(cliente.getNumCliente(), productos);
        }
        if (producto instanceof TarjetaCredito) {
            double ingresoMensual = cliente.getIngresoMensual();
            double lineaCredito = ((TarjetaCredito) producto).getLineaCredito();
            if (lineaCredito > ingresoMensual * conf.getMaxLineaCreditoPorIngresoMensual()) {
                System.out.println("Linea de credito excesiva para este cliente");;
            }
        }
        productos.add(producto);
    }

    public List<ProductoFinanciero> getProductos(String numClientes) {
        List<ProductoFinanciero> productos = mapProductos.get(numClientes);
        if(productos == null){
            System.out.println("El cliente no tiene productos agregados");
        }
        return productos;
    }

    public boolean puedeCancelar() {
        for(ProductoFinanciero pf : productos) {
            if(pf.getSaldo() != 0.0)
                return false;
                pf.imprimirEstadoCuenta;
        }
        return true;
    }
}
