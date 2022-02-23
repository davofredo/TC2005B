package com.at.intership;

public class CuentaInversion extends CuentaBancaria {

    private double interesAlCorte;

    public CuentaInversion(double balanceInicial, double interesAlCorte) {
        super(balanceInicial);
        this.interesAlCorte = interesAlCorte;
    }

    public void aplicarCorte() {
        agregarFondos(getBalance() * interesAlCorte);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("Estado de Cuenta de Inversión ...");
        System.out.println("Balance: " + getBalance());
        System.out.println("Tasa de Interés: " + interesAlCorte);
    }
}
