package buscminas;

/**
 *
 * @author a18jaimejnq
 */
public class Xogo {

    private int filas;
    private int columnas;
    private Celda[][] mineSweeper;

    public Xogo(int filas, int columnas) {
        int contador = 0;
        int estado = 1;
        this.filas = filas;
        this.columnas = columnas;
        mineSweeper = new Celda[filas][columnas];
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {

                mineSweeper[i][j] = new Celda(false, estado, i, j);
            }
        }

    }

    /*public Celda[][] getCelda(int fila, int columna) {
       return mineSweeper[fila][columna];
  }
     */
    public void muestra() {
        for (Celda[] fila : mineSweeper) {
            System.out.println("");
            for (Celda columna : fila) {
              
                System.out.print(columna);
            }

        }
    }

    public Celda getCelda(int fila, int columna) {
        return mineSweeper[fila][columna];
    }

    public void abrirCela(int fila, int columna) {
        mineSweeper[fila][columna].setEstado(3);
    }

    public void abrirTodasCelas() {
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                mineSweeper[i][j].setEstado(2);
            }
        }
    }

    public void comprobarMinas() {
        for (Celda[] celdas : mineSweeper) {
            for (Celda celda : celdas) {

                System.out.println(celda.getEstado());
            }
        }
    }

    /*public void panelMinas() {
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                if (mineSweeper[i][j].getEstado() == 1) {
                    System.out.println("[-]");
                }
            }
        }

    }*/
}
