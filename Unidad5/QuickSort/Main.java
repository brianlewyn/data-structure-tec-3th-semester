package Unidad5.QuickSort;

public class Main {

    public static void ejecutarEscenario(String titulo, int[] arreglo) {
        System.out.printf("======== %s (n=%d) ========\n", titulo, arreglo.length);
        System.out.println();

        System.out.print("Arreglo original: ");
        QuickSort.imprimirArreglo(arreglo);

        QuickSort.reiniciarContadores();
        QuickSort.ordenar(arreglo, 0, arreglo.length - 1);

        System.out.print("Arreglo ordenado: ");
        QuickSort.imprimirArreglo(arreglo);

        // ---- Métricas ----
        System.out.println();
        System.out.println("Comparaciones:       " + QuickSort.comparaciones);
        System.out.println("Intercambios:        " + QuickSort.intercambios);
        System.out.println("Llamadas recursivas: " + QuickSort.llamadas);
        System.out.println();
    }

    public static void main(String[] args) {

        // ---- Arreglo de ejemplo de clase ----
        int[] arreglo = {6, 1, 5, 8, 3, 2, 7, 4};

        // ---- Mejor caso teórico: particiones balanceadas ----
        // El último elemento de cada subarreglo tiende a ser
        // su mediana, produciendo particiones equilibradas.
        // Complejidad temporal: O(n log n).
        int[] mejor = {1, 3, 2, 5, 4, 8, 9, 7, 10, 6};

        // ---- Caso promedio: entrada aleatoria ----
        // Representa una muestra de una distribución aleatoria.
        // Las particiones pueden ser equilibradas o desequilibradas.
        // Complejidad esperada: O(n log n).
        int[] promedio = {7, 3, 9, 1, 5, 8, 2, 6, 10, 4};

        // ---- Peor caso teórico: particiones desequilibradas ----
        // Al utilizar el último elemento como pivote,
        // el arreglo ascendente provoca particiones de tamaños
        // 0 y n-1 en cada nivel de recursividad.
        // Complejidad temporal: O(n²).
        int[] peor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // ---- Ejecución de los escenarios ----
        ejecutarEscenario("Ejemplo de Arreglo de Clase", arreglo);
        ejecutarEscenario("Mejor Caso Teórico", mejor);
        ejecutarEscenario("Caso Promedio (Muestra Aleatoria)", promedio);
        ejecutarEscenario("Peor Caso Teórico", peor);
    }
}