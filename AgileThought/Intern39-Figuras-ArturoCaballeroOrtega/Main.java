import constants.Mensajes;
import constants.ProcesosEnum;
import constants.TipoFigurasEnum;
import excepciones.ProcesoInterrumpidoException;
import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Equilatero;
import figuras.Isosceles;
import figuras.Rectangulo;
import interfaces.IMedidas;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Main {

    /**
     * Reto 1: asegurarse que en el método getNombre todas las excepciones estén
     * controladas, si hay alguna excepción que no se está controlanddo, adaptarlo a
     * la regla
     * Reto 2: implementar los cálculos de las figuras utilizando swtich-case
     * Reto 3: Imprimir el mensaje del resultado del perímetro y área de la figura
     * seleccionada, se debe agregar los atributos adicionales, ej. circulo - radio,
     * cuadrado - lado, rectangulo - largo y ancho, triangulo equilatero - lados,
     * altura, triangulo isosceles - lado, base -altura. La figura seleccionada es
     * (Circulo, Cuadrado, etc.), que tiene como (radio : xx cm y diámetro xx cm,
     * lado, largo y ancho, lado y altura, lado, base y altura), su perímetro es de
     * xx cm y su área es de xx cm
     * Reto 4 (opcional): Organizar en paquete 'Services' (lógica de negocios de la
     * aplicación) ej. CalculoFigurasService
     */

    public static void main(String[] args) {
        ProcesosEnum procesoActual = ProcesosEnum.INGRESO_FIGURA;
        TipoFigurasEnum figura = null;
        boolean procesoCompletado = false;
        StringBuilder sb = new StringBuilder(Mensajes.INGRESO_OPCION_FIGURA);
        TipoFigurasEnum[] figuras = TipoFigurasEnum.values();
        IMedidas medidas = null;
        StringBuilder mensaje = new StringBuilder();

        for (TipoFigurasEnum f : figuras) {
            sb.append(String.format(Mensajes.FORMATO_OPCIONES_FIGURAS, f.getOpcion(), f.getNombre()));
        }

        do {
            try {
                switch (procesoActual) {
                    case INGRESO_FIGURA:
                        figura = getNombre(sb.toString());
                        System.out.println("figura = " + figura);
                    case INGRESO_VALORES:
                        switch (figura) {
                            case CIRCULO:
                                double radio = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_RADIO, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Circulo(radio);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, figura, "radio",
                                        radio, Mensajes.UNIDAD_MEDIDA_CM, "diametro",
                                        ((Circulo) medidas).getDiametro(), Mensajes.UNIDAD_MEDIDA_CM,
                                        medidas.calcularPerimetro(), Mensajes.UNIDAD_MEDIDA_CM, medidas.calcularArea(),
                                        Mensajes.UNIDAD_MEDIDA_CM));
                                break;
                            case CUADRADO:
                                double lado = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Cuadrado(lado);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, figura, "lado",
                                        lado, Mensajes.UNIDAD_MEDIDA_CM, "",
                                        "", "",
                                        medidas.calcularPerimetro(), Mensajes.UNIDAD_MEDIDA_CM, medidas.calcularArea(),
                                        Mensajes.UNIDAD_MEDIDA_CM));
                                break;
                            case RECTANGULO:
                                double base = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                                double altura = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_ALTURA, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Rectangulo(base, altura);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, figura, "base",
                                        base, Mensajes.UNIDAD_MEDIDA_CM, "altura",
                                        altura, Mensajes.UNIDAD_MEDIDA_CM,
                                        medidas.calcularPerimetro(), Mensajes.UNIDAD_MEDIDA_CM, medidas.calcularArea(),
                                        Mensajes.UNIDAD_MEDIDA_CM));
                                break;
                            case TRIANGULO_EQUILATERO:
                                double lad = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Equilatero(lad);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, figura, "lados",
                                        lad, Mensajes.UNIDAD_MEDIDA_CM, "altura",
                                        ((Equilatero) medidas).getAltura(), Mensajes.UNIDAD_MEDIDA_CM,
                                        medidas.calcularPerimetro(), Mensajes.UNIDAD_MEDIDA_CM, medidas.calcularArea(),
                                        Mensajes.UNIDAD_MEDIDA_CM));
                                break;
                            case TRIANGULO_ISOSCELES:
                                double la = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                                double bas = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Isosceles(la, bas);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, figura, "lados",
                                        String.format(Mensajes.MENSAJE_SALIDA_ISOSCELES, la, Mensajes.UNIDAD_MEDIDA_CM,
                                                la, Mensajes.UNIDAD_MEDIDA_CM, bas, Mensajes.UNIDAD_MEDIDA_CM),
                                        "", "altura",
                                        ((Isosceles) medidas).getAltura(), Mensajes.UNIDAD_MEDIDA_CM,
                                        medidas.calcularPerimetro(), Mensajes.UNIDAD_MEDIDA_CM, medidas.calcularArea(),
                                        Mensajes.UNIDAD_MEDIDA_CM));
                                break;
                            default:
                                break;
                        }
                }
                JOptionPane.showMessageDialog(null, mensaje);
                procesoCompletado = true;
            } catch (ProcesoInterrumpidoException ex) {
                procesoActual = ex.getProceso();
                if (ex.getMessage() != null) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        } while (!procesoCompletado);

    }

    public static TipoFigurasEnum getNombre(String mensaje) throws ProcesoInterrumpidoException {
        try {
            String opcionFigura = JOptionPane.showInputDialog(mensaje);

            if (opcionFigura == null) {
                throw new NullPointerException();
            }

            int opcion = Integer.parseInt(opcionFigura);
            return Stream.of(TipoFigurasEnum.values()).filter(f -> f.getOpcion() == opcion).findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException | NumberFormatException ex) {
            throw new ProcesoInterrumpidoException("Nombre de figura inválido", ProcesosEnum.INGRESO_FIGURA);
        } catch (NullPointerException ex) {
            int opcionUsuario = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");

            if (opcionUsuario == 0) {
                System.exit(0);
            }

            throw new ProcesoInterrumpidoException(ProcesosEnum.INGRESO_FIGURA);
        }
    }
}