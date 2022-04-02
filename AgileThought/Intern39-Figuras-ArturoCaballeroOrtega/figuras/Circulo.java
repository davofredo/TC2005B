package figuras;

import java.text.NumberFormat;
import java.util.Locale;

import interfaces.IMedidas;

public class Circulo implements IMedidas {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI * (this.radio * 2);
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    public double getRadio() {
        return radio;
    }

    public double getDiametro() {
        return radio * 2;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "UK"));
        return "Circulo: " + "perimetro " + nf.format(calcularPerimetro()) + " area " + nf.format(calcularArea())
                + " radio " + nf.format(this.radio)
                + " y de diametro " + nf.format(getDiametro());
    }
}
