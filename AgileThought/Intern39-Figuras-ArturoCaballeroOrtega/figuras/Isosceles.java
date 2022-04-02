package figuras;

import java.text.NumberFormat;
import java.util.Locale;

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
        double h = getAltura();
        return (this.lado * h) / 2;
    }

    public double getAltura() {
        double h = Math.sqrt(Math.pow(this.lado, 2) - (Math.pow(this.base, 2) / 4));
        return h;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en" , "UK"));
        return "Cuadrado: " + "perimetro " + nf.format(calcularPerimetro()) + " area " + nf.format(calcularArea()) + " lados " + nf.format(this.lado)
                + " base " + nf.format(this.base) + " altura " + nf.format(getAltura());
    }
}
