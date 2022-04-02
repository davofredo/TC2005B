package figuras;

import java.text.NumberFormat;
import java.util.Locale;

import interfaces.IMedidas;

public class Rectangulo implements IMedidas {

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularPerimetro() {
        return (double) ((this.base * 2) + (this.altura * 2));
    }

    @Override
    public double calcularArea() {
        return (double) (this.base * this.altura);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en" , "UK"));
        return "Cuadrado: " + "perimetro " + nf.format(calcularPerimetro()) + " area " + nf.format(calcularArea())
                + " base " + nf.format(this.base)
                + " altura " + nf.format(this.altura);
    }
}
