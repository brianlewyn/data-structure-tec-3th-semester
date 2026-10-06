package Unidad3y4.PilaDinamica;

public class PilaDinamica {
    Nodo cima; // Declarando un nodo llamado cima. El control remoto que apunta al elemento...

    // Contructor de la pila
    public PilaDinamica() {
        this.cima = null;
    }

    // Metodo PUSH (meter elemento arriba)
    public void push(int x) {
        Nodo nuevo = new Nodo(x); // 1. Creamos un nuevo nodo. Ojo, tiene las mismas pripiedades...
        nuevo.siguiente = cima; // 2. Como tiene los mismas propiedades que nodo
                                // El nuevo atrapa el viejo de la cima
        cima = nuevo; // 3. Actualiza la cima. El nuevo se convierte oficialmente.
    }

    // nota: nuevo.siguiente es la flecha
    // Metodo POP (sacar el elemento de arriba)
    public void pop() {
        if (cima != null) {
            System.out.println("Sacaste de la pila: " + cima.dato);
            cima = cima.siguiente; // La cima se baja al siguiente nodo
        } else {
            cima = null;
        }
    }

    // 3. Mostrar la pila
    public void show() {
        System.out.print("Pila actual: ");
        for (Nodo actual = cima; actual != null; actual = actual.siguiente) {
            System.out.print(actual.dato + " ");
        }
        System.out.println();
    }
}
