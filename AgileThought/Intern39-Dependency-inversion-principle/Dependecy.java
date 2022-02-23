public class Dependecy {
    public static void main(String[] args) {
        PedidoService mensaje = new PedidoService();
        mensaje.confirmarPedido();
        System.out.println("----------");
        EntregaService mensa = new EntregaService();
        mensa.confirmarEntrega();
        String input = System.console().readLine();
    }
}
