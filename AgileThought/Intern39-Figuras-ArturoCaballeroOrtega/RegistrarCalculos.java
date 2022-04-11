import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

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
import interfaces.IMenu;
import java.util.stream.Stream;

public class RegistrarCalculos implements IMenu<TipoFigurasEnum> {

    public static void figuras() {
        ProcesosEnum procesoActual = ProcesosEnum.INGRESO_FIGURA;
        TipoFigurasEnum figura = null;
        boolean procesoCompletado = false;
        StringBuilder sb = new StringBuilder(Mensajes.INGRESO_OPCION_FIGURA);
        TipoFigurasEnum[] figuras = TipoFigurasEnum.values();
        IMedidas medidas = null;
        StringBuilder mensaje = new StringBuilder();
        RegistrarCalculos regCalculos = new RegistrarCalculos();
        for (TipoFigurasEnum f : figuras) {
            sb.append(String.format(Mensajes.FORMATO_OPCIONES, f.getOpcion(), f.getNombre()));
        }

        do {
            try {
                // TODO: El codigo se torna mas complicado de lo necesario, al igual que con la clase Menu
                switch (procesoActual) {
                    case INGRESO_FIGURA:
                        figura = regCalculos.getNombre(sb.toString());
                        System.out.println("figura = " + figura);
                    case INGRESO_VALORES:
                        switch (figura) {
                            case CIRCULO:
                                // TODO: Posible NumberFormatException no manejado
                                double radio = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_RADIO, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Circulo(radio);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, medidas.toString()));
                                break;
                            case CUADRADO:
                                // TODO: Posible NumberFormatException no manejado
                                double lado = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Cuadrado(lado);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, medidas.toString()));
                                break;
                            case RECTANGULO:
                                // TODO: Posible NumberFormatException no manejado
                                double base = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                                // TODO: Posible NumberFormatException no manejado
                                double altura = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_ALTURA, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Rectangulo(base, altura);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, medidas.toString()));
                                break;
                            case TRIANGULO_EQUILATERO:
                                // TODO: Posible NumberFormatException no manejado
                                double lad = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Equilatero(lad);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, medidas.toString()));
                                break;
                            case TRIANGULO_ISOSCELES:
                                // TODO: Posible NumberFormatException no manejado
                                double la = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                                // TODO: Posible NumberFormatException no manejado
                                double bas = Double.parseDouble(JOptionPane.showInputDialog(
                                        String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                                medidas = new Isosceles(la, bas);
                                mensaje.append(String.format(Mensajes.MENSAJE_SALIDA, medidas.toString()));
                                break;
                            default: // TODO: El default no resulta muy util
                                break;
                        }
                    default: // TODO: El default no resulta muy util
                        break;
                }
                JOptionPane.showMessageDialog(null, mensaje);
                Thread h1 = new Thread(new GuardarArchivo(figura, medidas));
                h1.start();
                procesoCompletado = true;
            } catch (ProcesoInterrumpidoException ex) {
                procesoActual = ex.getProceso();
                if (ex.getMessage() != null) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        } while (!procesoCompletado);
    }

    @Override
    public TipoFigurasEnum getNombre(String opciones) throws ProcesoInterrumpidoException {
        try {
            String opcionFigura = JOptionPane.showInputDialog(opciones);

            if (opcionFigura == null) {
                throw new NullPointerException();
            }

            int opcion = Integer.parseInt(opcionFigura);
            return Stream.of(TipoFigurasEnum.values()).filter(f -> f.getOpcion() == opcion).findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException | NumberFormatException ex) {
            throw new ProcesoInterrumpidoException("Nombre de figura inválido", ProcesosEnum.INGRESO_FIGURA);
        } catch (NullPointerException ex) {
            throw new ProcesoInterrumpidoException(ProcesosEnum.INGRESO_FIGURA);
        }
    }
}
