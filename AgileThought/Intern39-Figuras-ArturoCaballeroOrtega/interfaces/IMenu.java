package interfaces;

import excepciones.ProcesoInterrumpidoException;

public interface IMenu<T> {
    T getNombre(String mensaje) throws ProcesoInterrumpidoException;
}