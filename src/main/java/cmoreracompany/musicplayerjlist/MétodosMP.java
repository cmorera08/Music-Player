/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmoreracompany.musicplayerjlist;

/**
 *
 * @author Clarissa
 */
public class MétodosMP {
    public Canción inicio, fin;
    
    
    
    public String insertarInicio(String nombre, String autor){
        Canción nueva = new Canción(nombre, autor);
        if (inicio == null){
            inicio = fin = nueva;
            inicio.sig = inicio;
            inicio.ant = inicio;
            return "Canción agregada";
        }
        if (buscarCanción(nombre) != null)
            return "Esta canción ya está en su playlist.";
        
        nueva.sig = inicio;
        inicio.ant = nueva;
        fin.sig = nueva;
        nueva.ant = fin;
        inicio = nueva;
        return "Canción agregada";
    }
    public String insertarFinal(String nombre, String autor){
        Canción nueva = new Canción(nombre, autor);
        if (inicio == null){
            fin = inicio = nueva;
            fin.sig = inicio;
            fin.ant = inicio;
            return "Canción agregada";
        }
        if (buscarCanción(nombre) != null)
            return "Esta canción ya está en su playlist.";
        
        nueva.sig = inicio;
        inicio.ant = nueva;
        fin.sig = nueva;
        nueva.ant = fin;
        fin = nueva;
        return "Canción agregada";
    }
    
    
    
    public Canción buscarCanción(String nombre){
        if (inicio == null){
            return null;
        }
        Canción aux = inicio;
        while (aux != fin){
            if (aux.nombre.equals(nombre)){
                return aux;
            }
            aux = aux.sig;
        }
        if (aux.nombre.equals(nombre)){
            return aux;
        }
        return null;
    }
        public Canción buscarAutor(String autor){
        if (inicio == null){
            return null;
        }
        Canción aux = inicio;
        while (aux != fin){
            if (aux.autor.equals(autor)){
                return aux;
            }
            aux = aux.sig;
        }
        if (aux.autor.equals(autor)){
            return aux;
        }
        return null;
    }
        
        
        
    public String modificarNombre(String nuevoNombre, String autor){
        Canción aux = buscarCanción(autor);
        if (aux == null)
            return "Esa canción no ha sido agregada.";
        aux.nombre = nuevoNombre;
        return "El nombre de la canción ha sido modificado";
    }
    public String modificarAutor(String nombre, String nuevoAutor){
        Canción aux = buscarAutor(nombre);
        if (aux == null)
            return "Esa canción no ha sido agregada.";
        aux.autor = nuevoAutor;
        return "El nombre del autor/a ha sido modificado";
    }
    
    
    
    public String eliminarCanción(String nombre){
        Canción aux = buscarCanción(nombre);
        if (aux == null)
            return "Esa canción no existe en su playlist.";
        if (inicio == aux){
            inicio = inicio.sig;
            inicio.ant = null;
            return "La canción ha sido eliminada";
        }
        if (fin == aux){
            fin = fin.ant;
            fin.sig = null;
            return "La canción ha sido eliminada";
        }
        aux.ant.sig = aux.sig;
        aux.sig.ant = aux.ant;
        return "La canción ha sido eliminada";
    }
}