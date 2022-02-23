import java.util.List;

public class ObjetoJuego {
    public static final String TIPO_ZOMBI = "z";
    public static final String TIPO_SOLDADO = "s";
    public static final String TIPO_ESPADACHIN = "e";
    public static final String TIPO_ROCA = "r";
    public static final String TIPO_PUERTA = "p";
    public static final String TIPO_LLAVE = "l";
    public List<ObjetoCercano> objetosCercanos;

    private int posX;
    private int posY;
    private int velocidad;
    private int rangoVision;
    private boolean controlado;
    private int salud;

    public ObjetoJuego(int velocidad, int rangoVision, boolean controlado, int salud, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.velocidad = velocidad;
        this.rangoVision = rangoVision;
        this.controlado = controlado;
        this.salud = salud;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getRangoVision() {
        return rangoVision;
    }

    public boolean getControlado() {
        return controlado;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public ObjetoJuego(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void alAcercarseUnObjeto(ObjetoCercano objeto) {
        objetosCercanos.add(objeto);
    }

    public void alAlejarseUnObjeto(ObjetoCercano objeto) {
        objetosCercanos.remove(objeto);
    }
}

