public class CuentaInversion extends CuentaBancaria {

    private double interesAlCorte;
    private double impuesto = 1.0;
    
    public CuentaInversion(double balanceInicial, double interesAlCorte) {
        super(balanceInicial);
        this.interesAlCorte = interesAlCorte;
    }
    
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void aplicarCorte() {
        // Balance 2000          
        // Tasa 5%               
        // Interes bruto 100     
        // Impuesto 15%          
        // Interes neto 85       
        // Balance 2085          
        agregarFondos((getBalance() * interesAlCorte) * impuesto);
    }


    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("Estado de Cuenta de Inversión ...");
        System.out.println("Balance: " + getBalance());
        System.out.println("Tasa de Interés: " + interesAlCorte);

    }
}
