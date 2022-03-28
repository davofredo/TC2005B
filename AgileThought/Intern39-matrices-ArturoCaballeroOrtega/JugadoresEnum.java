public enum JugadoresEnum {
    JUGADOR_A("X"),
    JUGADOR_B("O");

    private final String ficha;

    JugadoresEnum(String ficha) {
        this.ficha = ficha;
    }

    public String getFicha() {
        return ficha;
    }
}