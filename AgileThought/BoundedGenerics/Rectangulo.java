public class Rectangulo extends Figura {

    private double largo;
    private double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public void calcularPerimetro() {
        super.perimetro = (this.largo * 2) + (this.ancho * 2);
    }

    @Override
    public void calcularArea() {
        this.area = this.largo * this.ancho;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "perimetro=" + perimetro +
                ", area=" + area +
                ", largo=" + largo +
                ", ancho=" + ancho +
                '}';
    }
}
