public class ArgsExample {
    
    public static void main(String[] args) {
        // Leer cinco números de los argumentos
        /*int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[1]);
        int val3 = Integer.parseInt(args[2]);
        int val4 = Integer.parseInt(args[3]);
        int val5 = Integer.parseInt(args[4]);*/

        //----
        int val11 = Integer.parseInt(args[0]);
        val11 = val11 + Integer.parseInt(args[1]);
        val11 = val11 + Integer.parseInt(args[2]);
        val11 = val11 + Integer.parseInt(args[3]);
        val11 = val11 + Integer.parseInt(args[4]);
        // sumar los 5 números
        //int suma = val1 + val2 + val3 + val4 + val5;
        // imprimir el resultado
        System.out.println(val11);
    }
}
