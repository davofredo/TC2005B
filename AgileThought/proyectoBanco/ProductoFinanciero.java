public interface ProductoFinanciero {
    double getSaldo();
    void reducirFondos(double importe);
    void agregarFondos(double importe);
    void imprimirEstadoCuenta();
}
