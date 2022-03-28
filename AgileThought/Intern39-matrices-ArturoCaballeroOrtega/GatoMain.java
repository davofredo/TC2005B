import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class GatoMain {

    /**
     * ✔ Validar si la coordenada ingresada, esté vacía, si ya se encuentra ocupada, pedirle al mismo jugador otra coordenada
     * Validar si el juego termina por que todas las casillas se encuentran ocupadas
     * Validar si el juego termina por que hay un ganador
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean juegoTerminado = false;
        String[][] tablero = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
        int ronda = 1;
        JugadoresEnum jugadorActual = obtenerJugadorActual(ronda);

        do {
            System.out.println("Ingresa las coordenadas en formato x,y");
            String dato = sc.nextLine();
            Integer[] coordenadas = obtenerCoordenadas(dato);
            if (!revisarCasilla(tablero, dato)) {
                System.out.println("Lugar ocupado");
            } else {
                insertarFicha(tablero, coordenadas[0], coordenadas[1], jugadorActual);
                if (ronda > 3) {
                    if(juegoGanador(tablero)) {
                        System.out.println("Ganador: " + jugadorActual);
                        juegoTerminado = true;
                    }
                }
                imprimirTablero(tablero);
                jugadorActual = obtenerJugadorActual(++ronda);
            }
            if(ronda == 9) {
                juegoTerminado = true;
            }
        } while (!juegoTerminado);
    }

    public static void imprimirTablero(String[][] tablero) {
        System.out.println("------------------------------");
        for(String[] x : tablero) {
            for(String y : x) {
                System.out.print(y + "\t");
            }
            System.out.println();
        }
    }

    public static void insertarFicha(String[][] tablero, int x, int y, JugadoresEnum jugadorActual) {
        tablero[x][y] = jugadorActual.getFicha();
    }

    public static Integer[] obtenerCoordenadas(String dato) {
        return Stream.of(dato.split(",")).map(d -> Integer.parseInt(d)).toArray(Integer[]::new);
    }

    public static JugadoresEnum obtenerJugadorActual(int ronda) {
        return ronda % 2 == 0 ? JugadoresEnum.JUGADOR_B : JugadoresEnum.JUGADOR_A;
    }

    public static boolean revisarCasilla(String[][] tablero, String dato) {
        Integer[] coordenadas = obtenerCoordenadas(dato);
        String valorCasilla = tablero[coordenadas[0]][coordenadas[1]];
        if (valorCasilla.equals("-"))
            return true;
        else
            return false;
    }

    public static boolean revisarCasilla(String[][] tablero, int x, int y) {
        if (tablero[x][y].equals("-"))
            return true;
        else
            return false;
    }

    public static boolean juegoGanador(String[][] tablero) {
        /*
        x x x       - - -       - - -       x - -       - x -       - - x       x - -       - - x
        - - -       x x x       - - -       x - -       - x -       - - x       - x -       - x - 
        - - -       - - -       x x x       x - -       - x -       - - x       - - x       x - -
        */
        int iguales = 0;
        for (int i = 0; i < 3; i++){
            iguales = 0;
            for (int j = 0; j < 2; j++) {
                if (tablero[i][j].equals("-") && tablero[i][j+1].equals("-")) break;
                if (tablero[i][j].equals(tablero[i][j+1])){
                    iguales++;
                }
                if (iguales == 2) {
                    return true;
                }
            }
        }
        //return false;

        iguales = 0;
        for (int i = 0; i < 3; i++){
            iguales = 0;
            for (int j = 0; j < 2; j++) {
                if (tablero[j][i].equals("-") && tablero[j+1][i].equals("-")) break;
                if (tablero[j][i].equals(tablero[j+1][i])){
                    iguales++;
                }
                if (iguales == 2) {
                    return true;
                }
            }
        }

        iguales = 0;
        for (int i = 0; i < 2; i++){
            iguales = 0;
            for (int j = 0; j < 2; j++) {
                if (tablero[i][j].equals("-") && tablero[i+1][j+1].equals("-")) break;
                if (tablero[i][j].equals(tablero[i+1][j+1])){
                    iguales++;
                }
                if (iguales == 2) {
                    return true;
                }
                i++;
            }
            i--;
        }

        iguales = 0;
        for (int i = 0; i < 2; i++){
            iguales = 0;
            for (int j = 2; j > 0; j--) {
                if (tablero[i][j].equals("-") && tablero[i+1][j-1].equals("-")) break;
                if (tablero[i][j].equals(tablero[i+1][j-1])){
                    iguales++;
                }
                if (iguales == 2) {
                    return true;
                }
                i++;
            }
            i--;
        }
        return false;
    }
}