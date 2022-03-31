import javax.swing.JOptionPane;

import constants.Mensajes;
import constants.OpcionesMenuEnum;
import constants.ProcesosEnum;
import excepciones.ProcesoInterrumpidoException;
import interfaces.IMenu;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Menu implements IMenu<OpcionesMenuEnum> {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean terminado = false;
        ProcesosEnum procesoA = ProcesosEnum.INGRESAR_OPCION;
        OpcionesMenuEnum oMenuEnum = null;
        StringBuilder sb = new StringBuilder(Mensajes.MENU_PRINCIPAL);
        OpcionesMenuEnum[] oMenuEnums = OpcionesMenuEnum.values();

        for (OpcionesMenuEnum op : oMenuEnums)
            sb.append(String.format(Mensajes.FORMATO_OPCIONES, op.getOpcionNumero(), op.getOpcion()));

        do {
            try {
                switch (procesoA) {
                    case INGRESAR_OPCION:
                        Menu menu = new Menu();
                        oMenuEnum = menu.getNombre(sb.toString());
                        System.out.println("Opción = " + oMenuEnum);
                    case INGRESO_VALORES:
                        switch (oMenuEnum) {
                            case REGISTRAR_CALCULO:
                                RegistrarCalculos.figuras();
                                break;
                            case ABRIR_ARCHIVOS:

                                break;
                            case SALIR:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            } catch (ProcesoInterrumpidoException e) {
                procesoA = e.getProceso();
                if (e.getMessage() != null)
                    JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (!terminado);
    }

    @Override
    public OpcionesMenuEnum getNombre(String mensaje) throws ProcesoInterrumpidoException {
        try {
            String opcionMenu = JOptionPane.showInputDialog(mensaje);

            if (opcionMenu == null)
                throw new NullPointerException();

            int opcion = Integer.parseInt(opcionMenu);
            return Stream.of(OpcionesMenuEnum.values()).filter(f -> f.getOpcionNumero() == opcion).findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException | NumberFormatException ex) {
            throw new ProcesoInterrumpidoException("Opción no valida", ProcesosEnum.INGRESAR_OPCION);
        } catch (NullPointerException ex) {
            int opcionUsuario = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");

            if (opcionUsuario == 0)
                System.exit(0);

            throw new ProcesoInterrumpidoException(ProcesosEnum.INGRESAR_OPCION);
        }
    }
}
