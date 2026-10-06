package Unidad1y2.TorresHanoi;

public class TorresHanoi {

    private static int contadorLlamadas = 0;
    private static int contadorMovimientos = 0;

    public static void resolverHanoi(int n, char origen, char auxiliar, char destino) {
        contadorLlamadas++;

        // Caso base: Si solo queda 1 disco, lo mueve directo
        if (n == 0) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return; // Freno para no colapsar la memoria.
        }

        // 1. Mover n-1 discos del origen al auxiliar (acomoda el disco mas grande al poste C)
        resolverHanoi(n - 1, origen, destino, auxiliar);

        // 2. Mover el disco grande del origen al destino
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
        contadorMovimientos++;

        // 3. Mover los n-1 discos del auxiliar al destino (acomoda los discos restantes)
        resolverHanoi(n - 1, auxiliar, origen, destino);
    }

    public static void main(String[] args) {
        for (int discos = 3; discos <= 5; discos++) {

            System.out.println("\nResolviendo Torres de Hanói para " + discos + " discos:\n");
            resolverHanoi(discos, 'A', 'B', 'C');

            System.out.printf("\nLlamadas (discos=%d): %d", discos, contadorLlamadas);
            System.out.printf("\nMovimientos (discos=%d): %d", discos, contadorMovimientos);

            contadorLlamadas = 0;
            contadorMovimientos = 0;
        }
    }
}