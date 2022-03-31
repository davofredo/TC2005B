import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import com.arturo.reflection.classes.abstracts.Empleado;
import com.arturo.reflection.classes.constants.PuestosEnum;

public class MetodosMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class claseEmpleado = Class.forName("com.arturo.reflection.classes.abstracts.Empleado");
        Method[] metodos = claseEmpleado.getDeclaredMethods();
        Empleado empleado = new Empleado();

        for (Method metodo : metodos) {
            System.out.println("Nombre: " + metodo.getName());
            System.out.println("Retorno: " + metodo.getReturnType());
            System.out.println("Parametros: " + Arrays.toString(metodo.getParameterTypes()));
            System.out.println("Modificador de acceso: " + Modifier.toString(metodo.getModifiers()));
            
            if ( metodo.getName().equals("calcularSueldo")) {
                Object sueldo = metodo.invoke(empleado, LocalDate.now(), PuestosEnum.TECH_LEADER);
                System.out.println("Nuevo sueldo: " + sueldo);
            }

            System.out.println("----------------------------------");
        }
    }
}
