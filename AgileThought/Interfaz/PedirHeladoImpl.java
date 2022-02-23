public class PedirHeladoImpl implements IPedirHelado {

    @Override
    public void pedirHelado() {
        System.out.println("Pidiendo helado");
    }

    @Override
    public void confirmarOrder() {
        System.out.println("Pagando el producto");
        System.out.println("entregando el producto");
    }
    
}
