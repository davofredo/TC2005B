public class Personaje extends ObjetoJuego {
    private int tipo;

    public Personaje(int tipo, int velocidad, int rangoVision, boolean controlado, int salud, int posX, int posY) {
        super(velocidad, rangoVision, controlado, salud, posX, posY);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

}
