package Unidad3y4.ColaEstaticaCircular;

public class Main {
    public static void main(String[] args) {
        // ============================================
        // 1. Crear la cola circular (capacidad = 7)
        // ============================================
        ColaEstaticaCircular cola = new ColaEstaticaCircular(7);

        // ============================================
        // 2. Insertar 5 elementos
        // ============================================
        System.out.println(">> Insertando 10, 20, 30, 40 y 50...");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);
        cola.enqueue(50);

        System.out.print("Estado actual: ");
        cola.show();

        // ============================================
        // 3. Atender (eliminar) los dos primeros
        // ============================================
        System.out.println("\n>> Atendiendo dos elementos...");
        cola.dequeue();
        cola.dequeue();

        System.out.print("Estado actual: ");
        cola.show();

        // ============================================
        // 4. Insertar 2 elementos más
        //    Gracias a la circularidad, "fin" da la vuelta
        //    y reutiliza las posiciones liberadas por los
        //    dequeue anteriores. Sin circularidad, aquí
        //    daría error de "cola llena".
        // ============================================
        System.out.println("\n>> Insertando 60 y 70 (reutilizando espacio)...");
        cola.enqueue(60);
        cola.enqueue(70);

        System.out.print("Estado actual: ");
        cola.show();

        // ============================================
        // 5. Consultar el frente sin eliminarlo
        // ============================================
        System.out.println("\n>> Consultando el frente...");
        System.out.println("Valor al frente de la cola: " + cola.peek());

        // ============================================
        // 6. Vaciar la cola para comprobar el caso vacío
        // ============================================
        System.out.println("\n>> Vaciando la cola por completo...");
        while (!cola.isEmpty()) {
            cola.dequeue();
        }

        System.out.print("\nEstado final: ");
        cola.show();
        System.out.println("¿Está vacía? " + cola.isEmpty());
    }
}