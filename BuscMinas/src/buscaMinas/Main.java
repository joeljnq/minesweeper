package buscaMinas;

import java.util.Scanner;

/**
 *
 * @author a18jaimejnq
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");
        int columnas, filas, minas;
        boolean finJuego = false;

        System.out.println("");
        int eleccionMenuPrincipal = 0, eleccionMenuInterno = 0;
        do {
            System.out.println("1. Empezar partida");
            System.out.println("2. Salir");
            eleccionMenuPrincipal = teclado.nextInt();
            teclado.nextLine();
            if (eleccionMenuPrincipal == 1) {

                System.out.println("Primero elige las filas, luego las columnas y por ultimo las minas que quieres que tenga el juego");
                Xogo a = new Xogo(filas = teclado.nextInt(), columnas = teclado.nextInt(), minas = teclado.nextInt());
                do {

                    a.muestra();
                    a.menuInterno();
                    eleccionMenuInterno = teclado.nextInt();

                    if (eleccionMenuInterno == 1 && finJuego == false) {
                        System.out.println("primero pon la fila de la celda que quieres abrir");
                        System.out.println("Luego pon la columna");
                        a.abrirCela(a.getCelda(filas = teclado.nextInt(), columnas = teclado.nextInt()));
                        if (a.getCelda(filas, columnas).isMinada()) {

                            System.out.println("PERDISTE, TOCASTE MINA");
                            finJuego = true;
                        }
                        System.out.println("\n");

                    } else if (eleccionMenuInterno == 2 && finJuego == false) {
                        a.abrirTodasMinas();

                    } else if (eleccionMenuInterno == 3 && finJuego == false) {
                        System.out.println(a.comprobarCelasAbrir());
                        System.out.println("False = aun queda Celdas por abrir");
                        System.out.println("True = todas las celdas estan abiertas.");

                    } else if (eleccionMenuInterno == 4 && finJuego == false) {
                        System.out.println("Primero pon la fila de la celda que quieres marcar");
                        System.out.println("Luego la colummna");
                        a.marcarCelda(a.getCelda(filas = teclado.nextInt(), columnas = teclado.nextInt()));

                    }
                    if (a.comprobarCelasAbrir()) {
                        System.out.println("Ganaste la partida");
                        finJuego = true;
                    }

                } while (eleccionMenuInterno != 5 && finJuego == false);

            }
        } while (eleccionMenuPrincipal != 2);

    }
}
