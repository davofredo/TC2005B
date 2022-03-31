public class Cuadrado extends Figura {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public void calcularPerimetro() {
        super.perimetro = this.lado * 4;
    }

    @Override
    public void calcularArea() {
        super.area = this.lado * lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                ", perimetro=" + perimetro +
                ", area=" + area +
                '}';
    }
}
