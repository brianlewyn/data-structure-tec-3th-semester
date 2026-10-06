package Unidad3y4.PilaSimple;

public class PilaSimple {
    private int[] datos = new int[5]; // Capacidad fija de 5
    private int tope = -1; // Empieza vacia

    // 1. Meter dato (Push): llenar la pila
    public void push(int x) {
        if (tope < datos.length - 1) {
            tope++;
            datos[tope] = x;
            System.out.println("Metiste: " + x);
        } else {
            System.out.println("Pila llena!");
        }
    }

    // 2. Sacar dato (Pop)
    public void pop() {
        if (tope >= 0) {
            System.out.println("Sacaste: " + datos[tope]);
            tope--;
        } else {
            System.out.println("Pila vacia!");
        }
    }

    // 3. Ver la pila
    public void show() {
        System.out.print("Pila actual: ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }
}
