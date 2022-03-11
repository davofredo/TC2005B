public class Main {
    public static void main(String[] args) {
        int contador = 0;
        do {
                String user = System.console().readLine("Usuario: ");
                //System.out.println("Contrasena: ");
                String password = new String(System.console().readPassword("Contrasena: "));
                if (user.equals("admin") && password.equals("admin123")){
                    Menu.menu();
                    contador = 3;
                }
                contador++;
        } while (contador < 3);
    }
}
