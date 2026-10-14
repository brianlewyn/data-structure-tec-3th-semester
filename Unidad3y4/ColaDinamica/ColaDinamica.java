package Unidad3y4.ColaDinamica;

import Unidad3y4.PilaDinamica.Nodo;

/**
 * Implementación de una cola dinámica (enlazada) usando nodos.
 * 
 * A diferencia de las colas estáticas, aquí NO existe un arreglo de tamaño fijo.
 * Cada elemento se guarda en un Nodo que apunta al siguiente, por lo que la cola
 * puede crecer tanto como lo permita la memoria disponible.
 * 
 * Se mantienen dos referencias:
 *   - "frente": apunta al primer nodo (el que se atenderá primero).
 *   - "fin":    apunta al último nodo (donde se insertan los nuevos).
 * 
 * Esto permite que encolar y desencolar sean operaciones O(1), ya que no hay
 * que recorrer la estructura.
 */
public class ColaDinamica {

    private Nodo frente;   // Primer nodo de la cola (se atiende primero)
    private Nodo fin;      // Último nodo de la cola (se inserta al final)

    /**
     * Constructor: crea una cola vacía.
     * Ambos punteros se inicializan en null, indicando que no hay nodos.
     */
    public ColaDinamica() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * Basta con revisar si "frente" es null. Si no hay primer nodo,
     * tampoco puede haber último.
     * 
     * @return true si la cola no tiene elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Inserta un nuevo elemento al final de la cola (encolar / enqueue).
     * 
     * Se crea un nodo nuevo. Si la cola está vacía, frente y fin apuntan
     * al mismo nodo. Si ya hay elementos, el nodo actual de "fin" enlaza
     * al nuevo y luego "fin" se mueve a ese nuevo nodo.
     * 
     * @param x Valor entero a insertar.
     */
    public void encolar(int x) {
        Nodo nuevo = new Nodo(x);

        if (estaVacia()) {
            // Primer elemento: frente y fin apuntan al mismo nodo
            frente = nuevo;
            fin = nuevo;
        } else {
            // Se enlaza el nuevo nodo al final y se actualiza "fin"
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    /**
     * Elimina y devuelve el primer elemento de la cola (desencolar / dequeue).
     * 
     * Se toma el dato del nodo apuntado por "frente" y luego "frente"
     * avanza al siguiente nodo. Si al avanzar "frente" queda en null,
     * significa que la cola quedó vacía, por lo que "fin" también se
     * pone en null para mantener la coherencia.
     * 
     * @return El valor atendido, o -1 si la cola estaba vacía.
     */
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia!");
            return -1;
        }

        int valor = frente.dato;         // Se guarda el dato antes de perder la referencia
        frente = frente.siguiente;       // "frente" avanza al siguiente nodo

        // Si la cola quedó vacía, "fin" también debe ser null
        if (frente == null) {
            fin = null;
        }

        return valor;
    }

    /**
     * Devuelve el valor del primer elemento SIN eliminarlo.
     * 
     * @return El dato en el frente, o -1 si la cola está vacía.
     */
    public int peek() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia!");
            return -1;
        }
        return frente.dato;
    }

    /**
     * Cuenta cuántos elementos hay actualmente en la cola.
     * 
     * Como es una estructura enlazada, es necesario recorrerla desde
     * "frente" hasta el final (null), incrementando un contador.
     * 
     * @return Número de nodos en la cola.
     */
    public int contarElementos() {
        int total = 0;

        // Recorrido típico de una lista enlazada
        for (Nodo actual = frente; actual != null; actual = actual.siguiente) {
            total++;
        }

        return total;
    }

    /**
     * Muestra los elementos de la cola en orden FIFO (del frente al fin).
     * 
     * Se recorre la estructura desde "frente" siguiendo los enlaces
     * "siguiente" hasta llegar a null.
     */
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia!");
            return;
        }

        System.out.print("Frente -> ");

        for (Nodo actual = frente; actual != null; actual = actual.siguiente) {
            System.out.print("[" + actual.dato + "] ");
        }

        System.out.println(" <- Fin");
    }
}