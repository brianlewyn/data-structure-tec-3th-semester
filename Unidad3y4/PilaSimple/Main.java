package Unidad3y4.PilaSimple;

/**
 * Clase de prueba para la PilaSimple.
 * Se prueban todos los métodos: push, pop, show, isEmpty, isFull y peek.
 */
public class Main {
    public static void main(String[] args) {

        PilaSimple pila = new PilaSimple();

        // ---------- 1. Estado inicial ----------
        System.out.println("=== Estado inicial ===");
        System.out.println("¿Esta vacia? " + pila.isEmpty());   // true
        System.out.println("¿Esta llena? " + pila.isFull());    // false
        pila.show();                                            // [VACIA]

        // ---------- 2. Probar peek con pila vacía ----------
        System.out.println("\n=== Peek con pila vacia ===");
        pila.peek();                                            // Pila vacia!

        // ---------- 3. Probar pop con pila vacía ----------
        System.out.println("\n=== Pop con pila vacia ===");
        pila.pop();                                             // Pila vacia!

        // ---------- 4. Insertar elementos (push) ----------
        System.out.println("\n=== Insertando elementos ===");
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.push(50);   // Aquí la pila se llena (capacidad = 5)
        pila.show();       // 10 20 30 40 50

        // ---------- 5. Verificar isFull ----------
        System.out.println("\n=== Verificando pila llena ===");
        System.out.println("¿Esta llena? " + pila.isFull());       // true

        // ---------- 6. Intentar push en pila llena (overflow) ----------
        System.out.println("\n=== Intentando push en pila llena ===");
        pila.push(60);                                          // Pila llena!

        // ---------- 7. Consultar la cima con peek ----------
        System.out.println("\n=== Peek en la cima ===");
        pila.peek();                                              // 50

        // ---------- 8. Sacar elementos (pop) ----------
        System.out.println("\n=== Sacando elementos ===");
        pila.pop();   // 50
        pila.pop();   // 40
        pila.show();  // 10 20 30

        // ---------- 9. Verificar isEmpty después de varios pop ----------
        System.out.println("\n=== Vaciar la pila por completo ===");
        pila.pop();   // 30
        pila.pop();   // 20
        pila.pop();   // 10
        System.out.println("¿Esta vacia? " + pila.isEmpty());   // true
        pila.show();                                            // [VACIA]

        // ---------- 10. Intentar pop en pila vacía (underflow) ----------
        System.out.println("\n=== Pop en pila vacia ===");
        pila.pop();                                             // Pila vacia!
    }
}