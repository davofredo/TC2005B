package constants;

public enum OpcionesMenuEnum {
    REGISTRAR_CALCULO("Registrar nuevo cálculo de figura", 1),
    ABRIR_ARCHIVOS("Abrir archivos con cálculos generados", 2),
    SALIR("Salir", 3);
    
    private final String opcion;
    private final int opcionNumero;

    private OpcionesMenuEnum(String opcion, int opcionNumero) {
        this.opcion = opcion;
        this.opcionNumero = opcionNumero;
    }

    public String getOpcion() {
        return opcion;
    }
    
    public int getOpcionNumero() {
        return opcionNumero;
    }
}
