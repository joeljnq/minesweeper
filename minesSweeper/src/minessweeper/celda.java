/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minessweeper;

/**
 *
 * @author JOTA JOTA
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
public String toString(){
    return "Celda Minada: "+minada+" estado: "+ estado + " fila : "+ filas + "columna: " +columnas ;
}
    
}
