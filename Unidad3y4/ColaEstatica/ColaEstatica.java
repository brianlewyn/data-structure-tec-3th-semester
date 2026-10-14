package Unidad3y4.ColaEstatica;

/**
 * Implementación de una cola estática usando un arreglo.
 * 
 * Una cola es una estructura FIFO (First In, First Out): el primer elemento
 * en entrar es el primero en salir.
 * 
 * Esta versión NO es circular, por lo que una vez que el índice "fin" llega
 * al final del arreglo, ya no se pueden insertar más elementos aunque haya
 * espacio libre al inicio (debido a los elementos ya eliminados).
 */
public class ColaEstatica {

    private int[] arreglo;   // Arreglo que almacena los elementos de la cola
    private int frente;      // Índice del primer elemento de la cola
    private int fin;         // Índice del último elemento de la cola
    private int capacidad;   // Tamaño máximo de la cola

    /**
     * Constructor: inicializa la cola con un tamaño específico.
     * 
     * @param tamaño Capacidad máxima de la cola.
     */
    public ColaEstatica(int tamaño) {
        this.capacidad = tamaño;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;     // La cola comienza vacía: frente apunta a 0
        this.fin = -1;       // fin = -1 indica que no hay elementos
    }

    /**
     * Inserta un elemento al final de la cola (enqueue).
     * 
     * Si el índice "fin" ya alcanzó la última posición del arreglo,
     * se considera que la cola está llena, aunque "frente" haya avanzado
     * y existan posiciones libres al inicio.
     * 
     * @param valor Número entero a insertar.
     */
    public void enqueue(int valor) {
        if (fin == capacidad - 1) {
            // Error típico de cola estática no circular:
            // No se reutiliza el espacio liberado por dequeue().
            System.out.println("Error: La cola esta llena.");
        } else {
            fin++;                    // Avanza el índice de fin
            arreglo[fin] = valor;     // Guarda el valor
            System.out.println("Entro a la fila: " + valor);
        }
    }

    /**
     * Elimina el primer elemento de la cola (dequeue).
     * 
     * Si "frente" supera a "fin", significa que no hay elementos.
     */
    public void dequeue() {
        if (frente > fin) {
            System.out.println("Cola esta vacia!");
        } else {
            System.out.println("Atendido y fuera: " + arreglo[frente]);
            frente++;   // Avanza el índice de frente, "eliminando" lógicamente el elemento
        }
    }

    /**
     * Muestra los elementos actuales de la cola desde "frente" hasta "fin".
     * 
     * Si "frente" > "fin", la cola está vacía.
     */
    public void show() {
        if (frente > fin) {
            System.out.println("La cola esta vacia!");
            return;
        }

        System.out.print("Fila actual: ");
        for (int i = frente; i <= fin; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}