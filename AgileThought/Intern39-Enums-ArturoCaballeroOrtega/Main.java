import javax.swing.JOptionPane;

import constant.Mensajes;
import constant.TipoFigurasEnum;
import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Equilatero;
import figuras.Isosceles;
import figuras.Rectangulo;
import interfaces.IMedidas;

public class Main {

    /*
     * public static final String FIGURA_CIRCULO = "Circulo";
     * public static final String FIGURA_CUADRADO = "Cuadrado";
     * public static final String FIGURA_RECTANGULO = "Rectangulo";
     */

    public static void main(String[] args) {
        while (true) {
            try {
                String nombreFigura = JOptionPane.showInputDialog(Mensajes.INGRESO_NOMBRE_FIGURA);
                TipoFigurasEnum figura = getNombreFiguras(nombreFigura);
                IMedidas medidas = null;

                /*
                 * if (nombreFigura.equalsIgnoreCase(FIGURA_CIRCULO)) {
                 * System.out.println("Calcular perimetro y area del circulo");
                 * double radio =
                 * Double.parseDouble(JOptionPane.showInputDialog("Ingresa el radio en cm"));
                 * figura = new Circulo(radio);
                 * } else if (nombreFigura.equalsIgnoreCase(FIGURA_CUADRADO)) {
                 * System.out.println("Calcular perimetro y area del cuadrado");
                 * double lado =
                 * Double.parseDouble(JOptionPane.showInputDialog("Ingresa el lado en cm"));
                 * figura = new Cuadrado(lado);
                 * } else if (nombreFigura.equalsIgnoreCase(FIGURA_RECTANGULO)) {
                 * System.out.println("Calcular perimetro y area del rectangulo");
                 * double base =
                 * Double.parseDouble(JOptionPane.showInputDialog("Ingresa la base en cm"));
                 * double altura =
                 * Double.parseDouble(JOptionPane.showInputDialog("Ingresa la altura en cm"));
                 * figura = new Rectangulo(base, altura);
                 * }
                 */

                switch (figura) {
                    case CIRCULO:
                        double radio = Double.parseDouble(JOptionPane
                                .showInputDialog(String.format(Mensajes.INGRESO_RADIO, Mensajes.UNIDAD_MEDIDA_CM)));
                        medidas = new Circulo(radio);
                        break;
                    case CUADRADO:
                        double lado = Double.parseDouble(JOptionPane
                                .showInputDialog(String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                        medidas = new Cuadrado(lado);
                        break;
                    case RECTANGULO:
                        double base = Double.parseDouble(JOptionPane
                                .showInputDialog(String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                        double altura = Double.parseDouble(JOptionPane
                                .showInputDialog(
                                        String.format(Mensajes.INGRESO_ALTURA, Mensajes.UNIDAD_MEDIDA_CM)));
                        medidas = new Rectangulo(base, altura);
                        break;
                    case EQUILATERO:
                        double lados = Double.parseDouble(JOptionPane
                                .showInputDialog(String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                        medidas = new Equilatero(lados);
                        break;
                    case ISOSCELES:
                        double lad = Double.parseDouble(JOptionPane
                                .showInputDialog(String.format(Mensajes.INGRESO_LADO, Mensajes.UNIDAD_MEDIDA_CM)));
                        double bas;
                        // do {
                        bas = Double.parseDouble(JOptionPane
                                .showInputDialog(String.format(Mensajes.INGRESO_BASE, Mensajes.UNIDAD_MEDIDA_CM)));
                        // } while (bas > lad);
                        medidas = new Isosceles(lad, bas);
                        break;
                    default:
                        break;
                }

                /*
                 * } else if (nombreFigura.equalsIgnoreCase(TipoFigurasEnum.CUADRADO.name())) {
                 * System.out.println("Calcular perimetro y area del cuadrado");
                 * 
                 * } else if (nombreFigura.equalsIgnoreCase(TipoFigurasEnum.RECTANGULO.name()))
                 * {
                 * System.out.println("Calcular perimetro y area del rectangulo");
                 * double base =
                 * Double.parseDouble(JOptionPane.showInputDialog("Ingresa la base en cm"));
                 * double altura =
                 * Double.parseDouble(JOptionPane.showInputDialog("Ingresa la altura en cm"));
                 * figura = new Rectangulo(base, altura);
                 * }
                 */

                String mensaje = String.format(Mensajes.MENSAJE_SALIDA, figura, medidas.calcularPerimetro(),
                        medidas.calcularArea());
                // String mensaje = "La figura ingresada fue " + nombreFigura + ", que tiene
                // como perimetro: " + medidas.calcularPerimetro() + " y area: " +
                // medidas.calcularArea();
                // System.out.println(mensaje);
                JOptionPane.showMessageDialog(null, mensaje);
                break;

            } catch (NullPointerException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una figura");
            }// catch (NumberFormatException e) {
            //    JOptionPane.showMessageDialog(null, "Debe ingresar un número");
            //}
        }

    }

    public static TipoFigurasEnum getNombreFiguras(String nombreFigura) {
        TipoFigurasEnum[] tipoFigurasEnums = TipoFigurasEnum.values();

        for (TipoFigurasEnum tipoFigurasEnum : tipoFigurasEnums) {
            if (tipoFigurasEnum.name().equalsIgnoreCase(nombreFigura)) {
                return tipoFigurasEnum;
            }
        }

        return null;
    }
}
