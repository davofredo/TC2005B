public class OrdenaNumeros {
    public static void main(String[] args) {
        int[] listaNumeros = new int[6];

        for (int i = 0; i < 6; i++) {
            int valor = Integer.parseInt(System.console().readLine());
            listaNumeros[i] = valor;
        }
        System.out.println("--------");

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (listaNumeros[i] < listaNumeros[j]) {
                    int aux = listaNumeros[i];
                    listaNumeros[i] = listaNumeros[j];
                    listaNumeros[j] = aux;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(listaNumeros[i]);
        }
    }
}