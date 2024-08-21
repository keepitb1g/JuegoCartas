import java.util.Random;
import java.util.Scanner;

public class JuegoCartas {
    public static void main(String[] args) {
        System.out.println("Juego de cartas");
        menu();
    }

    public static String[][] crearMatrizCartas() {
        return new String[12][2];
    }

    public static void agregarCartas(String[][] matrizCartas, String nombreCarta, String puntaje) {
        for (int i = 0; i < matrizCartas.length; i++) {
            if (matrizCartas[i][0] == null) {
                matrizCartas[i][0] = nombreCarta;
                matrizCartas[i][1] = puntaje;
                break;
            }
        }
    }

    public static void inicializarCartasJuego(String matrizCartas[][]) {
        agregarCartas(matrizCartas, "Ás", "11");
        agregarCartas(matrizCartas, "Dos", "2");
        agregarCartas(matrizCartas, "Trés", "3");
        agregarCartas(matrizCartas, "Cuatro", "4");
        agregarCartas(matrizCartas, "Cinco", "5");
        agregarCartas(matrizCartas, "Seis", "6");
        agregarCartas(matrizCartas, "Siete", "7");
        agregarCartas(matrizCartas, "Ocho", "8");
        agregarCartas(matrizCartas, "Nueve", "9");
        agregarCartas(matrizCartas, "Jota", "10");
        agregarCartas(matrizCartas, "Queen", "10");
        agregarCartas(matrizCartas, "King", "10");
    }

    public static String[][] obtenerCartas(String[][] matrizCartas) {
        String[][] matrizJugador = new String[3][2];
        Random numero = new Random();
        for (int i = 0; i < matrizJugador.length; i++) {
            if (matrizJugador[i][0] == null) {
                int carta = numero.nextInt(matrizCartas.length); // Asegúrate de que el índice esté dentro del rango
                matrizJugador[i][0] = matrizCartas[carta][0];
                matrizJugador[i][1] = matrizCartas[carta][1];
            }
        }
        return matrizJugador;
    }

    public static void menu() {
        Scanner lector = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("Selecciona una opción para empezar a jugar:");
            System.out.println("1. Elegir cartas");
            System.out.println("2. Jugar las cartas");
            System.out.println("3. Salir");

            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has elegido la opción 1: Elegir cartas");
                        String matrizCartas[][] = crearMatrizCartas();
                        inicializarCartasJuego(matrizCartas);
                        String[][] cartasJugadorUno = obtenerCartas(matrizCartas);
                        String[][] cartasJugadorDos = obtenerCartas(matrizCartas);
                        for (int i = 0; i < matrizCartas.length; i++) {
                            System.out.println(matrizCartas[i][0] + " - " + matrizCartas[i][1]);}
                        break;
                    case 2:
                        System.out.println("Has elegido la opción 2: Jugar las cartas");
                        break;
                    case 3:
                        System.out.println("Has salido del juego.");
                        break;
                    default:
                        System.out.println("Opción no válida, escoge una correcta.");
                        break;
                }
            }
            else {
                System.out.println("la opción escogida es inválida, escoge una correcta.");
            }
        }
        lector.close();
    }
}
