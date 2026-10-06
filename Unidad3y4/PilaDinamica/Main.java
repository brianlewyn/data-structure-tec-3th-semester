package Unidad3y4.PilaDinamica;

/**
 * Clase de prueba para la PilaDinamica.
 * Se prueban todos los métodos: push, pop, show, isEmpty y peek.
 * También se prueban los casos extremos (pila vacía).
 */
public class Main {
    public static void main(String[] args) {

        // 1. Creamos nuestra pila vacía usando el constructor
        PilaDinamica pila = new PilaDinamica();

        // ---------- 1. Estado inicial ----------
        System.out.println("=== ESTADO INICIAL ===");
        System.out.println("¿Esta vacia? " + pila.isEmpty());   // true
        pila.show();                                            // (nada)

        // ---------- 2. Peek con pila vacía ----------
        System.out.println("\n=== PEEK CON PILA VACIA ===");
        pila.peek();                                            // Pila dinamica vacia!

        // ---------- 3. Pop con pila vacía ----------
        System.out.println("\n=== POP CON PILA VACIA ===");
        pila.pop();                                             // Pila dinamica vacia!

        // ---------- 4. Insertar elementos (push) ----------
        System.out.println("\n=== INSERTANDO ELEMENTOS (PUSH) ===");
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.push(50);

        // Mostramos la torre: 50 40 30 20 10
        // El 50 está en la cima porque fue el último en entrar
        pila.show();

        // ---------- 5. Consultar la cima con peek ----------
        System.out.println("\n=== PEEK EN LA CIMA ===");
        pila.peek();                                            // 50

        // ---------- 6. Sacar elementos (pop) ----------
        System.out.println("\n=== SACANDO ELEMENTOS (POP) ===");
        pila.pop();   // 50
        pila.pop();   // 40
        pila.show();  // 30 20 10

        // ---------- 7. Vaciar la pila por completo ----------
        System.out.println("\n=== VACIANDO LA PILA ===");
        pila.pop();   // 30
        pila.pop();   // 20
        pila.pop();   // 10

        // ---------- 8. Verificar isEmpty después de vaciar ----------
        System.out.println("\n=== VERIFICANDO ESTADO FINAL ===");
        System.out.println("¿Esta vacia? " + pila.isEmpty());   // true
        pila.show();                                            // (nada)

        // ---------- 9. Pop en pila ya vacía ----------
        System.out.println("\n=== POP EN PILA VACIA ===");
        pila.pop();                                             // Pila dinamica vacia!
    }
}