public class PedidoService {
    
    public void confirmarPedido(){
        EnvioMensaje m = mensaje();
        m.enviarMensaje("Confirmar pedido..");
    }

    public static EnvioMensaje mensaje() {
        return new MensajesService();
    }

}
