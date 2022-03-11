import java.time.*;
import java.time.format.DateTimeFormatter;

public class CalcularEdad {
    public static void main(String[] args) {
        try {
            String MifechaNacimiento = System.console()
                    .readLine("Captura tu fecha de nacimineto en formato dd/MM/AAAA > ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(MifechaNacimiento, formatter);
            Period edad = Period.between(fechaNacimiento, LocalDate.now());
            System.out.println(
                    String.format("%d años, %d meses y %d días", edad.getYears(), edad.getMonths(), edad.getDays()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
