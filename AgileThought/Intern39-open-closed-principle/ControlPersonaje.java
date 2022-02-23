public class ControlPersonaje {

    private boolean irArriba = false;
    private boolean irAbajo = false;
    private boolean irDerecha = false;
    private boolean irIzquierda = false;
    private boolean atacar = false;
    private int posX;
    private int posY;

    public static final String TECLA_ARRIBA = "KEY_UP";
    public static final String TECLA_ABAJO = "KEY_DOWN";
    public static final String TECLA_IZQUIERDA = "KEY_LEFT";
    public static final String TECLA_DERECHA = "KEY_RIGHT";
    public static final String TECLA_ESPACIO = "SPACE_BAR";

    public Personaje per;
    public ObjetoJuego obju;

    public void alPresionarTecla(String tecla) {
        switch (tecla) {
            case TECLA_ARRIBA:
                irArriba = true;
                break;
            case TECLA_ABAJO:
                irAbajo = true;
                break;
            case TECLA_IZQUIERDA:
                irIzquierda = true;
                break;
            case TECLA_DERECHA:
                irDerecha = true;
                break;
            case TECLA_ESPACIO:
                atacar = true;
                break;
        }
    }

    public void alLiberarTecla(String tecla) {
        switch (tecla) {
            case TECLA_ARRIBA:
                irArriba = false;
                break;
            case TECLA_ABAJO:
                irAbajo = false;
                break;
            case TECLA_IZQUIERDA:
                irIzquierda = false;
                break;
            case TECLA_DERECHA:
                irDerecha = false;
                break;
            case TECLA_ESPACIO:
                atacar = false;
                break;
        }
    }

    protected void ataqueControlado() {
        int danio = per.getTipo();
        for (ObjetoCercano o : obju.objetosCercanos) {
            if (o.getDistancia() <= per.getRangoVision()){
                int sa = o.getObjeto().getSalud();
                o.getObjeto().setSalud(sa -= danio);
            }
                
        }
    }

    protected void movimientoControlado() {
        if (irArriba) {
            posY += per.getVelocidad();
        } else if (irAbajo) {
            posY -= per.getVelocidad();
        }
        if (irDerecha) {
            posX += per.getVelocidad();
        } else if (irIzquierda) {
            posX -= per.getVelocidad();
        }
    }

}
