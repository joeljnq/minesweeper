package buscaMinas;

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

    public void setMinada(boolean minada) {
        this.minada = minada;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isMinada() {
        return minada;
    }

    public int getEstado() {
        return estado;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }


    
    
    

    @Override
    public String toString() {
        return "Celda Minada: " + minada + " estado: " + estado + " fila: " + filas + " columna: " + columnas;
    }
}
