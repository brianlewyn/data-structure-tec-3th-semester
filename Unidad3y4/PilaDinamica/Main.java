package Unidad3y4.PilaDinamica;

public class Main {
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();

        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.show();

        pila.pop(); // Sacar el 30
        pila.show();
    }
}
