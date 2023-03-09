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
    private int minas ;
    Random random = new Random();

    public Xogo(int filas, int columnas, int minas) {
        int contador = 0;
        int estado = 1;
        this.filas = filas;
        this.columnas = columnas;
        this.minas= minas;
        
        
        mineSweeper = new Celda[filas][columnas];
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {

                mineSweeper[i][j] = new Celda(false, estado, i, j);
            }
        }
        
        encherMinas(minas);
       

    }

    /*public Celda[][] getCelda(int fila, int columna) {
       return mineSweeper[fila][columna];
  }
     */
    public void muestra() {
        for (int i = 0; i < mineSweeper.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mineSweeper[i].length; j++) {
                
                
                 System.out.print(mineSweeper[i][j].getEstado()+"|");
               
            }
           
          
            System.out.println("");
        }
    }

    public Celda getCelda(int fila, int columna) {
        return mineSweeper[fila][columna];
    }

    public void abrirCela(Celda cela) {
        if (cela.getEstado() == 3) {
            System.out.println("Ya está destapada");
        }else{
            cela.setEstado(3);  
        }
      
        
    
         //   System.out.println(getCelasAdxacentes(cela)+ "\n");
        
  
        
    }

    public void abrirTodasCelas() {
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                mineSweeper[i][j].setEstado(3);
            }
        }
    }
/* Este metodo es uno que cree yo para comprobar si todas las celas se abrieron
    public void comprobarMinas() {
        for (Celda[] celdas : mineSweeper) {
            for (Celda celda : celdas) {

                System.out.println(celda);
            }
        }
    }*/
    
    public boolean comprobarCelasAbrir(){ // da false si hay celas sin abrir y true cuando todo esta abierto...
       boolean toret = true;
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                if (mineSweeper[i][j].getEstado() != 3) {
                    toret = false;
                }
            }
        }
        return toret;
    }
    
    
    private void encherMinas(int minas){
        
       
        for (int i = 0; i < minas; i++) {
            mineSweeper[random.nextInt(6)][random.nextInt(6)].setMinada(true);
        }
    }
    
    private ArrayList <Celda> getCelasAdxacentes(Celda cela){
        ArrayList<Celda> toret = new ArrayList<>();
        toret.add(mineSweeper[cela.getFilas()][cela.getColumnas()+1]);
        toret.add(mineSweeper[cela.getFilas()][cela.getColumnas()-1]);
        toret.add(mineSweeper[cela.getFilas()+1][cela.getColumnas()]);
        toret.add(mineSweeper[cela.getFilas()+1][cela.getColumnas()-1]);
        toret.add(mineSweeper[cela.getFilas()+1][cela.getColumnas()+1]);
        toret.add(mineSweeper[cela.getFilas()-1][cela.getColumnas()]);
        toret.add(mineSweeper[cela.getFilas()-1][cela.getColumnas()+1]);
        toret.add(mineSweeper[cela.getFilas()-1][cela.getColumnas()-1]);
        return toret;
    }
    
    public void menuInterno(){
       
        System.out.println("\n 1.abrir Celda");
        System.out.println("2. Abrir todas las celdas");
        System.out.println("3. Comprueba si hay celdas por abrir");
        System.out.println("4. meter minas");
    }

 

}
