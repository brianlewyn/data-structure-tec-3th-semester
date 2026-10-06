package Unidad3y4.PilaSimple;

/**
 * Implementación de una Pila Estática (basada en arreglo).
 * Una pila sigue el principio LIFO (Last In, First Out):
 * el último elemento en entrar es el primero en salir.
 */
public class PilaSimple {

    /** Arreglo que almacena los elementos de la pila. Capacidad fija = 5. */
    private int[] datos = new int[5];

    /**
     * Índice del último elemento insertado (la cima de la pila).
     * Se inicializa en -1 porque cuando la pila está vacía no hay
     * ninguna posición válida ocupada. El primer push lo lleva a 0.
     */
    private int tope = -1;

    /**
     * Inserta un elemento en la cima de la pila (operación push).
     * Antes de insertar verifica que no se haya alcanzado la capacidad máxima.
     *
     * @param x el valor entero a insertar
     */
    public void push(int x) {
        if (tope < datos.length - 1) {  // ¿Hay espacio disponible?
            tope++;                     // Avanzamos la cima
            datos[tope] = x;            // Guardamos el valor
            System.out.println("Metiste: " + x);
        } else {
            System.out.println("Pila llena! No se pudo insertar: " + x);
        }
    }

    /**
     * Elimina el elemento que está en la cima de la pila (operación pop).
     * Antes de eliminar verifica que la pila no esté vacía.
     */
    public void pop() {
        if (tope >= 0) { // ¿Hay elementos?
            System.out.println("Sacaste: " + datos[tope]);
            tope--;      // Retrocedemos la cima
        } else {
            System.out.println("Pila vacia! No se puede sacar.");
        }
    }

    /**
     * Muestra todos los elementos de la pila desde el fondo hasta la cima.
     * No modifica la pila, solo la recorre para visualizarla.
     */
    public void show() {
        System.out.print("Pila estatica (Fondo -> Cima): ");
        
        if (isEmpty()) {
            System.out.println("[VACIA]");
            return;
        }
        
        for (int i = 0; i <= tope; i++) {
            System.out.print(datos[i] + " ");
        }
        
        System.out.println();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si no hay elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return tope == -1;
    }

    /**
     * Verifica si la pila alcanzó su capacidad máxima.
     *
     * @return true si el arreglo está lleno, false en caso contrario
     */
    public boolean isFull() {
        return tope == datos.length - 1;
    }

    /**
     * Consulta el elemento que está en la cima SIN eliminarlo (operación peek).
     *
     * @return el valor en la cima, o -1 si la pila está vacía
     */
    public int peek() {
        if (!isEmpty()) {
            System.out.println("Consultaste: " + datos[tope]);
            return datos[tope];
        }
        System.out.println("Pila vacia! No hay cima que consultar.");
        return -1;
    }
}