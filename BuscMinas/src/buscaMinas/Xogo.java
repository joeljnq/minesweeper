package buscaMinas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author a18jaimejnq
 */
public class Xogo {

    private Scanner teclado = new Scanner(System.in, "ISO-8859-1");
    private int filas;
    private int columnas;
    private Celda[][] mineSweeper;
    private int minas;
    Random random = new Random();

    public Xogo(int filas, int columnas, int minas) {

        int estado = 1;
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;

        mineSweeper = new Celda[filas][columnas];
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {

                mineSweeper[i][j] = new Celda(false, estado, i, j);
            }
        }

        encherMinas(minas);
    }

    public void muestra() {
        Character[][] muestra = new Character[filas][columnas];

        for (int i = 0; i < muestra.length; i++) {
            System.out.print(i + "\t");

            for (int j = 0; j < muestra[i].length; j++) {

                if (mineSweeper[i][j].getEstado() == 1) {
                    System.out.print("X\t");
                } else if (mineSweeper[i][j].getEstado() == 2) {
                    System.out.print("T\t");
                } else if (mineSweeper[i][j].getEstado() == 3) {
                    if (mineSweeper[i][j].isMinada()) {
                        System.out.print("*\t");
                    } else {
                        System.out.print(getMinasAdxacentes(mineSweeper[i][j])
                                + "\t");

                    }

                }

            }
            System.out.println("");

        }
        System.out.println("");
        for (int i = 0; i < muestra.length; i++) {
            System.out.print("\t");
            System.out.print(i);

        }

    }

    public Celda getCelda(int fila, int columna) {
        return mineSweeper[fila][columna];
    }

    public void abrirCela(Celda cela) {

        if (cela.getEstado() != 3) {
            cela.setEstado(3);

            if (getMinasAdxacentes(cela) == 0) {

                //esto es para abrir cela pero estoy haciendo pruebas de recursividad
                for (int i = 0; i < getCelasAdxacentes(cela).size(); i++) {
                    abrirCela(getCelasAdxacentes(cela).get(i));

                }
            }

        }

    }

    public void abrirTodasMinas() {
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                if (mineSweeper[i][j].isMinada()) {
                    mineSweeper[i][j].setEstado(3);
                }
            }
        }
    }

    public boolean comprobarCelasAbrir() { // da false si hay celas sin abrir y true cuando todo esta abierto...
        boolean toret = true;
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                if (mineSweeper[i][j].isMinada() == false) {
                    if (mineSweeper[i][j].getEstado() != 3) {
                        toret = false;
                    }
                }

            }
        }
        return toret;
    }

    private void encherMinas(int minas) {

        for (int i = 0; i < minas; i++) {
            mineSweeper[random.nextInt(filas)][random.nextInt(columnas)].setMinada(true);
        }
    }

    public void marcarCelda(Celda celda) {
        celda.setEstado(2);
    }

    private ArrayList<Celda> getCelasAdxacentes(Celda cela) {
        ArrayList<Celda> toret = new ArrayList<>();
        int filaInicial = cela.getFilas();
        int columnaInicial = cela.getColumnas();

        for (int f = filaInicial - 1; f <= filaInicial + 1; f++) {
            for (int c = columnaInicial - 1; c <= columnaInicial + 1; c++) {
                if ((f != filaInicial || c != columnaInicial)
                        && f >= 0 && c >= 0
                        && f < filas && c < columnas) {
                    toret.add(mineSweeper[f][c]);
                }
            }

        }
        return toret;
    }

    public int getMinasAdxacentes(Celda celda) {
        int toret = 0;
        for (int i = 0; i < getCelasAdxacentes(celda).size(); i++) {
            if (getCelasAdxacentes(celda).get(i).isMinada()) {
                toret++;
            }
        }

        return toret;
    }

    public void menuInterno() {
        System.out.println("\n 1.abrir Celda");
        System.out.println("2. Abrir todas las celdas que tienen minas");
        System.out.println("3. Comprueba si hay celdas por abrir");
        System.out.println("4. Marcar celda");
        System.out.println("5. Salir de la partida");
    }

}
