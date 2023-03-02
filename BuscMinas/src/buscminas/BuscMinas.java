package buscminas;

/**
 *
 * @author a18jaimejnq
 */
public class BuscMinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Xogo a = new Xogo(6, 5);
        // a.muestra();

        System.out.println(a.getCelda(5, 3));
    }
}
