public class ControlBot {

    private static final int DANIO_ZOMBI = 3;
    public Bot bot;
    public ObjetoJuego obju;

    protected void ataqueBot() {
        for (ObjetoCercano o : obju.objetosCercanos) {
            if (o.getDistancia() <= bot.getRangoVision()) {
                int sa = o.getObjeto().getSalud();
                o.getObjeto().setSalud(sa  -= DANIO_ZOMBI);
                return;
            }
        }
    }

    protected void movimientoBot() {
        // TODO:
    }

}
