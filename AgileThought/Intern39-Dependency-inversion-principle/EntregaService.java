public class EntregaService {

    public void confirmarEntrega() {
        EnvioMensaje m = mensaje();
        m.enviarMensaje("Pedido entregado..");
    }
    
    public static EnvioMensaje mensaje() {
        return new MensajesService();
    }
}
