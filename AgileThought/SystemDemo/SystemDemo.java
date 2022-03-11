import java.util.Objects;

public class SystemDemo {
    // Buena práctica de programación: Almacenar nombres de llaves en constantes
    // estáticas
    private static final String PROP_USERNAME = "com.at.internship.system.username";
    private static final String PROP_PASSWORD = "com.at.internship.system.password";
    private static final byte TRY_LIMIT = 3;

    public static void main(String[] args) {
        try {
            PropertyHandler.load("/application-default.properties", "application.properties");

            System.out.println("Login...");

            String username, password;

            boolean isLoggedIn = false;
            byte tryCount = 0;
            do {
                System.out.print("username: ");
                username = System.console().readLine();
                System.out.print("password: ");
                // Se usa System.console() para tener la habilidad de ocultar el password.
                // El uso de System.console() puede tener resultados impredecibles en la
                // terminal del IDE
                // Se recomienda ejecutar la aplicación desde una terminal real.
                password = new String(System.console().readPassword());
                if (Objects.equals(username, PropertyHandler.getStringProperty(PROP_USERNAME)) &&
                        Objects.equals(password, PropertyHandler.getStringProperty(PROP_PASSWORD)))
                    isLoggedIn = true;
                else
                    System.err.println("Incorrect username or password\n\n");
                tryCount++;
            } while (!isLoggedIn && tryCount < TRY_LIMIT);

            if (isLoggedIn) {
                System.out.printf("Successfully logged in as %s%n", username);
                runCommandListener();
            } else
                System.err.println("You have reached your attempts limit");

            PropertyHandler.persist();
            System.out.println("PROGRAM END");
        } catch (Exception e) {
            System.err.printf("%s: %s%n", e.getClass().getName(), e.getMessage());
        }
    }

    private static void runCommandListener() {
        String command;
        do {
            System.out.print(">_ ");
            command = System.console().readLine();
            // Buena práctica de programación: Encapsular la lógica de cada case en un una
            // función separada
            switch (command) {
                case "help":
                    printHelp();
                    break;
                case "chg-pass":
                    changePassword();
                    break;
                case "print-path":
                    printPath();
                    break;
                case "print-java-home":
                    printJavaHome();
                    break;
                case "sys-username":
                    printSystemUsername();
                    break;
                case "divide-double":
                    printDivideDouble();
                    break;
                case "divide-integer":
                    printDivideInteger();
                    break;
                case "exit":
                    // No recomendado: En la mayoría de los casos, no se recomienda invocar a
                    // System.exit(int)
                    // System.exit(0);
                    break;
                default:
                    System.err.printf("\"%s\" is not a recognized command%n", command);
            }
        } while (!"exit".equalsIgnoreCase(command));
    }

    private static void printHelp() {
        System.out.println("- help\n" +
                "- chg-pass\n" +
                "- print-path\n" +
                "- print-java-home\n" +
                "- sys-username\n" +
                "- divide-double\n" +
                "- divide-integer\n" +
                "- exit");
    }

    private static void printSystemUsername() {
        // Windows env variable: USERNAME
        // Unix env variables: USER || LOGNAME
        // Operating system agnostic property: user.name
        String osname = System.getProperty("os.name");
        String username = System.getProperty("user.name");
        System.out.printf("%s user name: %s%n", osname, username);
    }

    private static void printJavaHome() {
        System.out.printf("JAVA_HOME: %s%n", System.getProperty("java.home"));
    }

    private static void printPath() {
        String javaHome = System.getenv("PATH");
        System.out.println("PATH: " + javaHome);
    }

    private static void changePassword() {
        System.out.print("Enter new password: ");
        String newPass = new String(System.console().readPassword());
        if (!newPass.trim().isEmpty()) {
            PropertyHandler.setProperty(PROP_PASSWORD, newPass);
            try {
                PropertyHandler.persist();
                System.out.println("Password changed");
            } catch (Exception e) {
                System.err.println("Password could not be set");
                System.err.printf("%s: %s%n", e.getClass().getName(), e.getMessage());
            }
        } else {
            System.err.println("Password could not be set");
        }
    }

    private static void printDivideDouble() {
        double denominador = 0.0;
        double numerador = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                numerador = Double.parseDouble(System.console().readLine("Ingrese el numerador: "));
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error al ingresar el numerador con codigo de error: " + e);
            }
        }

        valido = false;
        while (!valido) {
            try {
                denominador = Double.parseDouble(System.console().readLine("Ingrese el denominador: "));
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error al ingresar el denominador con codigo de error: " + e);
            }
        }
        System.out.printf("%.3f / %.3f = %.3f\n", numerador, denominador , ((double)numerador / denominador));
    }

    private static void printDivideInteger() {
        int denominador = 0;
        int numerador = 0;
        boolean valido = false;

        while (!valido) {
            try {
                numerador = Integer.parseInt(System.console().readLine("Ingrese el numerador: "));
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error al ingresar el numerador con codigo de error: " + e);
            }
        }
        valido = false;
        while (!valido) {
            try {
                denominador = Integer.parseInt(System.console().readLine("Ingrese el denominador: "));
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error al ingresar el denominador con codigo de error: " + e);
            }
        }
        System.out.printf("%d / %d = %d\n" , numerador, denominador , ((int)numerador / denominador));
    }
}
