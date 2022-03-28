package figuras;

import interfaces.IMedidas;

public class Equilatero implements IMedidas {

    private double lado;

    public Equilatero(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return this.lado * 3;
    }

    @Override
    public double calcularArea() {
        double h = getAltura();
        return (this.lado * h) / 2;
    }
    
    public double getAltura() {
        double h = Math.sqrt(Math.pow(this.lado, 2) + Math.pow(this.lado / 2, 2));
        return h;
    }
}
