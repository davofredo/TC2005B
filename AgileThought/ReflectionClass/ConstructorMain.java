import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import com.arturo.reflection.classes.abstracts.Empleado;
import com.arturo.reflection.classes.constants.PuestosEnum;

public class ConstructorMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> classEmpleado = Empleado.class;
        Object objClassEmpleado = classEmpleado.newInstance();
        Object objConstrEmpleado = null;

        Constructor[] constructores = classEmpleado.getDeclaredConstructors();
        System.out.println("La clase tiene: " + constructores.length + " constructores");

        for (Constructor constructor : constructores) {
            System.out.println("Constructor: " + Arrays.toString(constructor.getParameterTypes())); // Taissa Farmiga
            System.out.println("Modificador: " + Modifier.toString(constructor.getModifiers()));
            constructor.setAccessible(true);
            if (  constructor.getParameterCount() == 0)
                objConstrEmpleado = constructor.newInstance();
            System.out.println("----------------------------------------------------------------");
        }

        Method[] metodos = classEmpleado.getDeclaredMethods();
        Object[] parametros = {LocalDate.now(), PuestosEnum.QA};
        for (Method method : metodos) {
            if (method.getName().equals("calcularSueldo")) {
                method.invoke(objConstrEmpleado, parametros);
            }
        }
    }
}
