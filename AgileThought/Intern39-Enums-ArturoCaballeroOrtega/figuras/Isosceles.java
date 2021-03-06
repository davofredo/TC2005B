package figuras;

import interfaces.IMedidas;

public class Isosceles implements IMedidas {

    private double lado;
    private double base;

    public Isosceles(double lado, double base) {
        this.lado = lado;
        this.base = base;
    }

    @Override
    public double calcularPerimetro() {
        return (this.lado * 2) + this.base;
    }

    @Override
    public double calcularArea() {
        double h = Math.sqrt(Math.pow(this.lado, 2) - (Math.pow(this.base, 2) / 4));
        return (this.lado * h) / 2;
    }

}
