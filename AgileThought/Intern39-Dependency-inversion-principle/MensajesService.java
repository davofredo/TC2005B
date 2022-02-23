public class MensajesService implements EnvioMensaje {

    @Override
    public void enviarMensaje(Object object) {
        System.out.println(object);
    }
    
}
