public class EtiquetasSentenciasForWhile {
    public static void main(String[] args) {
        /*
         * int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25,
         * 30, 35, 49, 50 };
         * int[] otrosNumeros = { 9, 78, 7, 6, 5, 4, 3, 2, 21, 1 };
         * int cantidadPares = 0;
         * 
         * primeroFor:
         * for (int numero : numeros) {
         * for (int otroNumero : otrosNumeros) {
         * if (numero % 2 != 0) {
         * continue primeroFor;
         * }
         * }
         * 
         * cantidadPares++;
         * }
         * 
         * System.out.println("CantidadPares = " + cantidadPares);
         */

        String frase = "Un gran poder conlleva a una gran responsabilidad";
        String palabra = "gran";
        int tamanioFrase = frase.length();
        int tamanioPalabra = palabra.length();
        int encontrado = 0;

        primeroFor:
        for (int i = 0; i < tamanioFrase; i++) {
            int k = i;
            for (int j = 0; j < tamanioPalabra; j++) {
                if (frase.charAt(k) != palabra.charAt(j))
                    continue primeroFor;
                else
                    encontrado += 1;
            }
        }
        System.out.println("La palabra " + palabra + " fue encontrada " + encontrado + " veces");
    }
}
