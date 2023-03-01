package minessweeper;

/**
 *
 * @author a18jaimejnq
 */
public class Xogo {

    private int filas;
    private int columnas;
    Celda[][] mineSweeper;

    public Xogo(int filas, int columnas) {
        int contador = 0;
        int estado = 1;
        this.filas = filas;
        this.columnas = columnas;
        mineSweeper = new Celda[filas][columnas];
        for (int i = 0; i <filas; i++) {
            contador++;
            for (int j = 0; j < columnas; j++) {

                mineSweeper[i][j] = new Celda(false, estado, i, j);
            }
        }
        
      

    }

    /*public Celda[][] getCelda(int fila, int columna) {
       return mineSweeper[fila][columna];
  }
     */
      public void muestra(){
            for (Celda[] fila : mineSweeper) {
                for (Celda columna : fila) {
                    System.out.println(columna); 
                }
               
          }
        }
      
      public Celda getCelda(int fila, int columna){
          return mineSweeper[fila][columna];
      }
}
