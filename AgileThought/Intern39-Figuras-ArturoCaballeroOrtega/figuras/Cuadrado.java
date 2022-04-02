package figuras;

import java.text.NumberFormat;
import java.util.Locale;

import interfaces.IMedidas;

public class Cuadrado implements IMedidas {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return this.lado * 4;
    }

    @Override
    public double calcularArea() {
        return Math.pow(this.lado, 2);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en" , "UK"));
        return "Cuadrado: " + "perimetro " + nf.format(calcularPerimetro()) + " area " + nf.format(calcularArea())
                + " lados " + nf.format(this.lado);
    }
}
