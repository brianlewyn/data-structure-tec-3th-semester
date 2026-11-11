package Unidad5.ShellSort;

public class Main {

    /**
     * Ejecuta un escenario: muestra título, arreglo original,
     * ordena con Shell Sort (sobre una copia) y muestra métricas.
     */
    public static void ejecutarEscenario(String titulo, int[] arreglo) {
        System.out.printf("======== %s (n=%d) ========\n", titulo, arreglo.length);
        System.out.println();

        System.out.print("Arreglo original: ");
        ShellSort.imprimirArreglo(arreglo);

        ShellSort.reiniciarContadores();
        ShellSort.ordenar(arreglo);

        System.out.print("Arreglo ordenado: ");
        ShellSort.imprimirArreglo(arreglo);

        // ---- Métricas ----
        System.out.println();
        System.out.println("Comparaciones:       " + ShellSort.comparaciones);
        System.out.println("Intercambios:        " + ShellSort.intercambios);
        System.out.println();
    }

    public static void main(String[] args) {

        // ---- Arreglo de ejemplo de clase ----
        int[] arreglo = {6, 1, 5, 8, 3, 2, 7, 4};

        // ---- Mejor caso teórico: arreglo previamente ordenado ----
        // No requiere desplazamientos de elementos.
        // Complejidad temporal: O(n log n) para la secuencia n/2, n/4, ..., 1.
        int[] mejor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // ---- Caso promedio: muestra de entrada aleatoria ----
        // Representa una distribución aleatoria de los elementos.
        // Permite observar el comportamiento experimental del algoritmo.
        // El promedio estadístico requiere múltiples ejecuciones.
        int[] promedio = {7, 3, 9, 1, 5, 8, 2, 10, 4, 6};

        // ---- Peor caso teórico: arreglo inversamente ordenado ----
        // Presenta un gran desorden inicial y permite evaluar
        // el comportamiento de Shellsort ante esta distribución.
        // No garantiza el peor caso teórico del algoritmo.
        int[] peor = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // ---- Ejecución de los escenarios ----
        ejecutarEscenario("Ejemplo de Arreglo de Clase", arreglo);
        ejecutarEscenario("Mejor Caso Teórico", mejor);
        ejecutarEscenario("Caso Promedio (Muestra Aleatoria)", promedio);
        ejecutarEscenario("Peor caso teórico", peor);
    }
}