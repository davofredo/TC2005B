import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        Persona p1 = new Persona("Adrian", "Gonzales", LocalDate.of(1990, 7, 10));
        Persona p2 = new Persona("Juan", "Perez", LocalDate.of(1987, 6, 25));
        Persona p3 = new Persona("Pepe", "Gomez", LocalDate.of(2000, 9, 10));
        Persona p4 = new Persona("John", "Connor", LocalDate.of(1984, 2, 15));

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        // Imprimir los nombre usando el operador forEach de la interfaz Stream
        personas.stream().forEach(persona -> {
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido " + persona.getApellido());
        });

        // Calcular la edad con base en la fecha de nacimiento: utilizando el agregador
        // map
        personas = personas.stream().map(p -> {
            int edad = Period.between(p.getFechaNacimiento(), LocalDate.now()).getYears();
            p.setEdad(edad);
            return p;
        }).collect(Collectors.toList());

        // List<String> nombres = personas.stream().map(p ->
        // p.getNombre()).collect(Collectors.toList());

        // personas.stream().forEach(p -> System.out.println("Edad: " + p.getEdad()));

        // Filtrar la lista de personas por aquellas que nacieron en año bisisesto

        personas = personas.stream().filter(p -> ((p.getFechaNacimiento().getYear() % 4 == 0)
                && ((p.getFechaNacimiento().getYear() % 100 != 0) || (p.getFechaNacimiento().getYear() % 400 == 0))))
                .collect(Collectors.toList());

        personas.stream().forEach(p -> System.out.println("persona con año de nacimiento bisiesto = " + p.getNombre()));
    }
}
