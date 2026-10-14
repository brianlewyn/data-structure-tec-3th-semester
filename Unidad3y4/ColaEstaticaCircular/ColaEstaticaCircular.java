package Unidad3y4.ColaEstaticaCircular;

/**
 * Implementación de una cola estática CIRCULAR usando un arreglo.
 * 
 * La diferencia principal con la cola estática simple es que aquí los índices
 * "frente" y "fin" se desplazan de forma circular mediante el operador módulo (%).
 * Esto permite reutilizar las posiciones liberadas por dequeue(), evitando el
 * problema de "falsa cola llena" cuando hay espacio libre al inicio del arreglo.
 * 
 * Para distinguir entre cola llena y cola vacía (ya que frente y fin pueden
 * coincidir en ambos casos) se utiliza una variable adicional: "tamaño",
 * que lleva la cuenta exacta de elementos almacenados.
 */
public class ColaEstaticaCircular {

    private int[] arreglo;   // Arreglo que almacena los elementos de la cola
    private int capacidad;   // Tamaño máximo de la cola

    private int tamaño;      // Número actual de elementos en la cola
    private int frente;      // Índice del primer elemento de la cola
    private int fin;         // Índice del último elemento insertado

    /**
     * Constructor: inicializa la cola circular con una capacidad dada.
     * 
     * @param capacidad Número máximo de elementos que puede almacenar.
     */
    public ColaEstaticaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;      // El primer elemento se ubicará en el índice 0
        this.fin = -1;        // fin = -1 indica que aún no hay elementos
        this.tamaño = 0;      // Cola vacía al inicio
    }

    /**
     * Inserta un elemento al final de la cola (enqueue).
     * 
     * El índice "fin" avanza de forma circular: si llega al final del arreglo,
     * vuelve a 0. Así se reaprovechan los espacios liberados por dequeue().
     * 
     * @param valor Número entero a insertar.
     */
    public void enqueue(int valor) {
        if (isFull()) {
            System.out.println("Error: La cola esta llena.");
            return;
        }

        // Avance circular del índice fin
        fin = (fin + 1) % capacidad;
        arreglo[fin] = valor;
        tamaño++;

        System.out.println("Entro a la fila: " + valor);
    }

    /**
     * Elimina y devuelve el primer elemento de la cola (dequeue).
     * 
     * El índice "frente" también avanza de forma circular. El elemento
     * eliminado lógicamente sigue en el arreglo, pero será sobrescrito
     * cuando "fin" vuelva a pasar por esa posición.
     * 
     * @return El valor atendido, o -1 si la cola estaba vacía.
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Error: La cola esta vacia!");
            return -1;
        }

        int atendido = arreglo[frente];
        // Avance circular del índice frente
        frente = (frente + 1) % capacidad;
        tamaño--;

        System.out.println("Atendido y fuera: " + atendido);
        return atendido;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si no hay elementos, false en caso contrario.
     */
    public boolean isEmpty() {
        return tamaño == 0;
    }

    /**
     * Verifica si la cola está llena.
     * 
     * @return true si el número de elementos iguala la capacidad.
     */
    public boolean isFull() {
        return tamaño == capacidad;
    }

    /**
     * Devuelve el primer elemento de la cola SIN eliminarlo.
     * 
     * @return El valor en el frente, o -1 si la cola está vacía.
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia!");
            return -1;
        }
        return arreglo[frente];
    }

    /**
     * Muestra los elementos actuales de la cola en orden FIFO.
     * 
     * Se recorre desde "frente" avanzando "tamaño" posiciones de forma
     * circular. Esto es necesario porque los elementos pueden estar
     * "dados vuelta" dentro del arreglo (parte al final y parte al inicio).
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia!");
            return;
        }

        System.out.print("Fila actual: ");

        for (int i = 0; i < tamaño; i++) {
            // Índice circular: avanza desde frente sin salirse del arreglo
            int indice = (frente + i) % capacidad;
            System.out.print(arreglo[indice] + " ");
        }

        System.out.println();
    }
}