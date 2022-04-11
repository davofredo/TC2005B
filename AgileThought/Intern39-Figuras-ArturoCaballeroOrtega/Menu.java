import javax.swing.JOptionPane;

import constants.Mensajes;
import constants.OpcionesMenuEnum;
import constants.ProcesosEnum;
import excepciones.ProcesoInterrumpidoException;
import interfaces.IMenu;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Menu implements IMenu<OpcionesMenuEnum> {

    public static void menu() {
        boolean terminado = false; // TODO: Este flag no hace nada
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
                        // TODO: Usar un case para manipular la logica del siguiente case complica el codigo
                        //  mas de lo recomendable
                        oMenuEnum = menu.getNombre(sb.toString());
                        System.out.println("Opción = " + oMenuEnum);
                        // TODO: Tal parece que el switch se esta usando para detonar las etapas
                        //  de "ingresar opcion" e "ingresar valores". Este NO es el uso adecuado de
                        //  un switch y hace el codigo dificil de entender y mantener.
                        //  Quizas seria mejor poner cada etapa en un metodo e invocarlos en secuencia.
                        //  Al poner "ingresar valores" en un metodo separado, sera posible invocarlo,
                        //  incluso dentro de un flujo excepcional, sin necesidad de usar e.getProceso,
                        //  para saltarse la etapa de ingresar opcion en el siguiente loop.
                    case INGRESO_VALORES:
                        switch (oMenuEnum) {
                            case REGISTRAR_CALCULO:
                                RegistrarCalculos.figuras();
                                break;
                            case ABRIR_ARCHIVOS:
                                AbrirRegistro.registro();
                                break;
                            case SALIR:
                                // TODO: Hay dos mejores alternativas al System.exit:
                                //  A. Asignar true a terminado
                                //  B. Usar un return para terminar el metodo
                                System.exit(0);
                                break;
                            default: // TODO: Si el default no tiene utilidad, se puede omitir
                                break;
                        }
                    default: // TODO: Si el default no tiene utilidad, se puede omitir
                        break;
                }
            } catch (ProcesoInterrumpidoException e) {
                // TODO: Usar una excepcion para determinar la siguiente etapa es demasiado rebuscado.
                //  Esto hara el codigo dificil de entender y mantener.
                procesoA = e.getProceso();
                if (e.getMessage() != null)
                    JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (!terminado); // TODO: Terminado nunca se vuelve true. Si el flag nunca va a detener el loop, es preferible usar while(true)
    }

    @Override
    public OpcionesMenuEnum getNombre(String mensaje) throws ProcesoInterrumpidoException {
        try {
            String opcionMenu = JOptionPane.showInputDialog(mensaje);

            if (opcionMenu == null)
                // TODO: Por que lanzar un null pointer exception cuando se puede manejar dentro del if?
                throw new NullPointerException();

            int opcion = Integer.parseInt(opcionMenu);
            return Stream.of(OpcionesMenuEnum.values()).filter(f -> f.getOpcionNumero() == opcion).findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException | NumberFormatException ex) {
            // Ingenioso :)
            throw new ProcesoInterrumpidoException("Opción no valida", ProcesosEnum.INGRESAR_OPCION);
        } catch (NullPointerException ex) {
            // TODO: Este metodo, podria no ser el lugar adecuado para esta logica.
            //  En su lugar, quizas seria mejor lanzar un custom exception que sea atrapado por el loop principal,
            //  y que el catch que lo maneje sea el responsable de terminar el loop. De esta forma, se podria
            //  evitar el System.exit(0).
            //  Tambien recuerda que podrian haber otras causas de un NullPointerException,
            //  no necesariamente la cancelacion de la entrada. Este es otro punto a favor de lanzar un
            //  custom exception en lugar de un NullPointerException
            int opcionUsuario = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");

            if (opcionUsuario == 0)
                // TODO: Esta no es la manera mas elegante de terminar la aplicacion
                System.exit(0);

            // TODO: Esta excepcion
            throw new ProcesoInterrumpidoException(ProcesosEnum.INGRESAR_OPCION);
        }
    }
}
