public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public void calcularPerimetro() {
        super.perimetro = (this.radio * 2) * Math.PI;
    }

    @Override
    public void calcularArea() {
        super.area = Math.pow(this.radio, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                ", perimetro=" + perimetro +
                ", area=" + area +
                '}';
    }
}
