package Unidad3y4.PilaDinamica;

public class Nodo {
    public int dato;
    public Nodo siguiente; // La flechita que apunta al de abajo
    // tiene que ser de la misma clase

    // Constructor del nodo
    public Nodo(int x) {
        this.dato = x; // para que nasca con un valor y no con basura
        this.siguiente = null; // al nacer, a apunta a nadie todavia
    }
}
