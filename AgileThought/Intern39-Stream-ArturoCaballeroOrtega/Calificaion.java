import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Calificaion {
    public static void main(String[] args) {
        Alumno a1 = new Alumno("Juan");
        Alumno a2 = new Alumno("Paco");
        Alumno a3 = new Alumno("Pedro");
        Alumno a4 = new Alumno("Raul");
        Alumno a5 = new Alumno("Oscar");
        Alumno a6 = new Alumno("Emilio");
        Alumno a7 = new Alumno("Erik");
        Alumno a8 = new Alumno("Sergio");
        Alumno a9 = new Alumno("Luis");
        Alumno a10 = new Alumno("Adrian");

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a3);
        alumnos.add(a4);
        alumnos.add(a5);
        alumnos.add(a6);
        alumnos.add(a7);
        alumnos.add(a8);
        alumnos.add(a9);
        alumnos.add(a10);

        // Imprimir nombres
        alumnos.stream().forEach(a -> System.out.println("Nombre: " + a.getNombre()));
        System.out.println("\n");
        
        // Asignar calioficaion
        alumnos = alumnos.stream().map(a -> {
            // Obtener numero aleatorio de 0 a 100
            Random r = new Random();int calificacion = r.nextInt(101);
            a.setCalificacion(calificacion);
            if(calificacion >= 80)
                a.setAprobado(true);
            else
                a.setAprobado(false);
            return a;
        }).collect(Collectors.toList());

        // Imprimir campos nombre, calificaion, aprobado
        alumnos.stream().forEach(a -> System.out.println("Nombre: " + a.getNombre() + " Calificacion: " + a.getCalificacion()+ " Aprobado: " + a.isAprobado()));
        // Filtrar si esta aprobado
        alumnos = alumnos.stream().filter(a -> (a.isAprobado())).collect(Collectors.toList());
        System.out.println("\n");
        // Imprimir nombres de alumnos con calificaicion aprobada
        alumnos.stream().forEach(a -> System.out.println("Nombre: " + a.getNombre() + " Calificacion: " + a.getCalificacion()));
    }
}
