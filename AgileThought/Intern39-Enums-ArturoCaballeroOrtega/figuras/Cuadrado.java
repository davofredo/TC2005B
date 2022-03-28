package figuras;

import interfaces.IMedidas;

public class Cuadrado implements IMedidas {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return this.lado*4;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2);
    }
    
}
