import java.util.Scanner;

public class EvaluacionEdad {
    public static void main(String[] args) {
        System.out.println("Ingrese la edad");
        Scanner scanner = new Scanner(System.in);
        int edad = scanner.nextInt();

        String respuesta = (edad >= 18) ? "Puede votar" : "No es mayor de edad";
        System.out.println(respuesta);

        /**
         * Login:
         * Se pide usuario y contraseña
         * Evaluar si son iguales a los definidos
         * sies veradero: "inicio sesión", de lo contrario "usuario y/o password
         * invalidos"
         */

        final String USUARIO = "admin";
        final String PASSWORD = "123456";
        
        System.out.println("Ingrese el usuario");
        String nomUsuario = System.console().readLine();
        System.out.println("Ingrese el password");
        String contrasena = System.console().readLine();
        String isValid = USUARIO.equals(nomUsuario) && PASSWORD.equals(contrasena) ? "Inicio sesion"
                : "Usuario y/o password invalidos";
        System.out.println(isValid);
    }
}
