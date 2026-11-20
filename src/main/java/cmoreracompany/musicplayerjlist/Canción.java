/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmoreracompany.musicplayerjlist;

/**
 *
 * @author Clarissa
 */
public class Canción {
    String nombre;
    String autor;
    Canción sig, ant;
    
    public Canción (String nombre, String autor){
        this.nombre = nombre;
        this.autor = autor;
        this.sig = this.ant = null;
    }
}