import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.arturo.reflection.classes.abstracts.Empleado;
import com.arturo.reflection.classes.constants.PuestosEnum;

public class CamposMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        
        Class clasePersona = Class.forName("com.arturo.reflection.classes.abstracts.Persona");
        Class claseEmpleado = Class.forName("com.arturo.reflection.classes.abstracts.Empleado");
        Empleado empleado = new Empleado();

        Field[] campos = claseEmpleado.getDeclaredFields();
        
        for (Field campo : campos) {
            campo.setAccessible(true);
            System.out.println("Nombre: "+ campo.getName());
            System.out.println("Tipo de dato: "+ campo.getType());
            System.out.println("Modificador de Acceso: "+ Modifier.toString(campo.getModifiers()));
            System.out.println("Valor: "+ campo.get(empleado));
            System.out.println("-------------------------------");
        }

        campos[0].set(empleado, PuestosEnum.QA);
        System.out.println(campos[0].get(empleado));
    }
}
