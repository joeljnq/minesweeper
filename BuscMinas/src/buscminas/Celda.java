package buscminas;

/**
 *
 * @author a18jaimejnq
 */
public class Celda {

    private boolean minada;
    private int estado;
    private int filas;
    private int columnas;

    public Celda(boolean minada, int estado, int filas, int columnas) {

        this.minada = minada;
        this.estado = estado;
        this.filas = filas;
        this.columnas = columnas;
    }

    @Override
    public String toString() {
        return "Celda Minada: " + minada + " estado: " + estado + " fila :" + filas + "columna : " + columnas;
    }
}