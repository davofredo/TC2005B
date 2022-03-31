import com.arturo.reflection.classes.domain.Empleado;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Class claseString = "Hola Mundo".getClass();
        Class superClaseString = claseString.getSuperclass();
        Class claseInteger = Integer.class;
        Class superClaseInteger = claseInteger.getSuperclass();
        Class superClaseNumber = superClaseInteger.getSuperclass();
        Class claseBooleanPrimitivo = boolean.class;
        Class claseIntPrimitivo = int.class;
        Class claseDoublePrimitivo = double.class;
        Class primitivoDouble = Double.TYPE;
        Class primitivoShort = Short.TYPE;
        Class primitivoFloat = Float.TYPE;

        Empleado empleado = new Empleado();
        Class claseEmpleado = empleado.getClass();
        Class clasePersona = Class.forName("com.arturo.reflection.classes.abstracts.Persona");
        Class interfaceIEmpleadoService =  Class.forName("com.arturo.reflection.classes.services.IEmpleadoService");

        System.out.println("--------TIPO REFERENCIA----------");
        System.out.println(claseString);
        System.out.println(superClaseString);
        System.out.println(claseInteger);
        System.out.println(superClaseInteger);
        System.out.println(superClaseNumber);
        System.out.println("----------TIPO PRIMITIVO--------");
        System.out.println(claseBooleanPrimitivo);
        System.out.println(claseIntPrimitivo);
        System.out.println(claseDoublePrimitivo);
        System.out.println(primitivoDouble);
        System.out.println(primitivoShort);
        System.out.println(primitivoFloat);
        System.out.println("---------CLASES---------");
        System.out.println(claseEmpleado);
        System.out.println(clasePersona);
        System.out.println(interfaceIEmpleadoService);
        System.out.println("¿Es interface " + interfaceIEmpleadoService.getSimpleName() + "?: " + interfaceIEmpleadoService.isInterface());
        System.out.println("¿Es interface " + clasePersona.getSimpleName() + "?: " + clasePersona.isInterface());
    }
}