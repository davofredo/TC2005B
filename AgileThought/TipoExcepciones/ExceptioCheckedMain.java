import java.io.IOException;

public class ExceptioCheckedMain {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec("notepad");
        } catch (IOException e) {
            System.err.println("Comando invalido");
        }
    }
}
