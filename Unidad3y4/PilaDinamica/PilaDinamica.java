package Unidad3y4.PilaDinamica;

/**
 * Implementación de una Pila Dinámica basada en nodos enlazados.
 * A diferencia de la pila estática, NO tiene un límite fijo:
 * puede crecer mientras haya memoria disponible.
 *
 * Sigue el principio LIFO (Last In, First Out):
 * el último elemento en entrar es el primero en salir.
 */
public class PilaDinamica {

    /**
     * Referencia al nodo que está en la cima de la pila.
     * Es como el "control remoto" que apunta al elemento de hasta arriba.
     * Si vale null, la pila está vacía.
     */
    private Nodo cima;

    /**
     * Constructor de la pila.
     * Inicializa la cima en null porque la pila arranca vacía.
     */
    public PilaDinamica() {
        this.cima = null;
    }

    /**
     * Inserta un nuevo elemento en la cima de la pila (operación push).
     *
     * Pasos:
     *   1. Crear un nuevo nodo con el valor recibido.
     *   2. El nuevo nodo apunta al que era la cima anterior.
     *   3. La cima ahora es el nuevo nodo.
     *
     * @param x el valor entero a insertar
     */
    public void push(int x) {
        // 1. Creamos un nuevo nodo con el valor x
        Nodo nuevo = new Nodo(x);

        // 2. El nuevo nodo "atrapa" al que era la cima anterior
        nuevo.siguiente = cima;

        // 3. El nuevo nodo se convierte oficialmente en la nueva cima
        cima = nuevo;
    }

    /**
     * Elimina el elemento que está en la cima (operación pop).
     * Antes verifica que la pila no esté vacía.
     */
    public void pop() {
        if (cima != null) {
            System.out.println("Sacaste de la pila: " + cima.dato);
            cima = cima.siguiente; // La cima baja al siguiente nodo
        } else {
            System.out.println("Pila dinamica vacia! No se puede sacar.");
        }
    }

    /**
     * Muestra todos los elementos de la pila desde la cima hasta el fondo.
     * No modifica la pila, solo la recorre con un "explorador" temporal.
     */
    public void show() {
        System.out.print("Pila Dinamica (Cima -> Fondo): ");

        if (isEmpty()) {
            System.out.println("[VACIA]");
            return;
        }

        // Recorrido con un nodo auxiliar "actual":
        //   - actual arranca en la cima
        //   - mientras actual != null seguimos bajando
        //   - actual = actual.siguiente salta al nodo de abajo
        for (Nodo actual = cima; actual != null; actual = actual.siguiente) {
            System.out.print(actual.dato + " ");
        }

        System.out.println(); // Salto de línea
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si no hay nodos, false en caso contrario
     */
    public boolean isEmpty() {
        return cima == null;
    }

    /**
     * Consulta el valor que está en la cima SIN desvincularlo (operación peek).
     *
     * @return el valor en la cima, o -1 si la pila está vacía
     */
    public int peek() {
        if (cima != null) {
            System.out.println("Consultaste: " + cima.dato);
            return cima.dato;
        }
        System.out.println("Pila dinamica vacia! No hay cima que consultar.");
        return -1;
    }
}