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
        //    System.out.println(a.getCelda(5, 4));

        // a.abrirTodasCelas();
        //   System.out.println(a.comprobarCelasAbrir());
        int eleccionMenuPrincipal = 0, eleccionMenuInterno = 0;
        do {
            System.out.println("1. Empezar partida");
            System.out.println("2. Salir");
            eleccionMenuPrincipal = teclado.nextInt();
            teclado.nextLine();
            if (eleccionMenuPrincipal == 1) {

                while (eleccionMenuInterno != 4 && finJuego==false) {

                    System.out.println("Primero elige las filas, luego las columnas y por ultimo las minas que quieres que tenga el juego");
                    Xogo a = new Xogo(filas = teclado.nextInt(), columnas = teclado.nextInt(), minas = teclado.nextInt());
                    a.muestra();
                    a.menuInterno();
                    eleccionMenuInterno = teclado.nextInt();
                    if (eleccionMenuInterno == 1 && finJuego == false) {
                        System.out.println("primero pon la fila de la celda que quieres abrir");
                        System.out.println("Luego pon la columna");
                        a.abrirCela(a.getCelda(filas = teclado.nextInt(), columnas = teclado.nextInt()));
                        a.muestra();
                        System.out.println("\n");
                        finJuego = true;
                        if (!finJuego) {
                            a.menuInterno();
                            eleccionMenuInterno = teclado.nextInt();
                        }

                    } else if (eleccionMenuInterno == 2 && finJuego == false) {
                        a.abrirTodasCelas();
                        a.muestra();

                        if (!finJuego) {
                            a.menuInterno();
                            eleccionMenuInterno = teclado.nextInt();
                        }
                    } else if (eleccionMenuInterno == 3 && finJuego == false) {
                        System.out.println("False = aun queda Celdas por abrir");
                        System.out.println("True = todas las celdas estan abiertas.");
                        System.out.println(a.comprobarCelasAbrir());

                    }
                }

            }
            System.out.println("1. Empezar partida");
            System.out.println("2. Salir");
            eleccionMenuPrincipal = teclado.nextInt();
        } while (eleccionMenuPrincipal != 2);

    }
}
