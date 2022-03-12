public class Configuracion {
    private double maxLineaCreditoPorIngresoMensual;
    private double impuestoPorInteresGenerado;

    public Configuracion() {
        this.maxLineaCreditoPorIngresoMensual = 600.5;
        this.impuestoPorInteresGenerado = 0.4;
    }

    public double getImpuestoPorInteresGenerado() {
        return impuestoPorInteresGenerado;
    }

    public void setImpuestoPorInteresGenerado(double impuestoPorInteresGenerado) {
        this.impuestoPorInteresGenerado = impuestoPorInteresGenerado;
    }

    public double getMaxLineaCreditoPorIngresoMensual() {
        return maxLineaCreditoPorIngresoMensual;
    }

    public void setMaxLineaCreditoPorIngresoMensual(double maxLineaCreditoPorIngresoMensual) {
        this.maxLineaCreditoPorIngresoMensual = maxLineaCreditoPorIngresoMensual;
    }
}
