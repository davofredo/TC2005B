import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println("date1: "+date1);
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println("date2: "+date2);
        // Copiar fechas
        Date date3 = (Date) date1.clone();
        System.out.println("date3: "+date3);
        Date date4 = new Date(date1.getTime());
        System.out.println("date4: "+date4);
        // Modificar fechas
        date4.setTime(date2.getTime());
        System.out.println("date4: "+date4);
        // Comprobar fechas
        System.out.println("date1 es igual a date2? "+date1.equals(date2));
        System.out.println("date1 es igual a date3? "+date1.equals(date3));
        System.out.println("date2 es igual a date2? "+date1.equals(date3));
        System.out.println("Resultado de comparar date1 y date2: " + );
    }
}