package minessweeper;

/**
 *
 * @author a18jaimejnq
 */
public class Xogo {
 
   
    private int filas;
    private int columnas;
Celda[][] mineSweeper = new Celda[filas][columnas];
    public Xogo(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        
        
    }
    
    

    public Celda[][] getCelda(int fila, int columna) {
        return mineSweeper[fila][columna];
    }
    
    
   
    

}
