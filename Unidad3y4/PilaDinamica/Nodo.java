package Unidad3y4.PilaDinamica;

/**
 * Representa un nodo individual de la pila dinámica.
 * Cada nodo almacena un dato entero y una referencia ("flecha")
 * al nodo que está debajo de él en la pila.
 *
 * Estructura visual:
 *
 *     [dato | siguiente] ---> [dato | siguiente] ---> null
 *
 */
public class Nodo {

    /** Valor entero que guarda este nodo. */
    public int dato;

    /**
     * Referencia al siguiente nodo (el que está debajo en la pila).
     * Si vale null, significa que este es el último nodo (el fondo).
     * Debe ser del mismo tipo Nodo porque un nodo solo puede apuntar a otro nodo.
     */
    public Nodo siguiente;

    /**
     * Constructor del nodo.
     * Se inicializa con un valor y con la referencia en null,
     * para evitar dejar datos "basura" en memoria.
     *
     * @param x el valor entero que guardará este nodo
     */
    public Nodo(int x) {
        this.dato = x;          // Nace con un valor concreto
        this.siguiente = null;  // Al nacer todavía no apunta a ningún nodo
    }
}