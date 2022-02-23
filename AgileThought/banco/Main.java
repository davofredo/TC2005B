package com.at.intership;

import java.lang.module.Configuration;

import javax.naming.ConfigurationException;

public class Main {

    public static void main(String[] args) {
        // Cuenta genérica
//        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000.0);
//        System.out.println("Balance inicial: " + cuentaBancaria.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaBancaria.reducirFondos(600.0);
//        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaBancaria.reducirFondos(600.0);
//        System.out.println("Nuevo balance:" + cuentaBancaria.getBalance());

        // Cuenta cheques
//        CuentaCheques cuentaCheques = new CuentaCheques(1000, 5.0);
//        System.out.println("Balance inicial: " + cuentaCheques.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaCheques.reducirFondos(600.0);
//        System.out.println("Nuevo balance: " + cuentaCheques.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaCheques.reducirFondos(600.0);
//        System.out.println("Nuevo balance:" + cuentaCheques.getBalance());
//        cuentaCheques.imprimirEstadoCuenta();

        // Cuenta inversion
//        CuentaInversion cuentaInversion = new CuentaInversion(1000.0, 0.05);
//        System.out.println("Balance inicial: " + cuentaInversion.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaInversion.reducirFondos(600.0);
//        System.out.println("Nuevo balance: " + cuentaInversion.getBalance());
//        System.out.println("Retiro: 600");
//        cuentaInversion.reducirFondos(600.0);
//        System.out.println("Nuevo balance:" + cuentaInversion.getBalance());
//        System.out.println("Aplicando corte...");
//        cuentaInversion.aplicarCorte();
//        System.out.println("Nuevo balance:" + cuentaInversion.getBalance());
//        cuentaInversion.imprimirEstadoCuenta();

        // Cuenta de cheques: Comisión por retiro
        // Cuenta de inversion: + intereses

        // Tarjeta de Credito
        TarjetaCredito tarjetaCredito = new TarjetaCredito(1000);
        System.out.println("Saldo inicial: " + tarjetaCredito.getSaldo());
        System.out.println("Linea de credito: " + tarjetaCredito.getLineaCredito());
        System.out.println("Cargar 600...");
        tarjetaCredito.cargarTarjeta(600);
        System.out.println("Nuevo saldo: " + tarjetaCredito.getSaldo());
        System.out.println("Cargar 600...");
        tarjetaCredito.cargarTarjeta(600);
        System.out.println("Nuevo saldo: " + tarjetaCredito.getSaldo());
        System.out.println("Pagar 600...");
        tarjetaCredito.pagarTarjeta(600);
        System.out.println("Nuevo saldo: " + tarjetaCredito.getSaldo());
        System.out.println("Pagar 600...");
        tarjetaCredito.pagarTarjeta(600);
        System.out.println("Nuevo saldo: " + tarjetaCredito.getSaldo());

        // Ejercicio: Cancelar cliente
        // 1. Si todos los productios financieros tienen saldo en 0, imprimir "Cancelación autorizada"
        // 2. Por cada producto financiero que no tenga saldo en 0 imprimir su estado de cuenta
        // 2.1. Al final de todos los estados de cuenta imprimir "Cancelación denegada"

        Cliente cliente = new Cliente("Arturo", "12345", 5000);
        Configuracion cof = new Configuracion();
        conf.setMaxLineaCreditoPorIngresoMensual(4.0);
        AdministradorProducto adm = new AdministradorProducto(conf);
        adm.agregarProducto(cliente, tarjetaCredito);
        System.out.println(String.format("El cliente %s ha solicitado cancelar sus cuentas", cliente.getNumCliente()));
        //cliente.agregarProducto(tarjetaCredito);
        if(ad.puedeCancelar(cliente)) {
            System.out.println("Cancelación autorizada");
        } else {
            for(ProductoFinanciero pf : cliente.getProductos()) {
                if(pf.getSaldo() != 0.0)
                    pf.imprimirEstadoCuenta();
            }
            System.out.println("Cancelación denegada");
        }

    }

}
