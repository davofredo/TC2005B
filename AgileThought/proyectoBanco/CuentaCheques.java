public class CuentaCheques extends CuentaBancaria {

    private double comisionRetiro;

    public CuentaCheques(double balanceInicial, double comisionRetiro) {
        super(balanceInicial);
        this.comisionRetiro = comisionRetiro;
    }

    public double getComisionRetiro() {
        return comisionRetiro;
    }
    
    public void setComisionRetiro(double comisionRetiro) {
        this.comisionRetiro = comisionRetiro;
    }

    @Override
    public void reducirFondos(double importe) {
        double importeTotal = importe + comisionRetiro;
        super.reducirFondos(importeTotal);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("Estado de Cuenta de Cheques...");
        System.out.println("Balance actual: " + getBalance());
        System.out.println("Comision retiro: " + comisionRetiro);
    }

    @Override
    public void agregarFondos(double importe) {
        super.agregarFondos(importe);
    }

}
