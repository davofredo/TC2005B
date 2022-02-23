public class PedirHamburguesaImpl implements IPedirHamburguesas {

    @Override
    public void pedirHamburguesa() {
        System.out.println("Pidiendo hhamburguesa");
        
    }

    @Override
    public void confirmarOrder() {
        System.out.println("Pagando el producto");
        System.out.println("entregando el producto");
    }
    
}
