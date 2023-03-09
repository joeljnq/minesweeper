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
      int columnas,filas,minas;
     
        System.out.println("");
    //    System.out.println(a.getCelda(5, 4));
        
       // a.abrirTodasCelas();
     //   System.out.println(a.comprobarCelasAbrir());
        
       
        int eleccionMenuPrincipal = 0;
        do {
            System.out.println("1. Empezar partida");
            System.out.println("2. Salir");
            eleccionMenuPrincipal = teclado.nextInt();
            if (eleccionMenuPrincipal == 1) {
                System.out.println("Primero elige las filas, luego las columnas y por ultimo las minas que quieres que tenga el juego");
                  Xogo a = new Xogo(filas = teclado.nextInt(), columnas = teclado.nextInt(), minas=teclado.nextInt());
                  a.muestra();
            }
        } while (eleccionMenuPrincipal != 2);

    }
}
