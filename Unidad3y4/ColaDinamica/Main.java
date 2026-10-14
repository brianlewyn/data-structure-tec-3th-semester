package Unidad3y4.ColaDinamica;

public class Main {
    public static void main(String[] args) {
        // ============================================
        // 1. Crear la cola dinámica (inicialmente vacía)
        // ============================================
        ColaDinamica cola = new ColaDinamica();

        // ============================================
        // 2. Insertar 5 elementos
        // ============================================
        System.out.println(">> Insertando 10, 20, 30, 40 y 50...");
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);
        cola.encolar(50);

        System.out.print("Estado actual: ");
        cola.mostrar();

        // ============================================
        // 3. Atender (eliminar) los dos primeros
        // ============================================
        System.out.println("\n>> Atendiendo dos elementos...");
        System.out.println("Atendido: " + cola.desencolar());
        System.out.println("Atendido: " + cola.desencolar());

        System.out.print("Estado actual: ");
        cola.mostrar();

        // ============================================
        // 4. Insertar 2 elementos más
        //    (la cola dinámica no tiene límite de capacidad)
        // ============================================
        System.out.println("\n>> Insertando 60 y 70...");
        cola.encolar(60);
        cola.encolar(70);

        System.out.print("Estado actual: ");
        cola.mostrar();

        // ============================================
        // 5. Consultar el frente y el tamaño
        // ============================================
        System.out.println("\n>> Consultando frente y tamaño...");
        System.out.println("Valor al frente de la cola: " + cola.peek());
        System.out.println("Tamaño de la cola dinámica: " + cola.contarElementos());

        // ============================================
        // 6. Vaciar la cola para comprobar el caso vacío
        // ============================================
        System.out.println("\n>> Vaciando la cola por completo...");
        while (!cola.estaVacia()) {
            cola.desencolar();
        }

        System.out.print("Estado final: ");
        cola.mostrar();
        System.out.println("¿Está vacía? " + cola.estaVacia());
    }
}