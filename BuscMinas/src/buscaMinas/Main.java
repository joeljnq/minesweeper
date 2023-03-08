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
        Xogo a = new Xogo(6, 6, 10);
        a.muestra();
        System.out.println("");
    //    System.out.println(a.getCelda(5, 4));
        a.abrirCela(a.getCelda(2, 2));
       // a.abrirTodasCelas();
     //   System.out.println(a.comprobarCelasAbrir());
        
       
        int eleccionMenuPrincipal = 0;
        do {
            System.out.println("1. Empezar partida");
            System.out.println("2. Salir");
            eleccionMenuPrincipal = teclado.nextInt();
        } while (eleccionMenuPrincipal != 2);

    }
}
