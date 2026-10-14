package Unidad3y4.ColaEstatica;

public class Main {
    public static void main(String[] args) {
        // ============================================
        // 1. Crear la cola estática (capacidad = 3)
        // ============================================
        ColaEstatica cola = new ColaEstatica(3);

        // ============================================
        // 2. Insertar 3 elementos (la cola se llena)
        // ============================================
        System.out.println(">> Insertando 10, 20 y 30...");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        System.out.print("Estado actual: ");
        cola.show();

        // ============================================
        // 3. Atender (eliminar) el primer elemento
        // ============================================
        System.out.println("\n>> Atendiendo un elemento...");
        cola.dequeue();

        System.out.print("Estado actual: ");
        cola.show();

        // ============================================
        // 4. Intentar insertar un cuarto elemento
        //    Aquí se evidencia el error de la cola
        //    estática NO circular: aunque hay espacio
        //    libre al inicio (posición 0), "fin" ya
        //    llegó al final del arreglo y no se reutiliza.
        // ============================================
        System.out.println("\n>> Intentando insertar 40 (debería fallar)...");
        cola.enqueue(40);

        System.out.print("Estado actual: ");
        cola.show();

        // ============================================
        // 5. Atender los elementos restantes
        // ============================================
        System.out.println("\n>> Atendiendo los elementos restantes...");
        cola.dequeue();
        cola.dequeue();

        System.out.print("Estado final: ");
        cola.show();
    }
}